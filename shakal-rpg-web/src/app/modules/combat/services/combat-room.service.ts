import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CreatureCard } from 'src/app/domain/models/monster/creature.card';

import {  RxStompService } from "@stomp/ng2-stompjs";
import { IMessage } from '@stomp/stompjs';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { Observable, BehaviorSubject } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable()
export class CombatRoomService {

  private storyId: number;
  protected combatState: BehaviorSubject<CombatState>; 
 

  constructor(protected httpClient: HttpClient,protected rxStompService: RxStompService) {
      this.combatState = new BehaviorSubject<CombatState>({
        creatures :[],
        allyQueue:[],
        enemyQueue:[],
        dificult: 1
      } as CombatState); 
  }
  protected onSendMessage(combatState: CombatState) {
    this.rxStompService.publish({destination: '/app/combat/' + this.storyId, body: JSON.stringify(combatState)});
  }
  public initializeCombat(storyId: number){
    this.storyId = storyId;
    
    // this.httpClient.get<CombatState>(`${environment.BASE_URL}combat/status/${storyId}`).subscribe(
    //   response => {
    //     this.combatState.next(response)
    //   } 
    // )
    this.rxStompService.watch('/topic/combat/'+ storyId).subscribe((message: IMessage) => {
      this.combatState.next(JSON.parse(message.body) as CombatState);
    })
    
  }

  public addMonsterEnemy(enemy: CreatureCard){
    var combatState: CombatState = this.combatState.getValue();
    enemy.ally = false;
    combatState.enemyQueue.push(enemy);
    this.onSendMessage(combatState);
  }
  public addMonsterAlly(ally: CreatureCard){
    var combatState: CombatState = this.combatState.getValue();
    ally.ally = true;
    combatState.allyQueue.push(ally);
    this.onSendMessage(combatState);
  }
  public addCreatureToCombat(creature: CreatureCard){
    var combatState: CombatState = this.combatState.getValue();
    if(!this.creatureAlreadyInCombat(creature.combatId)){
      combatState.creatures.push(creature);
      this.onSendMessage(combatState);
    }
    
  }
  public getCombatState():Observable<CombatState>{
    return this.combatState.asObservable();
  }
  public getCombatStateValue():CombatState{
    return this.combatState.value;
  }

  public updateMonsterLifePoints(index: number,value: number){
    
    var combatState: CombatState = this.combatState.getValue();
    if(value < 0){
      combatState.creatures[index].lifePoints = 0; 
    }
    else if(value > combatState.creatures[index].totalLifePoints){
      combatState.creatures[index].lifePoints = combatState.creatures[index].totalLifePoints;
    }else{
      combatState.creatures[index].lifePoints = value; 
    }
    this.onSendMessage(combatState);
      
  }
  public removeEnemy(combatId: string){
    var combatState: CombatState = this.combatState.getValue();
    
    for(let i = 0; i < combatState.enemyQueue.length; i++){
      if(combatState.enemyQueue[i].combatId === combatId){
        combatState.creatures.splice(i,1);
        this.onSendMessage(combatState);
        break; 
      }
    }
  }
  
  public removeAlly(index: number){
    var combatState: CombatState = this.combatState.getValue();
    combatState.creatures.splice(index,1);
    this.onSendMessage(combatState);
  }
  public updateCreature(creature:CreatureCard){
    let combatState: CombatState = this.combatState.getValue();
    for(let i = 0; i < combatState.creatures.length; i++){
      if(combatState.creatures[i].combatId == creature.combatId){
        combatState.creatures[i] = creature;
      }
    }
    this.onSendMessage(combatState);
  }
  public updateCreatures(creatures:CreatureCard[]){
    let combatState: CombatState = this.combatState.getValue();
    for(let i = 0; i < creatures.length; i++){
      for(let j = 0; j< combatState.creatures.length;j++){
        if(combatState.creatures[i].combatId == creatures[j].combatId){
          combatState.creatures[j] = creatures[i];
        }
      }
    }
    this.onSendMessage(combatState);
  }
  public creatureAlreadyInCombat(creatureCombatId: string): boolean{
    let result = false;
    let combatState: CombatState = this.combatState.getValue();
    combatState.creatures.forEach(creature =>{
      if(creature.combatId === creatureCombatId){
        result = true;
      }
    })
    return result;
  }
}