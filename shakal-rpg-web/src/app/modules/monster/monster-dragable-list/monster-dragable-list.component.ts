import { Component, OnInit } from '@angular/core';
import { MonsterService } from '../monster.module.service';
import { Page } from 'src/app/infra/models/page';
import { MonsterOverview } from 'src/app/domain/models/monster.overview';
import { DragCreature } from 'src/app/domain/models/creature/drag.creature';

@Component({
  selector: 'app-monster-dragable-list',
  templateUrl: './monster-dragable-list.component.html',
  styleUrls: ['./monster-dragable-list.component.scss']
})
export class MonsterDragableListComponent implements OnInit {

  public page: Page<MonsterOverview>;
  public search: String;
  public ally: boolean;
  constructor(private monsterService: MonsterService) {
    this.ally = true;
    this.page = {
      elements: [],
      currentPageNumber: 1,
      totalElements: 1,
      totalOfPages: 1,
      size: 1,
      firts: true,
      last: true

    } as Page<MonsterOverview>;
   }

  ngOnInit() {
  }
  onSearch(){
    this.monsterService.getSearchResult(this.search,1).subscribe(
      response => (this.page = response)  
    )
  }
  drag(ev: DragEvent, monster: MonsterOverview) {
    ev.dataTransfer.setData("monster", JSON.stringify(
      {
        id: monster.id, 
        ally: (this.ally)? true: false 
      } as DragCreature)
    );
  }
}
