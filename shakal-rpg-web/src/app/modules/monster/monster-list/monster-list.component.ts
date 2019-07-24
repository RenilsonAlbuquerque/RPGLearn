import { Component, OnInit } from '@angular/core';
import { MonsterOverview } from 'src/app/domain/models/monster.overview';
import { Page } from 'src/app/infra/models/page';
import { MonsterService } from '../monster.module.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-monster-list',
  templateUrl: './monster-list.component.html',
  styleUrls: ['./monster-list.component.scss']
})
export class MonsterListComponent implements OnInit {

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
  goCreate(){
    this.router.navigate(['home/monster/create'])
  }

}
