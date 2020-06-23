import React, {Component}  from 'react';
import {HashRouter, Route} from 'react-router-dom';
import {Home} from './pages/home';
import {ManageGifts} from './pages/manageGifts';
import {Login} from './pages/login';
import {NavigationBar} from './components/navigationBar';
import {Footer} from './components/footer';
import './App.css';

class App extends Component {

  render() {
    return (
      <React.Fragment>
        <NavigationBar/>
        <HashRouter>
          <Route exact path="/" component={Home}/>
          <Route path="/my-gifts" component={ManageGifts}/>
          <Route path="/login" component={Login}/>
        </HashRouter>
        <Footer/>
      </React.Fragment>
    );
  }
}

export default App;
