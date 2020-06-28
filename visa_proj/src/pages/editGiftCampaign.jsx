import React, { Component } from 'react';
import { Form, Button } from 'react-bootstrap';
import '../css/edit.css';


export const EditGiftCampaign = () => (
    <React.Fragment>
        <div id="top_div">
            <h2>Edit Your Gift Campaign!</h2>
            <Form>
                <Form.Group>
                    <Form.Label>Gift Campaign Name</Form.Label>
                    <Form.Control placeholder="Enter the name of your gift campaign" />
                </Form.Group>
                <Form.Group>
                    <Form.Label>Gift Recipient's Name</Form.Label>
                    <Form.Control placeholder="Enter the recipient's name" />
                </Form.Group>
                <Form.Group>
                    <Button id="save_button">Change Template</Button>
                </Form.Group>
                <Form.Group>
                    <Button id="next_button_gift" variant="secondary" size="lg">
                        Save<i className="arrow right"></i>
                    </Button>
                </Form.Group>
            </Form>
        </div>
    </React.Fragment >
)