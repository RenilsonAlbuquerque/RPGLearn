import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';

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
        monsters :[],
        players: [],
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

  public addMonsterEnemy(monster: MonsterCard){
    var combatState: CombatState = this.combatState.getValue();
    combatState.monsters.push(monster);
    this.onSendMessage(combatState);
  }
  public addMonsterAlly(monster: MonsterCard){
    var combatState: CombatState = this.combatState.getValue();
    combatState.players.push(monster);
    this.onSendMessage(combatState);
  }
  public getCombatState():Observable<CombatState>{
    return this.combatState.asObservable();
  }

  public updateMonsterLifePoints(index: number,value: number){
    
    var combatState: CombatState = this.combatState.getValue();
    if(value < 0){
      combatState.monsters[index].lifePoints = 0; 
    }
    else if(value > combatState.monsters[index].totalLifePoints){
      combatState.monsters[index].lifePoints = combatState.monsters[index].totalLifePoints;
    }else{
      combatState.monsters[index].lifePoints = value; 
    }
    this.onSendMessage(combatState);
      
  }
  public removeEnemy(index: number){
    var combatState: CombatState = this.combatState.getValue();
    combatState.monsters.splice(index,1);
    this.onSendMessage(combatState);
  }
  
  public removeAlly(index: number){
    var combatState: CombatState = this.combatState.getValue();
    combatState.players.splice(index,1);
    this.onSendMessage(combatState);
  }
 
 
}