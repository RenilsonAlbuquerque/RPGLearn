import { Routes, RouterModule } from '@angular/router';
import { StoryMapComponent } from './story-map/story-map.component';
import { NgModule } from '@angular/core';
import { StoryListComponent } from './story-list/story-list.component';
import { StoryDetailComponent } from './story-detail/story-detail.component';

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
          children:[
            {
              path: '',
              redirectTo: 'map'
            },
            {
              path: 'map',
              component: StoryMapComponent
            }
          ]
        }
      ]
    }
]
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class StoryRoutingModule {}