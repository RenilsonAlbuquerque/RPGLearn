import { Component, OnInit, Input, OnChanges, SimpleChanges } from '@angular/core';
import { MonsterOverview } from 'src/app/domain/models/monster.overview';
import { Page } from 'src/app/infra/models/page';
import { MonsterService } from '../monster.module.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-monster-list',
  templateUrl: './monster-list.component.html',
  styleUrls: ['./monster-list.component.scss']
})
export class MonsterListComponent implements OnInit,OnChanges {
 

  @Input() public page: Page<MonsterOverview>;
  public search: String;
  
  
  constructor(private monsterService: MonsterService, private router: Router) { 
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
  ngOnChanges(): void {
    console.log("changes")
  }
  ngOnInit() {
    this.search = "";
    this.monsterService.getOverview(1).subscribe(
        response => {this.page = response}   
    )
  }
  pageChange(pageNumber: number){
    console.log(pageNumber + " "+ this.page.currentPageNumber)
    this.monsterService.getOverview(pageNumber).subscribe(
      response => (this.page = response)  
    )
  }
  onSearch(){
    this.monsterService.getSearchResult(this.search,1).subscribe(
      response => (this.page = response)  
    )
  }
  goDetails(monster){
    this.router.navigate(['home/monster/detail', monster.id])
  }
  goCreate(){
    this.router.navigate(['home/monster/create'])
  }

}
