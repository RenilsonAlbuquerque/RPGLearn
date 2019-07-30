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
    private combatRoomService: CombatRoomService) { }

  ngOnInit() {
    this.amount = 0;
    this._activatedRoute.params.subscribe(params => {
      let id = params['id'];
      id = id ? id : this.monsterId
      this.monsterService.getMonsterSheetById(id).subscribe(
        response => (this.monster = response)  
      )
    });
   
  }
  addLifePoints(){
    this.currentLifePoints = parseInt(this.currentLifePoints.toString()) + parseInt(this.amount.toString());
    this.amount = 0;
    this.combatRoomService.updateMonsterLifePoints(this.monsterIndex,this.currentLifePoints);
  }
  
  subtractLifePoints(){
    this.currentLifePoints -= this.amount;
    this.amount = 0;
    this.combatRoomService.updateMonsterLifePoints(this.monsterIndex,this.currentLifePoints);
    
  }

}
