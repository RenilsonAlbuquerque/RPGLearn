import CustomAxios from "../service/AxiosConfig";

export const COMBAT_STATUS_FETCHED = 'COMBAT_STATUS_FETCHED';
export const WALK_PROPERTIES_FETCHED = 'WALK_PROPERTIES_FETCHED';
export const COMBAT_MAP_FETCHED = 'COMBAT_MAP_FETCHED';

export const STORY_API ="/combat";
export const PLACE_API ="/place";

export function setCombatStatus(combatStatus){
        return {
            type:COMBAT_STATUS_FETCHED,
            payload: combatStatus
        }
}

export function setWalkPoperties(walkProperties){
    return {
        type:WALK_PROPERTIES_FETCHED,
        payload: walkProperties
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
export function getCombatStatusStateNoReducing(storyId){
    return CustomAxios
        .get(`${STORY_API}/status/${storyId}`);
}
export function getCombatAreaStatusState(placeId){
    return (dispatch) => {
        return CustomAxios
        .get(`${PLACE_API}/info/${placeId}`)
        .then(result => {
            dispatch(
                {
                    type:COMBAT_MAP_FETCHED,
                    payload: result.data
                }
            );
        }

            
        )
    };
}
export function getCombatAreaStatusStateNoReducing(placeId){
    return CustomAxios
    .get(`${PLACE_API}/info/${placeId}`)
}