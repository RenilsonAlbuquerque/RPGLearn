import { Component, OnInit } from '@angular/core';
import { MonsterInfo } from 'src/app/domain/models/monster/monster.info';
import { ActivatedRoute } from '@angular/router';
import { MonsterService } from '../monster.module.service';

@Component({
  selector: 'app-monster-info',
  templateUrl: './monster-info.component.html',
  styleUrls: ['./monster-info.component.scss']
})
export class MonsterInfoComponent implements OnInit {
  
  public monster: MonsterInfo
  constructor(private _activatedRoute: ActivatedRoute, private monsterService: MonsterService) { }

  ngOnInit() {
    this._activatedRoute.params.subscribe(params => {
      let id = params['id'];
      this.monsterService.getMonsterInfoById(id).subscribe(
        response => (this.monster = response)  
      )
    });
   
  }

}
