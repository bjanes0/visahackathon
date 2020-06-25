import React, { Component } from 'react';
import { Form, Container, Row, Col, Image } from 'react-bootstrap';
import '../css/search.css';


export const Search = () => (
    <React.Fragment>
        <div id="top_div">
            <h2>Search</h2>
            <Form>
                <Form.Group>
                    <Form.Control type="search" placeholder="Search gifts" />
                </Form.Group>
            </Form>
        </div>
    </React.Fragment >
)