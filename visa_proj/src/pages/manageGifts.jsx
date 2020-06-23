import React, { Component } from 'react';
//import {} from 'react-bootstrap';
import GiftManager from '../components/giftManager';
import '../css/manageGifts.css';

export const ManageGifts = () => (
    <React.Fragment>
        <h2>My Gifts</h2>
        <GiftManager/>
    </React.Fragment>
)