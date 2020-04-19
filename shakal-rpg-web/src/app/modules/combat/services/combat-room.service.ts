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
    combatState.creatures.push(enemy);
    this.onSendMessage(combatState);
  }
  public addMonsterAlly(ally: CreatureCard){
    var combatState: CombatState = this.combatState.getValue();
    ally.ally = true;
    combatState.creatures.push(ally);
    this.onSendMessage(combatState);
  }
  public getCombatState():Observable<CombatState>{
    return this.combatState.asObservable();
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
  public removeEnemy(index: number){
    var combatState: CombatState = this.combatState.getValue();
    combatState.creatures.splice(index,1);
    this.onSendMessage(combatState);
  }
  
  public removeAlly(index: number){
    var combatState: CombatState = this.combatState.getValue();
    combatState.creatures.splice(index,1);
    this.onSendMessage(combatState);
  }
  public updateCreature(creature:CreatureCard){
    var combatState: CombatState = this.combatState.getValue();
    for(let i = 0; i < combatState.creatures.length; i++){
      if(combatState.creatures[i].combatId == creature.combatId){
        combatState.creatures[i] = creature;
      }
    }
    // combatState.monsters.forEach(enemy => {
    //   if(enemy.combatId == creature.combatId){
    //     enemy = creature;
    //   }
    // });
    // combatState.players.forEach(ally => {
    //   if(ally.combatId == creature.combatId){
    //     console.log("updated reference")
    //     ally = creature;
    //   }
    // });
    //this.combatState.next(combatState);
    this.onSendMessage(combatState);
  }
 
}