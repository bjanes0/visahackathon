import React, { Component } from 'react';
import {Button, Row, Col, Form, Card} from 'react-bootstrap';
import '../css/createGift.css';
import img1 from '../assets/pic1.jpg';

export const CreateGift = () => (
    <React.Fragment>
        <div id="create_div">
            <h2>Create Gift</h2>
            <Form >
                <Form.Group>
                    <h6>Gift Name</h6>
                    <Form.Control placeholder="Enter gift name"></Form.Control>
                </Form.Group>
                <Form.Group>
                    <h6>Recipient Name</h6>
                    <Form.Control placeholder="Enter gift name"></Form.Control>
                </Form.Group>
                <Row>
                    <Col>
                        <Card id="img">
                            <Card.Body>
                                <Card.Img src={img1}/>
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
                            <Button id="next_button" variant="secondary" size="lg">
                                Next<i className="arrow right"></i>
                            </Button>
                        </Form.Group>
                    </Col>
                </Row>
            </Form>
        </div>
    </React.Fragment>
)