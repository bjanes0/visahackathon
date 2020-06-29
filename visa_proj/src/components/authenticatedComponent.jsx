import React, { Component } from 'react';
import {Redirect, withRouter} from 'react-router-dom';
import removeLogin from '../components/navigationBar';
import axios from 'axios';

class AuthenticatedComponent extends Component {
    
    constructor(props) {
        super(props);

        this.state = {
            user: undefined
        };
    }

    componentDidMount() {
        const jwt = localStorage.getItem("jwt");
        axios.get("http://localhost:8080/auth_user", { headers: { Authorization : `Bearer ${jwt}` }})
        .then(res => this.setState({
            user: res.data
        })).catch(err => {
            localStorage.removeItem("jwt");
        })
    }

    render() {
        console.log(this.state.user);
        if(this.state.user === undefined) {
            const loc = window.location.href;
            let id = "";
            for (let i = loc.length-1; i > 0; i--) {
                if(loc[i] === "/") {
                    break;
                }
                id = id + loc[i];
                
            }
            const path = id.split("").reverse().join("")
            if(path !== "" && path !== "login" && path !== "register") {
                return <Redirect to="/login" />
            }
        }        
        return (
            <div>
                {this.props.children}
            </div>
        )
    }
}

export default withRouter(AuthenticatedComponent);