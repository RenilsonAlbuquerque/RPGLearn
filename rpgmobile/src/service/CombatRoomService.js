
import { BASE_URL } from "../constants/constants";





class CombatRoomService{
    
    constructor(){
        this.client = {}
        this.storyId = -1;
    }

    
    sendMessage(combatState){
        this.client.send('/app/combat/'+ this.storyId,{priority:1},  JSON.stringify(combatState));
    }
    
    passTurn(combatState,playerId){
        currentCreatureCombatId = combatState.currentCreatureTurn

        for(let i = 0; i < combatState.creatures.length; i++){
            if(currentCreatureCombatId == combatState.creatures[i].combatId){
                if(i >= (combatState.creatures.length -1)){
                    combatState.currentCreatureTurn = combatState.creatures[0].combatId;  
                }else{
                    combatState.currentCreatureTurn = combatState.creatures[i+1].combatId;
                }
                this.sendMessage(combatState);
                break;
            }
        }
      
    }

    moveCharacter(combatState,coordinates,combatId){
        console.log(combatState)
        console.log(coordinates);
        console.log(combatId);
        for(let i = 0; i < combatState.creatures.length; i++){
            if(combatState.creatures[i].combatId == combatId){
                combatState.creatures[i].position = coordinates;
                this.sendMessage(combatState);
                break;
            }
        }
    }
  
    initiateInCombat(combatState,playableCreature){

        if(combatState.allyQueue){
            combatState.allyQueue = [];    
        }
        let checkInfAlreaddInCombat = combatState.creatures.some((creature) => creature.id ==  playableCreature.id)||
            combatState.creatures.some((creature) => creature.id ==  playerId); 
      
        if(!checkInfAlreaddInCombat){
            combatState.allyQueue.push(playableCreature);
            this.sendMessage(combatState);  
        }
        
    }


    //===========================Internal methods=============================
    // verifyIfPlayerAlreadyInField(combatState, playerId){
        
    //     let result = combatState.creatures.some((creature) => creature.id ==  playerId)
    //     console.log(result);
    //     console.log(combatState.allyQueue.some((ally) => ally.id ==  playerId))
        
    //    return combatState.allyQueue.some((ally) => ally.id ==  playerId) ||
    //         combatState.creatures.some((creature) => creature.id ==  playerId) 
    // }
    checkIfIsMyTurn(combatStatus,creatureId){
        for(let i = 0; i < combatStatus.creatures.length; i++){
            if(combatStatus.creatures[i].id == creatureId){
                return (combatStatus.currentCreatureTurn === combatStatus.creatures[i].combatId)
            }
        }
        return false;
    }
    setInstance(instance){
        this.client = instance;
        
    }
    setStoryId(storyId){
        this.storyId = storyId;

    }
}
let singletonInstance = new CombatRoomService();
//Object.freeze(singletonInstance);

export default singletonInstance;