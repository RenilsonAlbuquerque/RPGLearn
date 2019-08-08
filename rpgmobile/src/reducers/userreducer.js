import { USER_FETCHED } from "../actions/UserAction";



const INITIAL_STATE = {
    currentUser :{
        id: 0,
        nome:'',
        email:'',
        token:'',
        atuhenticated: false
    }
}

export default function (state = INITIAL_STATE, action = {}) {
    switch (action.type) {
        case USER_FETCHED:
            return {
            ...state,
            currentUser : action.payload
        }
        default:
            return state
    }
}