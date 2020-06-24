import React, { Component } from 'react';
import { Container, Row, Col, Image } from 'react-bootstrap';
import sampleCard from '../assets/sampleCard.png';
import '../css/viewGift.css';

export const ViewGift = () => (
    <React.Fragment>
        <h2>View Gift Sample</h2>
        <h1 className="text-center" contenteditable="true">Gift Name</h1>
        <h3 id="giver-header" className="text-center text-muted">Gift Created by: Giver Name</h3>
        <Container id="cardBox">
            <Image src={sampleCard} />
        </Container>
    </React.Fragment >
)