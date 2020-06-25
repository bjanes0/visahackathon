import React, { Component } from 'react';
import { Container, Button, Row, Col, Image } from 'react-bootstrap';
import sampleCard from '../assets/sampleCard.png';
import '../css/viewGift.css';

export const ViewGift = () => (
    <React.Fragment>
        <h2>View Gift</h2>
        <h1 className="text-center">Gift Name</h1>
        <h3 id="giver-header" className="text-center text-muted">Gift Created by: Giver Name</h3>
        <div class="text-center m-4">
            <Image id="card-img" src={sampleCard} />
        </div>
        <Row>
            <Col><p class="text-right">26 givers</p></Col>
            <Col><p class="text-left">Opened 6/23/2020</p></Col>
        </Row>
        <div class="text-center m-4">
            Contribute now: <Button variant="outline-secondary">Click Here!</Button>
        </div>
    </React.Fragment >
)