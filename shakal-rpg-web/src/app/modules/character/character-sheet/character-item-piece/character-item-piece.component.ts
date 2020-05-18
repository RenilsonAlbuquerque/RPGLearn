import { Component, OnInit, Input } from '@angular/core';
import { CharacterSheet } from 'src/app/domain/models/character/character.sheet';
import { EquipmentOverview } from 'src/app/domain/models/equipment/equipment.overview';

@Component({
  selector: 'app-character-item-piece',
  templateUrl: './character-item-piece.component.html',
  styleUrls: ['./character-item-piece.component.scss']
})
export class CharacterItemPieceComponent implements OnInit {

  @Input()
  private sheet: CharacterSheet;

  equipment:EquipmentOverview[];
  constructor() {
    this.equipment = [
      {
        id:1,
        name:"Espada de Odin",
        weight:1,
        cost:"5 GP"
      },
      {
        id:1,
        name:"Capa da invisibilidade",
        weight:3,
        cost:"10 GP"
      }
    ];
   }

  ngOnInit() {
  }

}
