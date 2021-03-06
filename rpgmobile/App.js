import React, {Component} from 'react';
import { Provider } from 'react-redux'


import ShakalStackNavigator from './src/router/ShakalStackNavigator';
import store  from './src/store/store'
import NavigationService from './src/service/NavigationService';
import 'react-native-gesture-handler';



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