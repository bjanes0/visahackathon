import React, { Component } from 'react';
import {Card, Button} from 'react-bootstrap';
import '../css/giftManager.css';
import img1 from '../assets/pic1.jpg'

class GiftManager extends Component {
    state = {  }
    render() { 
        return ( 
            <React.Fragment>
                <div id="manage_card">
                <Card>
                    <Card.Body>
                        <Card.Title>Gift #1</Card.Title>
                        <Card.Subtitle>Amount Gifted: $30</Card.Subtitle>
                        <Card.Text>
                            <h6>Sent To: Richard</h6>
                            <Button className="stretched-link" id="log_button" variant="secondary" href="/visahackathon/#/create" active>
                            Manage Gift
                            </Button>
                        </Card.Text>
                    </Card.Body>
                </Card>
                <Card>
                    <Card.Body>
                        <Card.Title>Gift #2</Card.Title>
                        <Card.Subtitle>Amount Gifted: $70</Card.Subtitle>
                        <Card.Text>
                            <h6>Sending To: Jeremy</h6>
                            <Button className="stretched-link" id="log_button" variant="secondary" href="/visahackathon/#/create" active>
                            Manage Gift
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