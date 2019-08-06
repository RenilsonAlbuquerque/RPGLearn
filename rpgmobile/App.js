import React, {Component} from 'react';
import { Provider } from 'react-redux'
import store from './src/store/store';
import Sidebar from './src/router/SideBarRouter';
import { Text } from 'native-base';
import CombatPage from './src/pages/CombatPage';


export default class App extends React.Component {
  constructor(props){
    super(props);
  }
  render() {
    return (
      <Provider store={store}>
        <CombatPage></CombatPage>
      </Provider>
      
    );
  }
}