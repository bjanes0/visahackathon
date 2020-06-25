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
                    <h4>Free Delivery</h4>
                    <br />
                    <p>We will deliver it for free, the fee for delivery... free!</p>
                </Col>
                <Col id="col_home">
                    <br />
                    <h4>Not Illegal</h4>
                    <br />
                    <p>We swear that you won't be investigated if you buy from us ;)</p>
                </Col>
                <Col id="col_home">
                    <br />
                    <h4>Make someone smile!</h4>
                    <br />
                    <p>Who doesn't like free money?</p>
                </Col>
                <Col id="bgColor">
                </Col>
            </Row>
        </Container>
    </React.Fragment>
)