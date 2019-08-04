import { Component, OnInit } from '@angular/core';
import { StoryOverview } from 'src/app/domain/models/story/story-overview';
import { Page } from 'src/app/infra/models/page';
import { StoryService } from '../story.module.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-story-list',
  templateUrl: './story-list.component.html',
  styleUrls: ['./story-list.component.scss']
})
export class StoryListComponent implements OnInit {

  public page: Page<StoryOverview>;
  public search: String;
  
  constructor(private storyService: StoryService, private router: Router) { }

  ngOnInit() {
    
    this.search = "";
    this.storyService.getOverview(1).subscribe(
        response => (this.page = response)  
    )
  }
  goEdit(story){
    this.router.navigate(['home/story/datail', story.id])
  }
  pageChange(){
    this.storyService.getOverview(this.page.currentPageNumber).subscribe(
      response => (this.page = response)  
    )
  }
  onSearch(){
    this.storyService.getSearchResult(this.search,1).subscribe(
      response => (this.page = response)  
    )
  }

}
