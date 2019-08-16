import CustomAxios from "../service/AxiosConfig";

export const COMBAT_STATUS_FETCHED = 'COMBAT_STATUS_FETCHED';

const STORY_API ="/combat";

export function setCombatStatus(combatStatus){
        return {
            type:COMBAT_STATUS_FETCHED,
            payload: combatStatus
        }
}
export function getCombatStatusState(storyId){
    return (dispatch) => {
        return CustomAxios
        .get(`${STORY_API}/status/${storyId}`)
        .then(result =>
            dispatch(
                {
                    type:COMBAT_STATUS_FETCHED,
                    payload: result.data
                }
            ))
        
    };
}
