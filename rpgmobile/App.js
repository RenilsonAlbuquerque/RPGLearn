import React, {Component} from 'react';
import { Provider } from 'react-redux'
import store from './src/store/store';
import Sidebar from './src/router/SideBarRouter';


export default class App extends React.Component {
  constructor(props){
    super(props);
  }
  render() {
    return (
      <Provider store={store}>
        <Sidebar ref={navigatorRef => {NavigationService.setTopLevelNavigator(navigatorRef)}}>
        </Sidebar>
      </Provider>
      
    );
  }
}