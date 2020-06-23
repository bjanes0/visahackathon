import React, { Component } from 'react';
import {Nav, Navbar} from 'react-bootstrap';
import '../css/navigationBar.css';

export const NavigationBar = () => (
    <Navbar collapseOnSelect expand="lg" variant="dark">
        <Navbar.Brand href="/visahackathon/#/">Signed Gift</Navbar.Brand>
        <Navbar.Toggle area-controls="basic-navbar-nav"/>
        <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="ml-auto">
                <Nav.Item><Nav.Link href="/visahackathon/#/">Home</Nav.Link></Nav.Item>
                <Nav.Item><Nav.Link href="/visahackathon/#/my-gifts">My Gifts</Nav.Link></Nav.Item>
                <Nav.Item><Nav.Link href="/visahackathon/#/login">Login</Nav.Link></Nav.Item>
            </Nav>
        </Navbar.Collapse>
    </Navbar>
)