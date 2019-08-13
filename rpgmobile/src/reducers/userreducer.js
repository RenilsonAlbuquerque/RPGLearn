import { USER_FETCHED, LOGIN_ERROR } from "../actions/UserAction";
import AsyncStorage from '@react-native-community/async-storage';


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
            //AsyncStorage.setItem('@user', action.payload)
            return {
            ...state,
            currentUser : action.payload   
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