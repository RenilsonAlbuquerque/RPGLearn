import axios from "axios";
import NavigationSevice from '../service/NavigationService'
import CustomAxios from "../service/AxiosConfig";
import { USER_STORAGE } from "../reducers/UserReducer";
import AsyncStorage from "@react-native-community/async-storage";
import {saveUser} from '../store/AsyncStorageService'; 



export const USER_FETCHED = 'USER_FETCHED';
export const LOGIN_ERROR = 'LOGIN_ERROR';
const USER_API = "/login"




export function loginAction(nome, senha){
   var user = { username: nome,
                password: senha}

    return (dispatch) => {
        return CustomAxios
            .post(`${USER_API}`,user)
            .then(result => {
                
                saveUser(result.data)
                      
                dispatch(
                    {
                        type: USER_FETCHED,
                        payload: result.data
                    },
                    navigateToMenu()
                )} 
            )
            
            .catch(error => 
                dispatch(
                    {
                        type:LOGIN_ERROR,
                        payload: (error.response.data.detail) ? error.response.data.detail : error.message
                    },
                    
                )
            )
            
    }
}
export function setLoggedUser(user){
    return {
        type:USER_FETCHED,
        payload: user
    }
}
function navigateToMenu(){
    setTimeout(function(){
    }, 2000);
    NavigationSevice.navigate('StoryPage')
}