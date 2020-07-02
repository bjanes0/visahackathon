import React, { Component } from 'react';
import { Form, Button } from 'react-bootstrap';
import axios from 'axios';
import '../css/edit.css';


class EditGiftCampaign extends Component {

    constructor(props) {
        super(props);
        this.state = {
            campaignId: '',
            giftCampaignName: '', 
            recipientEmail: ''
        };
        this.submit = this.submit.bind(this);
        this.campaignChange = this.campaignChange.bind(this);
        this.getGiftCampaignId = this.getGiftCampaignId.bind(this);
        this.getCampaign = this.getCampaign.bind(this);
    }

    componentDidMount() {
        this.getCampaign();
    }

    getGiftCampaignId() {
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

    getCampaign() {
        const id = this.getGiftCampaignId();
        this.setState({campaignId: id});
        const jwt = localStorage.getItem("jwt");
        axios.get("http://localhost:8080/api/v1/gift_campaigns/"+id, { headers: { Authorization : `Bearer ${jwt}` }})
        .then(response => response.data)
        .then((data) => {
            this.setState({
                giftCampaignName: data.giftCampaignName,
                recipientEmail: data.recipientEmail
            });
        });
    }

    campaignChange = event => {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    submit() {
        const GiftCampaign = {
            giftCampaignName: this.state.giftCampaignName,
            recipientEmail: this.state.recipientEmail,
            startDate: this.state.startDate
        }
        const jwt = localStorage.getItem("jwt");
        axios.put("http://localhost:8080/api/v1/gift_campaigns/"+this.state.campaignId, GiftCampaign, { headers: {Authorization: `Bearer ${jwt}`}})
        .then(response => {
            if(response.data != null) {
                alert("Gift campaign updated successfully!");
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
            <h2>Edit Your Gift Campaign!</h2>
            <Form>
                <Form.Group>
                    <Form.Label>Gift Campaign Name</Form.Label>
                    <Form.Control name="giftCampaignName" value={this.state.giftCampaignName} onChange={this.campaignChange} placeholder="Enter the name of your gift campaign" />
                </Form.Group>
                <Form.Group>
                    <Form.Label>Gift Recipient's Email</Form.Label>
                    <Form.Control name="recipientEmail" value={this.state.recipientEmail} onChange={this.campaignChange} placeholder="Enter the recipient's name" />
                </Form.Group>
                <Form.Group>
                    <Button id="save_button">Change Template</Button>
                </Form.Group>
                <Form.Group>
                    <Button id="next_button_gift" onClick={this.submit} variant="secondary" size="lg">
                        Save<i className="arrow right"></i>
                    </Button>
                </Form.Group>
            </Form>
        </div>
    </React.Fragment >
    )}}

export default EditGiftCampaign;