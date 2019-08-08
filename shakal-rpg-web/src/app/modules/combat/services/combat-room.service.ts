import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';

import {  RxStompService } from "@stomp/ng2-stompjs";
import { IMessage } from '@stomp/stompjs';
import { CombatState } from 'src/app/domain/models/combat/combat.state';
import { Observable, BehaviorSubject } from 'rxjs';

@Injectable()
export class CombatRoomService {


  private combatState: BehaviorSubject<CombatState>;
  
  constructor(private httpClient: HttpClient,private rxStompService: RxStompService) {
      this.combatState = new BehaviorSubject<CombatState>({
        monsters :[],
        players: [],
        dificult: 1
      } as CombatState);
      
      

      this.rxStompService.watch('/topic/combat/1').subscribe((message: IMessage) => {
        this.combatState.next(JSON.parse(message.body) as CombatState);
      });
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

  private onSendMessage(combatState: CombatState) {
    this.rxStompService.publish({destination: '/app/combat/1', body: JSON.stringify(combatState)});
  }
}