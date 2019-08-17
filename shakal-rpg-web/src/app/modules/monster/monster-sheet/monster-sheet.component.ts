import { Component, OnInit, Input } from '@angular/core';
import { MonsterSheet } from 'src/app/domain/models/monster/monster.sheet';
import { ActivatedRoute } from '@angular/router';
import { MonsterService } from '../monster.module.service';
import { CombatRoomService } from '../../combat/services/combat-room.service';

@Component({
  selector: 'app-monster-sheet',
  templateUrl: './monster-sheet.component.html',
  styleUrls: ['./monster-sheet.component.scss']
})
export class MonsterSheetComponent implements OnInit {

  @Input() monsterId: number;
  @Input() currentLifePoints: number;
  @Input() monsterIndex: number;


  public amount: number;
  public monster: MonsterSheet;

  constructor(private _activatedRoute: ActivatedRoute, private monsterService: MonsterService,
    private combatRoomService: CombatRoomService) { 
      this.monster = {
        atributes: [],
        savingThrows: [],
        damageResistence: [],
        damageImunity: [],
        languages: [],
        features: [],
        actions: [],
        legendaryActions: []
      } as MonsterSheet;
    }

  ngOnInit() {
    this.amount = 0;
    this._activatedRoute.params.subscribe(params => {
      let id = params['id'];
      id = this.monsterId ? this.monsterId: id  
      this.monsterService.getMonsterSheetById(id).subscribe(
        response => (this.monster = response, console.log(response))  
      )
    });
   
  }
  addLifePoints(){
    var newLifePoints: number = parseInt(this.currentLifePoints.toString()) + parseInt(this.amount.toString()); 
    
    if(newLifePoints > this.monster.lifePoints){
      this.currentLifePoints = this.monster.lifePoints;
    }else{
      this.currentLifePoints = parseInt(this.currentLifePoints.toString()) + parseInt(this.amount.toString());
    }
    this.amount = 0;
    this.combatRoomService.updateMonsterLifePoints(this.monsterIndex,this.currentLifePoints);
  }
  
  subtractLifePoints(){
    var newLifePoints: number = this.currentLifePoints - this.amount;
    if(newLifePoints < 0){
      this.currentLifePoints = 0;
    }else{
      this.currentLifePoints = newLifePoints;
    }
    this.amount = 0;
    this.combatRoomService.updateMonsterLifePoints(this.monsterIndex,this.currentLifePoints);
    
  }

}
