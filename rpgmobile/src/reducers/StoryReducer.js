
import { STORY_FETCHED } from "../actions/StoryAction";



const INITIAL_STATE = {
    stories:[]
}

export default function (state = INITIAL_STATE, action = {}) {
    switch (action.type) {
        case STORY_FETCHED:
            return {
            ...state,
            stories : action.payload
        }
        default:
            return state
    }
}