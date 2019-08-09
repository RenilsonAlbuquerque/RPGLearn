import { COMBAT_STATUS_FETCHED } from "../actions/CombatAction";

const INITIAL_STATE = {
    combatState:{
        monsters:[],
        players:[],
        dificult:1
    }
    
}
export default function (state = INITIAL_STATE, action = {}) {
    switch (action.type) {
        case COMBAT_STATUS_FETCHED:
            return {
            ...state,
            combatState : action.payload
        }
        default:
            return state
    }
}