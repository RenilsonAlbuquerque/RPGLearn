import { Routes, RouterModule } from '@angular/router';
import { StoryMapComponent } from './story-map/story-map.component';
import { NgModule } from '@angular/core';

const routes: Routes = [
    {
      path: '',
      data: {
        title: 'story'
      },
      children: [
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
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class StoryRoutingModule {}