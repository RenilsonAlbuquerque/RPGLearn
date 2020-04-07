import { Component, OnInit, Input } from '@angular/core';
import { MonsterCard } from 'src/app/domain/models/monster/monster.card';

@Component({
  selector: 'app-monster-card',
  templateUrl: './monster-card.component.html',
  styleUrls: ['./monster-card.component.scss']
})
export class MonsterCardComponent implements OnInit {


  @Input() public monster: MonsterCard;
  constructor() { }

  ngOnInit() {
  }

}
