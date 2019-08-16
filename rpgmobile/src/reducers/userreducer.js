import { USER_FETCHED, LOGIN_ERROR } from "../actions/UserAction";
import AsyncStorage from '@react-native-community/async-storage';

//import {saveUser} from '../store/AsyncStorageService'

export const USER_STORAGE = 'currentUser';
const INITIAL_STATE = {
    currentUser :{
        id: 0,
        nome:'',
        email:'',
        token:'',
        atuhenticated: false
    },
    error:""
}

export default function (state = INITIAL_STATE, action = {}) {
    switch (action.type) {
        case USER_FETCHED:
            try{
                AsyncStorage.setItem(USER_STORAGE, action.payload)
            }catch(error){
                console.log(error)
            }
            
            //saveUser()
            return {
            ...state,
            currentUser : action.payload,
            error: ""   
        }
        
        case LOGIN_ERROR:
            return {
            ...state,
            error : action.payload
        }
        default:
            return state
    }
}