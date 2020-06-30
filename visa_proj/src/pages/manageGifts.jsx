import React, { Component } from 'react';
import { Button, Nav, Tab, Tabs } from 'react-bootstrap';
import GiftManager from '../components/giftManager';
import GiftCampaignManager from '../components/giftCampaignManager'
import '../css/manageGifts.css';

export const ManageGifts = () => (
    <React.Fragment>
        <div id="content">
            <div id="top_div">
                <h2>My Gifts</h2>
                <Button id="create_button" variant="secondary" size="md" href="/visahackathon/#/create" active>Create New Gift Campaign</Button>{' '}
            </div>
            <Tabs className="tabsSelector" defaultActiveKey="giftCampaignManager" id="uncontrolled-tab-example">
                <Tab eventKey="giftCampaignManager" title="Manage Gift Campaigns">
                    <GiftCampaignManager />
                </Tab>
                <Tab eventKey="giftManager" title="Manage Gifts">
                    <GiftManager />
                </Tab>
            </Tabs>
        </div>
    </React.Fragment>
)