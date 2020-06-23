import React, { Component } from 'react';
import {Form, Button, Container, Row, Col} from 'react-bootstrap';
import '../css/login.css';

export const Login = () => (
    <React.Fragment>
    <Container fluid>
        <Row>
            <Col></Col>
            <Col id="col_login">
                <br/>
                <br/>
                <br/>
                <br/>
            <Form>
                <h2>Login</h2>
                <Form.Group controlId="formUsername">
                    <Form.Label>Username</Form.Label>
                    <Form.Control type="username" placeholder="Enter username or email"/>
                </Form.Group>
                <Form.Group controlId="formPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="username" placeholder="Enter password"/>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Login
                </Button>
            </Form>
            </Col>
            <Col></Col>
        </Row>
    </Container>
    </React.Fragment>
)