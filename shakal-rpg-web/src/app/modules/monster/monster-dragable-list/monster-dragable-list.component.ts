import { Component, OnInit } from '@angular/core';
import { MonsterService } from '../monster.module.service';
import { Page } from 'src/app/infra/models/page';
import { MonsterOverview } from 'src/app/domain/models/monster.overview';

@Component({
  selector: 'app-monster-dragable-list',
  templateUrl: './monster-dragable-list.component.html',
  styleUrls: ['./monster-dragable-list.component.scss']
})
export class MonsterDragableListComponent implements OnInit {

  public page: Page<MonsterOverview>;
  public search: String;
  constructor(private monsterService: MonsterService) {
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
  drag(ev: DragEvent, monster) {
    ev.dataTransfer.setData("monster", JSON.stringify(monster));
  }
}
