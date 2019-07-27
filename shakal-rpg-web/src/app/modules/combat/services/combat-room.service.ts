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

  public addMonster(monster: MonsterCard){
    this.monsters.push(monster);
  }
  public getMonsters():MonsterCard[]{
      return this.monsters;
  }
  public updateMonsterLifePoints(index: number,value: number){
      this.monsters[index].lifePoints = value;
  }

}