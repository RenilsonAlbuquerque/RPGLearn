import axios from 'axios';
var CustomAxios = axios.create({
      baseURL: 'http://192.168.0.112:8080'
});
export default CustomAxios;