import { Component, OnInit } from '@angular/core';
import { Page } from 'src/app/infra/models/page';
import { MonsterOverview } from 'src/app/domain/models/monster.overview';
import { MonsterService } from '../monster.module.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-monster-search-card',
  templateUrl: './monster-search-card.component.html',
  styleUrls: ['./monster-search-card.component.scss']
})
export class MonsterSearchCardComponent implements OnInit {

  public page: Page<MonsterOverview>;
  public search: String;
  constructor(private monsterService: MonsterService, private router: Router) { }

  ngOnInit() {
    this.search = "";
    this.monsterService.getOverview(1).subscribe(
        response => (this.page = response,console.log(response))   
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
  goDetails(monster){
    this.router.navigate(['home/monster/detail', monster.id])
  }

}
