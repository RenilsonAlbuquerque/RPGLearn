import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CharacterCreateComponent } from './character-create/character-create.component';


const routes: Routes = [
    {
      path: '',
      data: {
        title: 'character'
      },
      children: [
        {
          path: '',
          redirectTo: 'list'
        },
        {
          path: 'create-in-story/:id',
          component: CharacterCreateComponent,
          
        }
      ]
    }
]
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class CharacterRoutingModule {}