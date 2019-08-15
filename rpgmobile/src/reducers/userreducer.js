import { USER_FETCHED, LOGIN_ERROR } from "../actions/UserAction";
import {AsyncStorage} from '@react-native-community/async-storage';


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
            //AsyncStorage.setItem(USER_STORAGE, action.payload);
            //var user = await AsyncStorage.getItem(USER_STORAGE)
            //console.log(user)
            /*
            _storeData = async () => {
                try {
                    await AsyncStorage.setItem(USER_STORAGE, action.payload);
                } catch (error) {
                    console.log(error)
                }
            }
            */
            //console.log(_storeData)
            
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