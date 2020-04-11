import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';

@Component({
  selector: 'app-monster-card',
  templateUrl: './monster-card.component.html',
  styleUrls: ['./monster-card.component.scss']
})
export class MonsterCardComponent implements OnInit {


  @Input() public monster: MonsterCard;
  @Output() deleteEnemy= new EventEmitter<any>();
  constructor() { }

  ngOnInit() {
  }

  callDelete(){
    this.deleteEnemy.emit();
  }
  drag(ev: DragEvent) {
    ev.dataTransfer.setData("monster", JSON.stringify(this.monster));
  }
}
