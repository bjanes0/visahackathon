import React, { Component } from 'react';
import { Nav, Navbar } from 'react-bootstrap';
import '../css/navigationBar.css';

class NavigationBar extends Component {

    constructor(props) {
        super(props);
        this.state = {
            login: "show"
        };
    }

    componentDidMount() {
        if (localStorage.length > 0) {
            this.removeLogin();
            this.setState({ login: "blank" });
        }
        else if (this.state.login === "show") {
            this.removeLogout();
            this.setState({ login: "show" });
        }
    }

    removeLogin() {
        document.getElementById("login").style.display = "none";
        document.getElementById("logout").style.display = "block";
    }

    removeLogout() {
        document.getElementById("login").style.display = "block";
        document.getElementById("logout").style.display = "none";
    }

    changeLoginShow() {
        localStorage.removeItem("jwt");
    }

    reloadPage() {
        window.location.reload()
    }

    render() {

        return (
            <Navbar className="sticky-top" collapseOnSelect expand="lg" variant="dark">
                <Navbar.Brand href="/visahackathon/#/">Visa Touch</Navbar.Brand>
                <Navbar.Toggle area-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="ml-auto">
                        <Nav.Item><Nav.Link id="link" href="/visahackathon/#/">Home</Nav.Link></Nav.Item>
                        <Nav.Item><Nav.Link id="link" href="/visahackathon/#/my-gifts">My Gifts</Nav.Link></Nav.Item>
                        <Nav.Item><Nav.Link id="link" href="/visahackathon/#/search">Search Gifts</Nav.Link></Nav.Item>
                        <Nav.Item id="login"><Nav.Link id="link" href="/visahackathon/#/login">Log In</Nav.Link></Nav.Item>
                        <Nav.Item id="logout" onClick={this.changeLoginShow}><Nav.Link id="link" href="/visahackathon/#/">Logout</Nav.Link></Nav.Item>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        )
    };
}

export default NavigationBar;
