import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';

import { environment } from 'src/environments/environment';
import { StompService, StompConfig, StompState } from "@stomp/ng2-stompjs";
import { Observable } from 'rxjs';
import { IMessage } from '@stomp/stompjs';

@Injectable()
export class CombatRoomService {

  private monsters: MonsterCard[];
  private players: MonsterCard[];

  private stompService: StompService;
  private messages: Observable<IMessage>;
  
  constructor(private httpClient: HttpClient) {
      this.monsters = [];
      this.players = [];
      let stompConfig: StompConfig = {
        url: `${environment.BASE_SOCKET_URL}combat`,
        headers: {
          login: "",
          passcode: ""
        },
        heartbeat_in: 0,
        heartbeat_out: 20000,
        reconnect_delay: 5000,
        debug: true
      };
      this.stompService = new StompService(stompConfig);
      this.messages = this.stompService.subscribe(environment + "/topic/room");
  }
  public stream(): Observable<IMessage> {
    return this.messages;
  }


  public addMonsterEnemy(monster: MonsterCard){
    this.monsters.push(monster);
  }
  public addMonsterAlly(monster: MonsterCard){
    this.players.push(monster);
  }
  public getMonsters():MonsterCard[]{
      return this.monsters;
  }
  public getPlayers():MonsterCard[]{
    return this.players;
  }
  public updateMonsterLifePoints(index: number,value: number){
    if(value < 0){
      this.monsters[index].lifePoints = 0; 
    }
    else if(value > this.monsters[index].totalLifePoints){
      this.monsters[index].lifePoints = this.monsters[index].totalLifePoints;
    }else{
      this.monsters[index].lifePoints = value; 
    }
      
  }
  public removeEnemy(index: number){
    this.monsters.splice(index,1);
  }
  
  public removeAlly(index: number){
    this.players.splice(index,1);
  }
}