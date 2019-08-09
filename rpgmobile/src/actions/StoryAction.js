import axios from "axios";
import CustomAxios from "../service/AxiosConfig";


export const STORY_FETCHED = 'STORY_FETCHED';

const STORY_API ="/story";

export function getStories(pageConfig){

    return (dispatch) => {
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