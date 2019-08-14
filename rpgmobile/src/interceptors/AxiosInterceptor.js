import CustomAxios from '../service/AxiosConfig'
import {AsyncStorage} from '@react-native-community/async-storage';
import { USER_STORAGE } from "../reducers/UserReducer";


const ERRRO_INVALID_TOKEN = "ERRRO_INVALID_TOKEN";

CustomAxios.interceptors.request.use(
    reqConfig => {
      reqConfig.headers.authorization = AsyncStorage.getItem(USER_STORAGE)['token'];
      return reqConfig;
    },
    err => Promise.reject(err),
  );
  