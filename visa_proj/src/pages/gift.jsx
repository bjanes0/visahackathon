import React, { Component } from 'react';
import { Form, Button } from 'react-bootstrap';
import axios from 'axios';
import '../css/gift.css';


class Gift extends Component {

    constructor(props) {
        super(props);
        this.state = {
            giftCampaignId: '',
            amount: '',
            giftMessage: '',
            userId: '',
            giftDate: new Date()
        }
        this.addGift = this.addGift.bind(this);
        this.getUser = this.getUser.bind(this);
        this.giftChange = this.giftChange.bind(this);
    }

    getUser() {
        const jwt = localStorage.getItem("jwt");
        axios.get("http://localhost:8080/auth_user", { headers: { Authorization : `Bearer ${jwt}` }})
        .then(res => this.setState({
            userId: res.data.userId
        })).catch(err => {
            localStorage.removeItem("jwt");
        })
        return this.state.user;
    }

    componentDidMount() {
        this.getUser();
        const {id} = this.props.location;
        this.setState({giftCampaignId: id});
    }

    giftChange = event => {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    addGift() {
        const jwt = localStorage.getItem("jwt");
        console.log(this.state.userId);

        axios.post("http://localhost:8080/api/v1/gifts/"+this.state.userId, this.state, { headers: { Authorization : `Bearer ${jwt}` }})
            .then(response => {
                if(response.data != null) {
                    this.props.history.push("/my-gifts");
                    alert("Gift created successfully!");
                }
            })

        let campaign = {};
        axios.get("http://localhost:8080/api/v1/gift_campaigns/"+this.state.giftCampaignId, { headers: { Authorization : `Bearer ${jwt}` }})
            .then(response => {
                campaign = response.data;
                console.log(campaign);
                campaign.giftTotal = parseInt(this.state.amount) + parseInt(campaign.giftTotal);
                campaign.totalGifters = campaign.totalGifters + 1;
                axios.put("http://localhost:8080/api/v1/gift_campaigns/"+this.state.giftCampaignId, campaign, { headers: { Authorization: `Bearer ${jwt}` }})
                .then(response => {
                    if(response.data != null) {
                        this.props.history.push("/my-gifts");
                        this.reloadPage();
                    }
                });
            });
    }

    reloadPage() {
        window.location.reload();
    }

    render() {

        return (
    <React.Fragment>
        <div id="top_div">
            <h2>Add Your Gift!</h2>
            <Form>
                <Form.Group>
                    <Form.Label>The name you'd like to sign</Form.Label>
                    <Form.Control type="search" placeholder="Enter your print name you'd like to sign" />
                </Form.Group>
                <Form.Group>
                    <Form.Label>The amount you'd like to gift</Form.Label>
                    <Form.Control name="amount" value={this.state.amount} onChange={this.giftChange} type="search" placeholder="Enter your gift amount" />
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
                    <Button id="next_button_gift" onClick={this.addGift} variant="secondary" size="lg">
                        Next<i className="arrow right"></i>
                    </Button>
                </Form.Group>
            </Form>
        </div>
    </React.Fragment >
    )}}

export default Gift;