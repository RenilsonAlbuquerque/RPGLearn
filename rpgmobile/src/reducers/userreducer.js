import { USER_FETCHED, LOGIN_ERROR } from "../actions/UserAction";



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
            return {
            ...state,
            currentUser : action.payload
        }
        case LOGIN_ERROR:
            return {
            ...state,
            error : 'fudeu'
        }
        default:
            return state
    }
}