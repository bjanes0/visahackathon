import React, { Component } from 'react';
import { Card, Button } from 'react-bootstrap';
import '../css/giftManager.css';
import img1 from '../assets/pic1.jpg'

class GiftManager extends Component {
    state = {}
    render() {
        return (
            <React.Fragment>
                <div id="manage_card">
                    <Card>
                        <Card.Body>
                            <Card.Title>Gift #1</Card.Title>
                            <Card.Subtitle>Amount Gifted: $30</Card.Subtitle>
                            <Card.Text>
                                <h6>Sent To: Rachel</h6>
                                <Button className="m-1" id="log_button" variant="secondary" href="/visahackathon/#/create" active>
                                    Manage Gift
                                </Button>
                                <Button className="m-1" id="log_button" variant="secondary" href="/visahackathon/#/view">
                                    View Gift
                                </Button>
                            </Card.Text>
                        </Card.Body>
                    </Card>
                    <Card>
                        <Card.Body>
                            <Card.Title>Gift #2</Card.Title>
                            <Card.Subtitle>Amount Gifted: $70</Card.Subtitle>
                            <Card.Text>
                                <h6>Sending To: Harold</h6>
                                <Button className="m-1" id="log_button" variant="secondary" href="/visahackathon/#/create" active>
                                    Manage Gift
                                </Button>
                                <Button className="m-1" id="log_button" variant="secondary" href="/visahackathon/#/view" active>
                                    View Gift
                                </Button>
                            </Card.Text>
                        </Card.Body>
                    </Card>
                </div>
            </React.Fragment>
        );
    }
}

export default GiftManager;