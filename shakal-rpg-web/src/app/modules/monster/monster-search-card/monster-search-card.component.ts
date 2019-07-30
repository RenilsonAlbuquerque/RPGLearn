import { Component, OnInit, Output, Input } from '@angular/core';
import { Page } from 'src/app/infra/models/page';
import { MonsterOverview } from 'src/app/domain/models/monster.overview';
import { MonsterService } from '../monster.module.service';
import { Router } from '@angular/router';
import { EventEmitter } from '@angular/core';
import { CombatRoomService } from '../../combat/services/combat-room.service';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-monster-search-card',
  templateUrl: './monster-search-card.component.html',
  styleUrls: ['./monster-search-card.component.scss']
})
export class MonsterSearchCardComponent implements OnInit {

  public page: Page<MonsterOverview>;
  public search: String;

  @Output() adcionarMonstro = new EventEmitter();
  @Output() fecharModal = new EventEmitter();
  


  constructor(private monsterService: MonsterService, private router: Router,private combatRoomService: CombatRoomService) { }

  ngOnInit() {
    this.search = "";
    this.monsterService.getOverview(1).subscribe(
        response => (this.page = response)   
    )
  }
  pageChange(){
    this.monsterService.getOverview(this.page.currentPageNumber).subscribe(
      response => (this.page = response)  
    )
  }
  onSearch(){
    this.monsterService.getSearchResult(this.search,1).subscribe(
      response => (this.page = response)  
    )
  }
  selectMonster(monster: MonsterOverview){
    this.monsterService.getMonsterCardById(monster.id).subscribe(
      response => ( this.combatRoomService.addMonster(response),
                    this.fecharModal.emit(true)
    ));
  }

}
