import { CURRENT_CHARACTER_FETCHED,CHARACTER_CREATION_METADATA_FETCHED } from "../actions/CharacterAction";

const INITIAL_STATE = {
    currentCharacter:{
       
    },
    characterCreationMetadata:{
        
    }
    
}
export default function (state = INITIAL_STATE, action = {}) {
    switch (action.type) {
        case CURRENT_CHARACTER_FETCHED:
            return {
            ...state,
            currentCharacter : action.payload
        }
        case CHARACTER_CREATION_METADATA_FETCHED:
            return {
            ...state,
            characterCreationMetadata : action.payload
        }
        default:
            return state
    }
}