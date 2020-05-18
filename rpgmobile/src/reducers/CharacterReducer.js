import { CURRENT_CHARACTER_FETCHED } from "../actions/CharacterAction";

const INITIAL_STATE = {
    currentCharacter:{
       
    }
    
}
export default function (state = INITIAL_STATE, action = {}) {
    switch (action.type) {
        case CURRENT_CHARACTER_FETCHED:
            return {
            ...state,
            currentCharacter : action.payload
        }
        default:
            return state
    }
}