import axios from "axios";

import CustomAxios from "../service/AxiosConfig";


export const STORY_FETCHED = 'STORY_FETCHED';
export const CURRENT_STORY = 'CURRENT_STORY';

const STORY_API ="/story";

export function getStories(pageConfig){

    return (dispatch) => {
        //await AsyncStorage.getItem(USER_STORAGE)['token']
        return CustomAxios
        .post(`${STORY_API}/list`,pageConfig)
        .then(result =>
            dispatch(
                {
                    type:STORY_FETCHED,
                    payload: result.data
                }
            ))
        
    };
}
export function setCurrentStory(story){
    return {
        type:CURRENT_STORY,
        payload: story
    }
}