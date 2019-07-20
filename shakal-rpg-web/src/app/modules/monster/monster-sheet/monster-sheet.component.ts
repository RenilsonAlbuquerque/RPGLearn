import { Component, OnInit } from '@angular/core';
import { MonsterSheet } from 'src/app/domain/models/monster/monster.sheet';
import { ActivatedRoute } from '@angular/router';
import { MonsterService } from '../monster.module.service';

@Component({
  selector: 'app-monster-sheet',
  templateUrl: './monster-sheet.component.html',
  styleUrls: ['./monster-sheet.component.scss']
})
export class MonsterSheetComponent implements OnInit {

  public monster: MonsterSheet
  constructor(private _activatedRoute: ActivatedRoute, private monsterService: MonsterService) { }

  ngOnInit() {
    this._activatedRoute.params.subscribe(params => {
      let id = params['id'];
      this.monsterService.getMonsterSheetById(id).subscribe(
        response => (this.monster = response, console.log(response))  
      )
    });
   
  }

}
