import { Component, OnInit } from '@angular/core';
import { CombatRoomService } from '../services/combat-room.service';
import { CreatureCard } from 'src/app/domain/models/monster/creature.card';

@Component({
  selector: 'app-combaat-turn-order',
  templateUrl: './combaat-turn-order.component.html',
  styleUrls: ['./combaat-turn-order.component.scss']
})
export class CombaatTurnOrderComponent implements OnInit {

  private creatures: CreatureCard[];
  private showList: boolean;
  constructor(private combatRoomService: CombatRoomService) {
    this.combatRoomService.getCombatState().subscribe(
      state =>{
        this.creatures = state.creatures;
      }
    );
  }

  ngOnInit() {
  } 
  onShowList(){
    this.showList = !this.showList;
  }

}
