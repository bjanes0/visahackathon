import React, { Component } from 'react';
import { HashRouter, Route } from 'react-router-dom';
import { Home } from './pages/home';
import { ManageGifts } from './pages/manageGifts';
import  Login  from './pages/login';
import { Register } from './pages/register';
import  CreateGift  from './pages/createGift';
import  NavigationBar  from './components/navigationBar';
import { Footer } from './components/footer';
import  ViewGift  from './pages/viewGift';
import { Gift } from './pages/gift';
import { EditGift } from './pages/editGift'
import { EditGiftCampaign } from './pages/editGiftCampaign'
import './App.css';
import { Search } from './pages/search';
import AuthenticatedComponent from './components/authenticatedComponent';

class App extends Component {

  render() {
    return (
      <React.Fragment>
        <NavigationBar />
        <HashRouter>
          <Route exact path="/" component={Home} />
          <Route path="/login" component={Login} />
          <Route path="/register" component={Register} />
          <AuthenticatedComponent>
            <Route path="/my-gifts" component={ManageGifts} />
            <Route path="/create" component={CreateGift} />
            <Route path="/view" component={ViewGift} />
            <Route path="/search" component={Search} />
            <Route path="/gift" component={Gift} />
            <Route path="/editGiftCampaign" component={EditGiftCampaign} />
            <Route path="/editGift" component={EditGift} />
          </AuthenticatedComponent>
        </HashRouter>
        <Footer />
      </React.Fragment>
    );
  }
}

export default App;
