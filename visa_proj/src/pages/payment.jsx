import React, { Component } from 'react';
import axios from 'axios';
import {Form, Button, Row, Col} from 'react-bootstrap';

class Payment extends Component {

    constructor(props) {
        super(props);
        this.state = {
            amount: '',
            cardNumber: '',
            lastFourDigits: '',
            cvv: '',
            expirydate: '',
            userId: ''
        }
        this.giftChange = this.giftChange.bind(this);
        this.saveGift = this.saveGift.bind(this);
    }

    componentDidMount() {
        const {data} = this.props.location;
        this.setState({amount: data});
        const jwt = localStorage.getItem("jwt");
        axios.get("http://localhost:8080/auth_user", { headers: { Authorization : `Bearer ${jwt}` }})
        .then(res => this.setState({
            userId: res.data.userId
        })).catch(err => {
            localStorage.removeItem("jwt");
        })
    }

    giftChange = event => {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    saveGift() {
        const jwt = localStorage.getItem("jwt");

        const payment = {
            cardNumber: this.state.cardNumber,
            lastFourDigits: this.state.cardNumber.substring(8),
            expiryDate: this.state.expiryDate,
            cvv: this.state.cvv,
            userId: this.state.userId
        };
        console.log(payment);
        axios.post("http://localhost:8080/api/v1/payment_info/"+this.state.userId, payment, { headers: { Authorization : `Bearer ${jwt}` }})
        .then(response => {
            if(response.data != null) {
                this.props.history.push("/my-gifts");
                alert("Gift Saved Successfully!");
                this.reloadPage();
            }
        })
    }

    reloadPage() {
        window.location.reload();
    }

    render() {

        return (
            <React.Fragment>
        <div id="top_div">
            <h2>Add money to Gift!</h2>
            <Form>
                <Form.Group>
                    <Form.Label>Gifting Amount</Form.Label>
                    <Form.Control style={{width: 1218}} value={this.state.amount} type="text" readonly="true" />
                </Form.Group>
                <Form.Group>
                    <Row>
                        <Col>
                            <Form.Label>Card Number</Form.Label>
                            <Form.Control maxlength="12" name="cardNumber" value={this.state.cardNumber} onChange={this.giftChange} type="text" placeholder="Enter your card number" />
                        </Col>
                        <Col className="col-md-auto">
                            <Form.Label>CVV</Form.Label>
                            <Form.Control maxlength="3" style={{width: 100}} name="cvv" value={this.state.cvv} onChange={this.giftChange} type="text" placeholder="CVV" />
                        </Col>
                        <Col>
                            <Form.Label>Expiration Date</Form.Label>
                            <Form.Control maxlength="4" style={{width: 200}} name="expiryDate" value={this.state.expiryDate} onChange={this.giftChange} type="text" placeholder="Ex. Date" />
                        </Col>
                    </Row>
                </Form.Group>
                <Form.Group>
                        <Button id="next_button_gift" onClick={this.saveGift} variant="secondary" size="lg">
                            Save<i className="arrow right"></i>
                        </Button>
                </Form.Group>
            </Form>
        </div>
    </React.Fragment >
        )
    }
}

export default Payment;