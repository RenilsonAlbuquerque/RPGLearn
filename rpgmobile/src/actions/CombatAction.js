
export const COMBAT_STATUS_FETCHED = 'COMBAT_STATUS_FETCHED';

export function setCombatStatus(combatStatus){

        return {
            type:COMBAT_STATUS_FETCHED,
            payload: combatStatus
        }
                 
    
}