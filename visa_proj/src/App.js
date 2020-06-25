import React, { Component } from 'react';
import { HashRouter, Route } from 'react-router-dom';
import { Home } from './pages/home';
import { ManageGifts } from './pages/manageGifts';
import { Login } from './pages/login';
import { CreateGift } from './pages/createGift';
import { NavigationBar } from './components/navigationBar';
import { Footer } from './components/footer';
import { ViewGift } from './pages/viewGift';
import './App.css';
import { Search } from './pages/search';

class App extends Component {

  render() {
    return (
      <React.Fragment>
        <NavigationBar />
        <HashRouter>
          <Route exact path="/" component={Home} />
          <Route path="/my-gifts" component={ManageGifts} />
          <Route path="/create" component={CreateGift} />
          <Route path="/login" component={Login} />
          <Route path="/view" component={ViewGift} />
          <Route path="/search" component={Search} />
        </HashRouter>
        <Footer />
      </React.Fragment>
    );
  }
}

export default App;
