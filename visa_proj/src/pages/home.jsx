import React, { Component } from 'react';
import styled from 'styled-components';
import { ImgCarousel } from '../components/imgCarousel';
import { Row, Col, Container } from 'react-bootstrap';
import '../css/home.css';

export const Home = () => (
    <React.Fragment>
        <ImgCarousel />
        <Container fluid>
            <Row>
                <Col id="bgColor">
                </Col>
                <Col id="col_home">
                    <br />
                    <h4>Create a Gift Campaign</h4>
                    <br />
                    <p>Set up a new gift campaign by entering your information, the details of the recipient, and choosing a template to give the card special meaning!</p>
                </Col>
                <Col id="col_home">
                    <br />
                    <h4>Contribute to your Gift Campaign</h4>
                    <br />
                    <p>Contribute funds to the receipients gift, and invite others to do the same, to create an amazing surprise!</p>
                </Col>
                <Col id="col_home">
                    <br />
                    <h4>Send your gift to the recipient!</h4>
                    <br />
                    <p>There's nothing better than receiving a gift, delivered quickly and beautifully by email, with messages from family and friends!</p>
                </Col>
                <Col id="bgColor">
                </Col>
            </Row>
        </Container>
    </React.Fragment>
)