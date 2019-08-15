import axios from 'axios';
import AsyncStorage from '@react-native-community/async-storage';
import { USER_STORAGE } from '../reducers/UserReducer';

import React, {Component} from 'react';
import { connect } from 'react-redux';
import store from '../store/store'

var CustomAxios = axios.create({
      baseURL: 'http://192.168.0.111:8080'
});
CustomAxios.interceptors.request.use( 
      (reqConfig) => {
        var token = store.getState().UserReducer.currentUser.token
        reqConfig.headers.authorization = token ? token : ""
        return reqConfig;
      },
      (err) => Promise.reject(err),
    );
export default CustomAxios;
/*
const mapStateToProps = state => ({ 
      user: state.UserReducer.currentUser
})
  
  export default connect(mapStateToProps,null)(CustomAxios)
  */
//console.log(AsyncStorage.getItem(USER_STORAGE)['token']),
