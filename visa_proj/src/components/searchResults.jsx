import React, { Component } from 'react';
import { Card, Button } from 'react-bootstrap';
import axios from  'axios';
import '../css/giftManager.css';
import { Search } from '../pages/search';

class SearchResults extends Component {

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
        axios.get("http://localhost:8080/api/v1/gift_campaigns/", { headers: { Authorization : `Bearer ${jwt}` }})
        .then(response => response.data)
        .then((data) => {
            this.setState({gifts: data});
        });
    }

    loadGifts() {
        const gift = this.state.gifts;
        const user_gifts = [];
        for (let i = 0; i < gift.length; i++) {
            const card = (
            <Card>
                <Card.Body>
                    <Card.Title>{gift[i].giftCampaignName}</Card.Title>
                    <Card.Subtitle>Created By: Person 1</Card.Subtitle>
                    <Card.Text>
                        <h6>Sent To: {gift[i].recipientEmail}</h6>
                        <Button className="m-1" id="log_button" variant="secondary" href={"/visahackathon/#/view/"+gift[i].giftCampaignId}>
                            View Gift
                        </Button>
                    </Card.Text>
                </Card.Body>
            </Card>   
            )
            user_gifts.push(card);
        }
        return user_gifts;
    }
    render() {
        return (
            <React.Fragment>
                <div id="manage_card">
                    <p>{this.state.gifts.length} gifts found</p>
                    {this.loadGifts()}
                </div>
            </React.Fragment>
        );
    }
}

export default SearchResults;