import React, { Component } from 'react';
import { Card, Button } from 'react-bootstrap';
import axios from 'axios';
import '../css/giftManager.css';

class GiftManager extends Component {

    constructor(props) {
        super(props);
        this.state = {
            giftCampaigns : []
        }
        this.getGifts = this.getGifts.bind(this);
    }

    componentDidMount() {
        this.getGifts();
    }

    getGifts() {
        const jwt = localStorage.getItem("jwt");
        axios.get("http://localhost:8080/api/v1/gift_campaigns/", { headers: { Authorization : `Bearer ${jwt}` }})
        .then(response => response.data)
        .then((data) => {
            this.setState({giftCampaigns: data});
            for(let i = 0; i < this.state.giftCampaigns.length; i++) {
                if(this.state.giftCampaigns[i].endDate != null) {
                    document.getElementById(this.state.giftCampaigns[i].giftCampaignId).style.backgroundColor = "gray";
                    document.getElementById(this.state.giftCampaigns[i].giftCampaignId).style.pointerEvents = "none";
                }
            }
        });
    }
    
    deleteGift = (giftCampaignId) => {
        const jwt = localStorage.getItem("jwt")
        axios.delete("http://localhost:8080/api/v1/gift_campaigns/"+giftCampaignId, { headers: {Authorization: `Bearer ${jwt}`}})
        .then(response => {
            if(response.data != null) {
                alert("Gift campaign deleted successfully!");
                this.setState({
                    giftCampaigns: this.state.giftCampaigns.filter(giftCampaign => giftCampaign.Id !== giftCampaignId)
                });
                this.reloadPage();
            }
        })
    }

    sendGift = campaignId => {
        let campaign = {};
        const jwt = localStorage.getItem("jwt");
        axios.get("http://localhost:8080/api/v1/gift_campaigns/"+campaignId, { headers: {Authorization: `Bearer ${jwt}`}})
            .then(response => {
                if(response.data != null) {
                    campaign = response.data;
                }
                campaign.endDate = new Date();
                axios.put("http://localhost:8080/api/v1/gift_campaigns/"+campaignId, campaign, { headers: {Authorization: `Bearer ${jwt}`}})
                .then(response => {
                    if(response.data != null) {
                        alert("Gift sent successfully!");
                        this.reloadPage();
                    }
                });
            });
    }

    loadGifts() {
        const giftCampaign = this.state.giftCampaigns;
        const user_gifts = [];
        for (let i = 0; i < giftCampaign.length; i++) {
            const card = (
            <Card id={giftCampaign[i].giftCampaignId}>
                <Card.Body>
                    <Card.Title>{giftCampaign[i].giftCampaignName}</Card.Title>
                    <Card.Subtitle>Total Gift Amount: ${giftCampaign[i].giftTotal}</Card.Subtitle>
                    <Card.Text>
                        <h6>Contributers: {giftCampaign[i].totalGifters}</h6>
                        <h6>Sent To: {giftCampaign[i].recipientEmail}</h6>
                        <Button id="log_button" variant="secondary" href={"/visahackathon/#/editGiftCampaign/"+giftCampaign[i].giftCampaignId} active>
                        Edit Gift Campaign
                        </Button>
                        <Button className="m-1" id="log_button" variant="secondary" href={"/visahackathon/#/view/"+giftCampaign[i].giftCampaignId} active>
                         View Gift Campaign
                        </Button>
                        <Button id="log_button" variant="secondary" onClick={this.deleteGift.bind(this, giftCampaign[i].giftCampaignId)} active>
                        Delete Gift Campaign
                        </Button>
                        <Button onClick={this.sendGift.bind(this, giftCampaign[i].giftCampaignId)} className="m-1" id="log_button" variant="secondary" active>
                        Send Gift
                        </Button>
                    </Card.Text>
                </Card.Body>
            </Card>);
            user_gifts.push(card);
        }
        return user_gifts;
    }

    reloadPage () {
        window.location.reload()
    }

    render() {
        return (
            <React.Fragment>
                <div id="manage_card">
                    {this.loadGifts()}
                </div>
            </React.Fragment>
        );
    }
}

export default GiftManager;