import { Routes, RouterModule } from '@angular/router';
import { StoryMapComponent } from './story-map/story-map.component';
import { NgModule } from '@angular/core';
import { StoryListComponent } from './story-list/story-list.component';
import { StoryDetailComponent } from './story-detail/story-detail.component';
import { PlaceDetailComponent } from './place-detail/place-detail.component';
import { StoryCreateComponent } from './story-create/story-create.component';

const routes: Routes = [
    {
      path: '',
      data: {
        title: 'story'
      },
      children: [
        {
          path: '',
          redirectTo: 'list'
        },
        {
          path: 'list',
          component: StoryListComponent
        },
        {
          path: 'datail/:id',
          component: StoryDetailComponent,
          
        },
        {
              
          path: 'place/:id',
          component: PlaceDetailComponent
        },
        {
          path: 'create',
          component: StoryCreateComponent
        }
      ]
    }
]
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class StoryRoutingModule {}