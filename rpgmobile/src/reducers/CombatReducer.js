import { COMBAT_STATUS_FETCHED,COMBAT_MAP_FETCHED } from "../actions/CombatAction";
import { act } from "react-test-renderer";

const INITIAL_STATE = {
    combatState:{
        monsters:[],
        players:[],
        dificult:1
    },
    currentMap:{
        id:1,
        name:'',
        background: '',
        map:'',
        xDimension:0,
        yDimension:0,
        squareDimension:1.5,
        naturalHeight: 0,
        naturalWidth:0
        


    }
    
}
export default function (state = INITIAL_STATE, action = {}) {
    switch (action.type) {
        case COMBAT_STATUS_FETCHED:
            return {
            ...state,
            combatState : action.payload
        }
        case COMBAT_MAP_FETCHED:
            return{
                ...state,
                currentMap: action.payload
        }
        default:
            return state
    }
}