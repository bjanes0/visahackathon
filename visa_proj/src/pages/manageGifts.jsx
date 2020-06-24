import React, { Component } from 'react';
import {Button} from 'react-bootstrap';
import GiftManager from '../components/giftManager';
import '../css/manageGifts.css';

export const ManageGifts = () => (
    <React.Fragment>
        <h2>My Gifts</h2>
        <Button id="create_button" variant="secondary" size="md" href="/visahackathon/#/create" active>Create New Gift</Button>{' '}
        <GiftManager/>
    </React.Fragment>
)