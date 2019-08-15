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
        console.log(store.getState().UserReducer.currentUser)
        var token = store.getState().UserReducer.currentUser.token
        reqConfig.headers.authorization = token ? token : ""
        //reqConfig.headers.authorization = "Bearer eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE1NjY2MDc4MDQsImlkIjoxLCJ1c2VybmFtZSI6InJlbmlsc29uIn0._IUl-W5p0nxDk0qVIls34YPVwECM65eKc5ys81ldZXivW_1NmIVpjWOpTtgcMkD-nht_SPVw9Qxb8rshKn67eg"
        return reqConfig;
      },
      (err) => Promise.reject(err),
    );
//export default CustomAxios;

const mapStateToProps = state => ({ 
      user: state.UserReducer.currentUser
})
  
  export default connect(mapStateToProps,null)(CustomAxios)
//console.log(AsyncStorage.getItem(USER_STORAGE)['token']),
