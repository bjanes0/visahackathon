import React, { Component } from 'react';
import { Form, Button } from 'react-bootstrap';
import axios from 'axios';
import '../css/edit.css';


class EditGift extends Component {

    constructor(props) {
        super(props);
        this.state = {

        }
        this.submit = this.submit.bind(this);
    }

    submit = (giftCampaignId) => {
        const jwt = localStorage.getItem("jwt");
        axios.put("http://localhost:8080/api/v1/gift_campaigns/"+giftCampaignId, { headers: {Authorization: `Bearer ${jwt}`}})
        .then(response => {
            if(response.data != null) {
                alert("Gift updated successfully!");
                this.props.history.push("/my-gifts");
                this.reloadPage();
            }
        })
    }

    render() {
    return (
    <React.Fragment>
        <div id="top_div">
            <h2>Edit Your Gift!</h2>
            <Form onSubmit={this.submit}>
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
                    <Button id="save_button" type="submit" variant="secondary" size="lg">
                        Save<i className="arrow right"></i>
                    </Button>
                </Form.Group>
            </Form>
        </div>
    </React.Fragment >
    )}}

export default EditGift;