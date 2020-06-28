import React, { Component } from 'react';
import { Form, Button } from 'react-bootstrap';
import '../css/edit.css';


export const EditGift = () => (
    <React.Fragment>
        <div id="top_div">
            <h2>Edit Your Gift!</h2>
            <Form>
                <Form.Group>
                    <Form.Label>The name you'd like to sign</Form.Label>
                    <Form.Control placeholder="Enter your print name you'd like to sign" />
                </Form.Group>
                <Form.Group>
                    <Form.Label>The message you'd like to include on the card</Form.Label>
                    <Form.Control as="textarea" placeholder="Enter your message here" rows="5" />
                </Form.Group>
                <Form.Group>
                    <Form.Label>Attach your signature</Form.Label>
                    <Form.File />
                </Form.Group>
                <Form.Group>
                    <Button id="save_button" variant="secondary" size="lg">
                        Save<i className="arrow right"></i>
                    </Button>
                </Form.Group>
            </Form>
        </div>
    </React.Fragment >
)