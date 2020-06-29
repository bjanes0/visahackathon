import React, { Component } from 'react';
import axios from 'axios';
import { Button, Row, Col, Form, Card } from 'react-bootstrap';
import '../css/createGift.css';
import img1 from '../assets/pic1.jpg';

class CreateGift extends Component {
    
    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.giftChange = this.giftChange.bind(this);
        this.addGift = this.addGift.bind(this);
    }

    initialState = {
        giftMessage: '', amount: '', recipientEmail: ''
    }

    giftChange = event => {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    addGift = event => {
        event.preventDefault();

        const Gift = {
            giftMessage: this.state.giftMessage,
            amount: this.state.amount,
            recipientEmail: this.state.recipientEmail
        };

        const jwt = localStorage.getItem("jwt");

        axios.post("http://localhost:8080/api/v1/gifts/", Gift, { headers: { Authorization : `Bearer ${jwt}` }})
            .then(response => {
                if(response.data != null) {
                    this.setState(this.initialState);
                    alert("Gift Saved Successfully!");
                }
            })
        axios.post("")
    }

    render () {

        const {giftMessage, amount, recipientEmail} = this.state;
    return (
    <React.Fragment>
        <div id="create_div">
            <h2>Create Gift Campaign</h2>
            <Form >
                <Form.Group>
                <h6>Gift Campaign Name</h6>
                    <Form.Control placeholder="Enter gift campaign name"></Form.Control>
                </Form.Group>
                <Form.Group>
                    <h6>Recipient Name</h6>
                    <Form.Control placeholder="Enter recipient name"></Form.Control>
                </Form.Group>
                <Form.Group>
                    <h6>Gift Message</h6>
                    <Form.Control name="firstName" value={giftMessage} onChange={this.giftChange} placeholder="Enter gift message"></Form.Control>
                </Form.Group>
                <Form.Group>
                    <h6>Gift Amount</h6>
                    <Form.Control name="lastName" value={amount} onChange={this.giftChange} placeholder="Enter amount"></Form.Control>
                </Form.Group>
                <Form.Group>
                    <h6>Recipient Email</h6>
                    <Form.Control name="email" value={recipientEmail} onChange={this.giftChange} placeholder="Enter recipient email"></Form.Control>
                </Form.Group>
                <Row>
                    <Col>
                        <Card id="img">
                            <Card.Body>
                                <Card.Img src={img1} />
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col>
                        <Form.Group>
                            <Button id="create_gift_button" variant="secondary" size="lg">
                                Choose Template
                            </Button>
                        </Form.Group>
                        <Form.Group>
                            <Button id="create_gift_button" variant="secondary" size="lg">
                                Edit Card
                            </Button>
                        </Form.Group>
                        <Form.Group>
                            <Button onClick={this.addGift} id="next_button" variant="secondary" size="lg">
                                Next<i className="arrow right"></i>
                            </Button>
                        </Form.Group>
                    </Col>
                </Row>
            </Form>
        </div>
    </React.Fragment>
);
}
}

export default CreateGift;
