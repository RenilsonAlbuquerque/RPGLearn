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
  private currentCreatureTurn: string;
  private showList: boolean;
  
  constructor(private combatRoomService: CombatRoomService) {
    
    this.combatRoomService.getCombatState().subscribe(
      state =>{
        this.creatures = state.creatures;
        this.currentCreatureTurn = state.currentCreatureTurn;
      }
    );
  }
  hasCreatures(): boolean{
    return this.creatures.length > 0;
  }
  ngOnInit() {
  } 
  onShowList(){
    this.showList = !this.showList;
  }
  get currentCreature():CreatureCard{
    let result = null;
    if(this.creatures.length > 0){
      if(typeof this.currentCreatureTurn!='undefined' && this.currentCreatureTurn){
         for(let i = 0; i< this.creatures.length; i++){
           if(this.creatures[i].combatId === this.currentCreatureTurn){
              result = this.creatures[i];
           }
         }
      }else{
        return this.creatures[0];
      }
    }
    return result;
  }

}
