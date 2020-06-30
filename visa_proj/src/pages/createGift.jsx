import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import axios from 'axios';
import { Button, Row, Col, Form, Card } from 'react-bootstrap';
import '../css/createGift.css';
import img1 from '../assets/pic1.jpg';
import img2 from '../assets/pic2.png';
import img3 from '../assets/pic3.jpg'

class CreateGift extends Component {
    
    constructor(props) {
        super(props);
        this.state = {
            giftCampaignName: '', 
            recipientEmail: ''
        };
        this.giftChange = this.giftChange.bind(this);
        this.addGift = this.addGift.bind(this);
    }

    giftChange = event => {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    addGift = event => {
        event.preventDefault();

        const Gift = {
            giftCampaignName: this.state.giftCampaignName,
            recipientEmail: this.state.recipientEmail,
            startDate: new Date()
        };

        const jwt = localStorage.getItem("jwt");

        axios.post("http://localhost:8080/api/v1/gift_campaigns/", Gift, { headers: { Authorization : `Bearer ${jwt}` }})
            .then(response => {
                if(response.data != null) {
                    this.props.history.push("/my-gifts");
                    alert("Gift Campaign Saved Successfully!");
                    this.reloadPage();
                }
            })
    }

    compareImages(imgPath) {
        if(imgPath === '../assets/pic1.jpg'){
            return img1;
        }
        if(imgPath === '../assets/pic2.png'){
            return img2;
        }
        if(imgPath === '../assets/pic3.jpg'){
            return img3;
        }
    }

    componentDidMount() {
        const {newData} = this.props.location;
        if(newData !== undefined){
            this.setState({giftCampaignName: newData.giftCampaignName, recipientEmail: newData.recipientEmail})
            document.getElementById("tempImg").src = this.compareImages(newData.choice);
        }
    }

    reloadPage () {
        window.location.reload()
    }

    render () {
    
        const { giftCampaignName, recipientEmail} = this.state;

    return (
    <React.Fragment>
        <div id="create_div">
            <h2>Create Gift Campaign</h2>
            <Form >
                <Form.Group>
                <h6>Gift Campaign Name</h6>
                    <Form.Control name="giftCampaignName" value={giftCampaignName} onChange={this.giftChange} placeholder="Enter gift campaign name"></Form.Control>
                </Form.Group>
                <Form.Group>
                    <h6>Recipient Email</h6>
                    <Form.Control name="recipientEmail" value={recipientEmail} onChange={this.giftChange} placeholder="Enter recipient email"></Form.Control>
                </Form.Group>
                <Row>
                    <Col>
                        <Card >
                            <Card.Body>
                                <Card.Img id="tempImg" src={img1} />
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col>
                        <Form.Group>
                        <Link id="temp_butt" to={{pathname: "templates", data: this.state}}>
                            <Button id="create_gift_button" variant="secondary" size="lg">
                                Choose Template
                            </Button>
                        </Link>
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
