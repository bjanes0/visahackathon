import React, { Component } from 'react';
import { Card, Button } from 'react-bootstrap';
import axios from 'axios';
import '../css/giftManager.css';
import img1 from '../assets/pic1.jpg'

class GiftManager extends Component {

    constructor(props) {
        super(props);
        this.state = {
            giftCampaigns : []
        }
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
        });
    }
    
    deleteGift = (giftCampaignId) => {
        const jwt = localStorage.getItem("jwt")
        axios.delete("http://localhost:8080/api/v1/gift_campaigns/"+giftCampaignId, { headers: {Authorization: `Bearer ${jwt}`}})
        .then(response => {
            if(response.data != null) {
                alert("Gift deleted successfully!");
                this.setState({
                    giftCampaigns: this.state.giftCampaigns.filter(giftCampaign => giftCampaign.Id !== giftCampaignId)
                });
                this.reloadPage();
            }
        })
    }

    loadGifts() {
        const giftCampaign = this.state.giftCampaigns;
        const user_gifts = [];
        for (let i = 0; i < giftCampaign.length; i++) {
            const card = (
            <Card>
                <Card.Body>
                    <Card.Title>{giftCampaign[i].giftCampaignName}</Card.Title>
                    <Card.Subtitle>Total Gift Amount: ${giftCampaign[i].giftTotal}</Card.Subtitle>
                    <Card.Text>
                        <h6>Sent To: {giftCampaign[i].recipientEmail}</h6>
                        <Button id="log_button" variant="secondary" href={"/visahackathon/#/editGift/"+giftCampaign[i].giftCampaignId} active>
                        Manage Gift Campaign
                        </Button>
                        <Button className="m-1" id="log_button" variant="secondary" href="/visahackathon/#/view" active>
                         View Gift Cmapaign
                        </Button>
                        <Button id="log_button" variant="secondary" onClick={this.deleteGift.bind(this, giftCampaign[i].giftCampaignId)} active>
                        Delete Gift Campaign
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