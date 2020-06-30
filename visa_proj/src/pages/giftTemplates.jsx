import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import {Radio, Button, Row, Col, Card, Form} from 'react-bootstrap';
import img1 from '../assets/pic1.jpg';
import img2 from '../assets/pic2.png';
import img3 from '../assets/pic3.jpg';
import '../css/giftTemplates.css';


class GiftTemplates extends Component {
    
    constructor(props) {
        super(props);
        this.state = {
            choice: '',
            giftCampaignName: '',
            recipientEmail: ''
        }
        this.changeCheck1 = this.changeCheck1.bind(this);
        this.changeCheck2 = this.changeCheck2.bind(this);
        this.changeCheck3 = this.changeCheck3.bind(this);
    }

    changeCheck1() {
        document.getElementById("one").checked = "true";
        this.setState({choice: '../assets/pic1.jpg'});
    }

    changeCheck2() {
        document.getElementById("two").checked = "true";
        this.setState({choice: '../assets/pic2.png'});
    }

    changeCheck3() {
        document.getElementById("three").checked = "true";
        this.setState({choice: '../assets/pic3.jpg'});
    }

    componentDidMount() {
        const {data} = this.props.location;
        if(data !== undefined) {
            console.log(data.giftCampaignName);
            this.setState({giftCampaignName: data.giftCampaignName, recipientEmail: data.recipientEmail});
        }
    }

    render() {
        
        return (
            <div id="temp_head">
                <Form >
                    <h2>Choose A Template</h2>
                    <Row>
                        <Col>
                            <Form.Group controlId="template">
                                <Card>
                                    <Card.Body onClick={this.changeCheck1}>
                                        <Form.Check id="one" name="formHorizontalRadios" type="radio" ></Form.Check>
                                        <Card.Img variant="top" src={img1} />
                                    </Card.Body>
                                </Card>
                            </Form.Group>
                        </Col>
                        <Col>
                            <Form.Group controlId="template">
                                <Card>
                                    <Card.Body onClick={this.changeCheck2}>
                                        <Form.Check id="two" name="formHorizontalRadios" type="radio"></Form.Check>
                                        <Card.Img variant="top" src={img2} />
                                    </Card.Body>
                                </Card>
                            </Form.Group>
                        </Col>
                        <Col>
                            <Form.Group controlId="template">
                                <Card>
                                    <Card.Body onClick={this.changeCheck3}>
                                        <Form.Check id="three" name="formHorizontalRadios" type="radio"></Form.Check>
                                        <Card.Img variant="top" src={img3} />
                                    </Card.Body>
                                </Card>
                            </Form.Group>
                        </Col>
                    </Row>
                    <Link id="temp_butt" to={{pathname: "/create", newData: this.state}}><Button id="temp_butt" type="submit" variant="secondary">Choose</Button></Link>
                </Form>
            </div>
        )
    }
}

export default GiftTemplates;