import React, {Component} from 'react';
import { Provider } from 'react-redux'
import Sidebar from './src/router/SideBarRouter';

import CombatPage from './src/pages/CombatPage';
import LoginPage from './src/pages/LoginPage';
import ShakalStackNavigator from './src/router/ShakalStackNavigator';
import store  from './src/store/store'
import NavigationService from './src/service/NavigationService';
import CombatMonsters from './src/components/story/CombatMonsters';


export default class App extends React.Component {
  constructor(props){
    super(props);
  }
  render() {
    return (
      <Provider store={store}>
         <ShakalStackNavigator ref={navigatorRef => {NavigationService.setTopLevelNavigator(navigatorRef)}}></ShakalStackNavigator>
      </Provider>
      
    );
  }
}