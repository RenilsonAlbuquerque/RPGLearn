import axios from 'axios';
import store from '../store/store'
import { BASE_URL } from '../constants/constants';

var CustomAxios = axios.create({
      baseURL: `http://${BASE_URL}`
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
