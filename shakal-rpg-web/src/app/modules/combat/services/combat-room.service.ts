import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';

import {  RxStompService } from "@stomp/ng2-stompjs";
import { IMessage } from '@stomp/stompjs';
import { CombatState } from 'src/app/domain/models/combat/combat.state';

@Injectable()
export class CombatRoomService {


  private combatState: CombatState;
  
  constructor(private httpClient: HttpClient,private rxStompService: RxStompService) {
      this.combatState = {
        monsters : [],
        players: [],
        dificult: 1
      } as CombatState;

      this.rxStompService.watch('/topic/combat/1').subscribe((message: IMessage) => {
        this.combatState = JSON.parse(message.body) as CombatState;
      });
  }


  public addMonsterEnemy(monster: MonsterCard){
    this.combatState.monsters.push(monster);
    this.onSendMessage();
  }
  public addMonsterAlly(monster: MonsterCard){
    this.combatState.players.push(monster);
    this.onSendMessage();
  }
  public getMonsters():MonsterCard[]{
      return this.combatState.monsters;
  }
  public getPlayers():MonsterCard[]{
    return this.combatState.players;
  }
  public updateMonsterLifePoints(index: number,value: number){
    if(value < 0){
      this.combatState.monsters[index].lifePoints = 0; 
    }
    else if(value > this.combatState.monsters[index].totalLifePoints){
      this.combatState.monsters[index].lifePoints = this.combatState.monsters[index].totalLifePoints;
    }else{
      this.combatState.monsters[index].lifePoints = value; 
    }
    this.onSendMessage();
      
  }
  public removeEnemy(index: number){
    this.combatState.monsters.splice(index,1);
    this.onSendMessage();
  }
  
  public removeAlly(index: number){
    this.combatState.players.splice(index,1);
    this.onSendMessage();
  }

  private onSendMessage() {
    this.rxStompService.publish({destination: '/app/combat/1', body: JSON.stringify(this.combatState)});
  }
}