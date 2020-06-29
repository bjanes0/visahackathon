import React, { Component } from 'react';
import axios from 'axios';
import { Form, Button, Container, Row, Col } from 'react-bootstrap';
import '../css/login.css';

class Login extends Component {

    constructor(props) {
        super(props);

        this.state = {
            username: '',
            password: ''
        };
        this.change = this.change.bind(this);
        this.submit = this.submit.bind(this);
    }

    change(e) {
        this.setState({
            [e.target.name]: e.target.value
        })
    }

    submit(e) {
        e.preventDefault();
        axios.post("http://localhost:8080/authenticate", {
            username: this.state.username,
            password: this.state.password
        }).then(res => {localStorage.setItem('jwt', res.data.jwt);
            this.props.history.push("/")});
    }

    render() {
        return (
            <React.Fragment>
                <Container fluid>
                    <Row>
                        <Col></Col>
                        <Col id="col_login">
                            <br />
                            <br />
                            <br />
                            <br />
                            <Form onSubmit={e => this.submit(e)}>
                                <h2>Login</h2>
                                <Form.Group controlId="formUsername">
                                    <Form.Label>Username</Form.Label>
                                    <Form.Control name="username" value={this.state.username} onChange={e => this.change(e)} type="username" placeholder="Enter username or email" />
                                </Form.Group>
                                <Form.Group controlId="formBasicPassword">
                                    <Form.Label>Password</Form.Label>
                                    <Form.Control name="password" value={this.state.password} onChange={e => this.change(e)} type="password" placeholder="Enter password" />
                                </Form.Group>
                                <Button id="log_button" variant="secondary" type="submit">
                                    Login
                        </Button>
                                <Form.Group>
                                    <Form.Label className="text-muted mt-3 mr-3">Don't have an account?</Form.Label>
                                    <Button id="log_button" href="/visahackathon/#/register" variant="secondary" type="submit">
                                        Register
                                    </Button>
                                </Form.Group>
                            </Form>
                        </Col>
                        <Col></Col>
                        <Row>
                        </Row>
                    </Row>
                </Container>
            </React.Fragment>
        )};
}

export default Login;
