import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';

@Injectable()
export class CombatRoomService {

  private monsters: MonsterCard[];
  private players: MonsterCard[];
  
  constructor(private httpClient: HttpClient) {
      this.monsters = [];
      this.players = [];
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