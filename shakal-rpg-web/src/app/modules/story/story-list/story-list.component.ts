import { Component, OnInit } from '@angular/core';
import { StoryOverview } from 'src/app/domain/models/story/story-overview';
import { Page } from 'src/app/infra/models/page';
import { StoryService } from '../story.module.service';
import { Router } from '@angular/router';
import { UserRoleStory } from 'src/app/domain/models/story/user-role-story';
//import { UserRoleStory } '../../../domain/models/story/user-role-story.ts';

@Component({
  selector: 'app-story-list',
  templateUrl: './story-list.component.html',
  styleUrls: ['./story-list.component.scss']
})
export class StoryListComponent implements OnInit {

  public page: Page<StoryOverview>;
  public search: String;
  
  constructor(private storyService: StoryService, private router: Router) {
    this.page = {
      elements: [],
      currentPageNumber: 1,
      totalElements: 1,
      totalOfPages: 1,
      size: 1,
      firts: true,
      last: true

    } as Page<StoryOverview>;
  }

  ngOnInit() {
    
    this.search = "";
    this.storyService.getOverviewsListOfUser(1).subscribe(
        response => (this.page = response)  
    )
  }
  goEdit(story){
    if(story.userRoleInStory == UserRoleStory.master){
      this.router.navigate(['home/story/datail', story.id])
    }
    else{
      this.router.navigate(['home/story/datail-player', story.id])
    }
    
  }
  pageChange(pageNumber: number){
    this.storyService.getOverview(pageNumber).subscribe(
      response => (this.page = response)  
    )
  }
  onSearch(){
    this.storyService.getSearchResult(this.search,1).subscribe(
      response => (this.page = response)  
    )
  }
  goCreateStory(){
    this.router.navigate(['home/story/create'])
  }

}
