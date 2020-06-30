import React, { Component } from 'react';
import { Container, Button, Row, Col, Image } from 'react-bootstrap';
import sampleCard from '../assets/sampleCard.png';
import axios from 'axios';
import '../css/viewGift.css';

class ViewGift extends Component {

    constructor(props) {
        super(props);
        this.state = {
            gifts: {}
        }
    }

    componentDidMount() {
        this.getGiftInfo();
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
        axios.get("http://localhost:8080/api/v1/gifts/" + id, { headers: { Authorization: `Bearer ${jwt}` } })
            .then(response => response.data)
            .then((data) => {
                this.setState({ gifts: data });
            });
    }

    loadGiftInfo() {
        const gift = this.state.gifts;
        const view = (
            <div>
                <h2 class="m-2">View Gift</h2>
                <h1 className="text-center">{gift.giftMessage}</h1>
                <h3 id="giver-header" className="text-center text-muted">Gift Created by: {gift.userId}</h3>
                <div class="text-center m-4">
                    <Image id="card-img" src={sampleCard} />
                </div>
                <Row>
                    <Col><p class="text-right">26 givers</p></Col>
                    <Col><p class="text-left">Opened {gift.giftDate}</p></Col>
                </Row>
                <div class="text-center m-4">
                    Gift now: <Button variant="outline-secondary" href="/visahackathon/#/gift">Click Here!</Button>
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
