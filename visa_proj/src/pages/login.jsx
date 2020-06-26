import React, { Component } from 'react';
import { Form, Button, Container, Row, Col } from 'react-bootstrap';
import '../css/login.css';

export const Login = () => (
    <React.Fragment>
        <Container fluid>
            <Row>
                <Col></Col>
                <Col id="col_login">
                    <br />
                    <br />
                    <br />
                    <br />
                    <Form>
                        <h2>Login</h2>
                        <Form.Group controlId="formUsername">
                            <Form.Label>Username</Form.Label>
                            <Form.Control type="username" placeholder="Enter username or email" />
                        </Form.Group>
                        <Form.Group controlId="formPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="username" placeholder="Enter password" />
                        </Form.Group>
                        <Button id="log_button" variant="secondary" type="submit">
                            Login
                </Button>
                        <Form.Group>
                            <Form.Label class="text-muted mt-3 mr-3">Don't have an account?</Form.Label>
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
)