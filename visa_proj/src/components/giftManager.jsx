import React, { Component } from 'react';
import axios from 'axios';
import { Card, Button } from 'react-bootstrap';
import '../css/giftManager.css';

class GiftManager extends Component {

    constructor(props) {
        super(props);
        this.state = {
            gifts : []
        }
    }

    componentDidMount() {
        this.getGifts();
    }

    getGifts() {
        const jwt = localStorage.getItem("jwt");
        axios.get("http://localhost:8080/api/v1/gifts/", { headers: { Authorization : `Bearer ${jwt}` }})
        .then(response => response.data)
        .then((data) => {
            this.setState({gifts: data});
        });
    }
    
    deleteGift = (giftId) => {
        const jwt = localStorage.getItem("jwt")
        axios.delete("http://localhost:8080/api/v1/gifts/"+giftId, { headers: {Authorization: `Bearer ${jwt}`}})
        .then(response => {
            if(response.data != null) {
                alert("Gift deleted successfully!");
                this.setState({
                    gifts: this.state.gifts.filter(gift => gift.Id !== giftId)
                });
                //this.reloadPage();
            }
        });

        let id = '';
        let amount = '';
        for(let i = 0; i < this.state.gifts.length; i++) {
            if(giftId === this.state.gifts[i].giftId) {
                id = this.state.gifts[i].giftCampaignId;
                amount = this.state.gifts[i].amount;
            }
        }
        console.log(id);
        console.log(amount);

        let campaign = {};
        axios.get("http://localhost:8080/api/v1/gift_campaigns/"+id, { headers: { Authorization : `Bearer ${jwt}` }})
            .then(response => {
                campaign = response.data;
                console.log("total: "+campaign.giftTotal);
                console.log("amount: "+amount);
                campaign.giftTotal = parseInt(campaign.giftTotal) - parseInt(amount);
                campaign.totalGifters = campaign.totalGifters - 1;
                console.log("total: "+campaign.giftTotal);
                console.log("amount: "+amount);
                axios.put("http://localhost:8080/api/v1/gift_campaigns/"+id, campaign, { headers: { Authorization: `Bearer ${jwt}` }})
                .then(response => {
                    if(response.data != null) {
                        this.reloadPage();
                    }
                });
            });
    }

    loadGifts() {
        const gift = this.state.gifts;
        const user_gifts = [];
        for (let i = 0; i < gift.length; i++) {
            const card = (
            <Card>
                <Card.Body>
                    <Card.Title>{gift[i].giftMessage}</Card.Title>
                    <Card.Subtitle>Amount Gifted: ${gift[i].amount}</Card.Subtitle>
                    <Card.Text>
                        <h6>Gifted: {gift[i].giftDate}</h6>
                        <Button id="log_button" variant="secondary" href={"/visahackathon/#/editGift/"+gift[i].giftId} active>
                        Edit Gift
                        </Button>
                        <Button id="log_button" variant="secondary" onClick={this.deleteGift.bind(this, gift[i].giftId)} active>
                        Delete Gift
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