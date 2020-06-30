import React, { Component } from 'react';
import { Container, Col, Row } from 'react-bootstrap';
import '../css/footer.css';

export const Footer = () => (
    <React.Fragment>
        <Container fluid id="footer">
            <Row>
                <Col id="col_foot">
                    <br />
                    <p id="p_foot"></p>
                </Col>
                <Col id="col_foot">
                    <br />
                    <p id="p_foot"></p>
                </Col>
                <Col id="col_foot">
                    <br />
                    <p id="p_foot"></p>
                </Col>
                <Col id="col_foot">
                    <br />
                    <p id="p_foot"></p>
                </Col>
                <Col id="col_foot">
                    <br />
                    <p id="p_foot">Visa Touch</p>
                </Col>
            </Row>
        </Container>
    </React.Fragment>
)