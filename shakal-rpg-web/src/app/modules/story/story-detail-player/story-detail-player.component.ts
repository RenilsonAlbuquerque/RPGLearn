import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-story-detail-player',
  templateUrl: './story-detail-player.component.html',
  styleUrls: ['./story-detail-player.component.scss']
})
export class StoryDetailPlayerComponent implements OnInit {

  private combatShown: boolean;
  private mapShown: boolean;
  constructor() {
    this.combatShown = true;
    this.mapShown = false;
   }

  ngOnInit() {
  }
  onShowCombat(){
    this.combatShown = true;
    this.mapShown = false;
  }
  onShowMap(){
    this.combatShown = false;
    this.mapShown = true;
  }

}
