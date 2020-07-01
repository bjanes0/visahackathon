import React, { Component } from 'react';
import { Form, Button } from 'react-bootstrap';
import axios from 'axios';
import '../css/edit.css';


class EditGift extends Component {

    constructor(props) {
        super(props);
        this.state = {
            giftCampaignId: '',
            amount: '',
            userId: '',
            giftDate: '',
            giftId: '',
            giftMessage: ''
        };
        this.submit = this.submit.bind(this);
        this.giftChange = this.giftChange.bind(this);
        this.getGiftId = this.getGiftId.bind(this);
        this.getGift = this.getGift.bind(this);
    }

    componentDidMount() {
        this.getGift();
    }

    getGiftId() {
        const loc = window.location.href;
        let id = "";
        for (let i = loc.length - 1; i > 0; i--) {
            if (loc[i] === "/") {
                break;
            }
            id = id + loc[i];
        }
        return id.split("").reverse().join("");
    }

    getGift() {
        const id = this.getGiftId();
        this.setState({giftId: id});
        const jwt = localStorage.getItem("jwt");
        axios.get("http://localhost:8080/api/v1/gifts/"+id, { headers: { Authorization : `Bearer ${jwt}` }})
        .then(response => response.data)
        .then((data) => {
            this.setState({
                giftMessage: data.giftMessage,
                giftCampaignId: data.giftCampaignId,
                amount: data.amount,
                userId: data.userId,
                giftDate: data.giftDate,
                giftId: data.giftId
            });
        });
    }

    giftChange = event => {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    submit() {

        const jwt = localStorage.getItem("jwt");
        axios.put("http://localhost:8080/api/v1/gifts/"+this.state.giftId, this.state, { headers: {Authorization: `Bearer ${jwt}`}})
        .then(response => {
            if(response.data != null) {
                alert("Gift updated successfully!");
                this.props.history.push("/my-gifts");
                this.reloadPage();
            }
        })
    }

    reloadPage() {
        window.location.reload();
    }

    render() {
    return (
    <React.Fragment>
        <div id="top_div">
            <h2>Edit Your Gift!</h2>
            <Form>
                <Form.Group>
                    <Form.Label>The name you'd like to sign</Form.Label>
                    <Form.Control placeholder="Enter your print name you'd like to sign" />
                </Form.Group>
                <Form.Group>
                    <Form.Label>The message you'd like to include on the card</Form.Label>
                    <Form.Control name="giftMessage" value={this.state.giftMessage} onChange={this.giftChange} as="textarea" placeholder="Enter your message here" rows="5" />
                </Form.Group>
                <Form.Group>
                    <Form.Label>Attach your signature</Form.Label>
                    <Form.File />
                </Form.Group>
                <Form.Group>
                    <Button id="save_button" onClick={this.submit} variant="secondary" size="lg">
                        Save<i className="arrow right"></i>
                    </Button>
                </Form.Group>
            </Form>
        </div>
    </React.Fragment >
    )}}

export default EditGift;