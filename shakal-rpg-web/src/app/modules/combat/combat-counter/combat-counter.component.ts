import { Component, OnInit } from '@angular/core';
import { CreatureCard } from 'src/app/domain/models/monster/creature.card';
import { CombatRoomService } from '../services/combat-room.service';

@Component({
  selector: 'app-combat-counter',
  templateUrl: './combat-counter.component.html',
  styleUrls: ['./combat-counter.component.scss']
})
export class CombatCounterComponent implements OnInit {

  private creatures: CreatureCard[];
  constructor(private combatRoomService: CombatRoomService) {
    this.combatRoomService.getCombatState().subscribe(
      state =>{
        this.creatures = state.creatures;
      }
    );
  }
  hasCreatures(): boolean{
    return this.creatures.length > 0;
  }
  ngOnInit() {
  } 

}
