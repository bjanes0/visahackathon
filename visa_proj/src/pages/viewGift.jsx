import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import { Container, Button, Row, Col, Image } from 'react-bootstrap';
import sampleCard from '../assets/sampleCard.png';
import img1 from '../assets/pic1.jpg';
import axios from 'axios';
import '../css/viewGift.css';

class ViewGift extends Component {

    constructor(props) {
        super(props);
        this.state = {
            giftCampaign: {},
            campaignGifts: []
        }
    }

    componentDidMount() {
        this.getGiftInfo();
        this.campaignGifts();
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

    getGiftInfo() {
        const id = this.getGiftId();
        const jwt = localStorage.getItem("jwt");
        axios.get("http://localhost:8080/api/v1/gift_campaigns/" + id, { headers: { Authorization: `Bearer ${jwt}` } })
            .then(response => response.data)
            .then((data) => {
                this.setState({ giftCampaign: data });
            });
    }

    campaignGifts() {
        let camp_gift = {};
        const id = this.getGiftId();
        const jwt = localStorage.getItem("jwt");
        const messages = [];
        axios.get("http://localhost:8080/api/v1/gifts_in_campaign/"+id, { headers: { Authorization: `Bearer ${jwt}` } })
        .then(response => {
            camp_gift = response.data;
        
            for(let i = 0; i < camp_gift.length; i+=3) {
                console.log("loop")
                console.log(camp_gift.length);
                if(camp_gift.length - i >= 3) {
                    const view = (
                        <Row id="view" style={{top: 250 + (i*20)}} className="row justify-content-md-center">
                            <Col>
                                <h6>{camp_gift[i].giftMessage}</h6>
                            </Col>
                            <Col>
                                <h6>{camp_gift[i+1].giftMessage}</h6>
                            </Col>
                            <Col>
                                <h6>{camp_gift[i+2].giftMessage}</h6>
                            </Col>
                        </Row>
                    );
                    messages.push(view)
                }
                if(camp_gift.length -i == 2) {
                    const view = (
                        <Row id="view" style={{top: 250 + (i*20)}} className="row justify-content-md-center">
                            <Col>
                                <h6>{camp_gift[i].giftMessage}</h6>
                            </Col>
                            <Col>
                                <h6>{camp_gift[i+1].giftMessage}</h6>
                            </Col>
                        </Row>
                    );
                    messages.push(view)
                }
                if(camp_gift.length - i == 1) {
                    const view = (
                        <Row id="view" style={{top: 250 + (i*20)}} className="row justify-content-md-center">
                            <Col>
                                <h6>{camp_gift[i].giftMessage}</h6>
                            </Col>
                        </Row>
                    );
                    messages.push(view)
                }
            }
            this.setState({campaignGifts: messages});
        });
    }

    loadGiftInfo() {
        const gift = this.state.giftCampaign;
        const view = (
            <div>
                <h2 class="m-2">View Gift</h2>
                <h1 className="text-center">{gift.giftCampaignName}</h1>
                <h3 id="giver-header" className="text-center text-muted">Gift Created by: Person</h3>
                <div class="text-center m-4">
                    {this.state.campaignGifts}
                    <Image id="card-img" src={img1} />
                    <Image id="card-img1" src={sampleCard} />
                </div>
                <Row>
                    <Col><p className="text-right">{gift.totalGifters} givers</p></Col>
                    <Col><p className="text-center">Total Gift Amount: ${gift.giftTotal}</p></Col>
                    <Col><p className="text-left">Opened: {gift.startDate}</p></Col>
                </Row>
                <div class="text-center m-4">
                    Gift now: <Link to={{pathname: '/gift', id: this.getGiftId()}}><Button variant="outline-secondary">Click Here!</Button></Link>
                </div>
            </div>);
        return view;
    }

    render() {
        return (
            <React.Fragment>
                {this.loadGiftInfo()}
            </React.Fragment>
        )
    };
}

export default ViewGift;
