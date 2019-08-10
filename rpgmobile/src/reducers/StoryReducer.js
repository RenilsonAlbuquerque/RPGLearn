
import { STORY_FETCHED, CURRENT_STORY } from "../actions/StoryAction";



const INITIAL_STATE = {
    stories:{
        elements:[],
        currentPageNumber: 1,
        totalOfPages: 0,
        size:1,
        first:true,
        last: true
    },
    selectedStory:{
        id:0,
    }
    
}

export default function (state = INITIAL_STATE, action = {}) {
    switch (action.type) {
        case STORY_FETCHED:
            return {
            ...state,
            stories : action.payload
        }
        case CURRENT_STORY:
            return {
            ...state,
            selectedStory : action.payload
        }
        default:
            return state
    }
}