
import { STORY_FETCHED } from "../actions/StoryAction";



const INITIAL_STATE = {
    stories:{
        elements:[],
        currentPageNumber: 1,
        totalOfPages: 0,
        size:1,
        first:true,
        last: true
    }
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