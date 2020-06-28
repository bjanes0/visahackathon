import React, { Component } from 'react';
import { Form, Button } from 'react-bootstrap';
import '../css/gift.css';


export const Gift = () => (
    <React.Fragment>
        <div id="top_div">
            <h2>Add Your Gift!</h2>
            <Form>
                <Form.Group>
                    <Form.Label>The name you'd like to sign</Form.Label>
                    <Form.Control type="search" placeholder="Enter your print name you'd like to sign" />
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
                    <Button id="next_button_gift" variant="secondary" size="lg">
                        Next<i className="arrow right"></i>
                    </Button>
                </Form.Group>
            </Form>
        </div>
    </React.Fragment >
)