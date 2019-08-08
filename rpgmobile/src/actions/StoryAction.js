import axios from "axios";

export const STORY_FETCHED = 'STORY_FETCHED';

const STORY_API =
    "http://";

export function getStories(){
    
    return (dispatch) => {
        return axios
        .post(`${STORY_API}/login`,newUser)
        .then(result =>
            dispatch(
                {
                    type:STORY_FETCHED,
                    payload: 
                       [
                           {
                            id:1,name:'Curse of strahd'
                           }
                       ]
                    

                }
            ))
    };
}