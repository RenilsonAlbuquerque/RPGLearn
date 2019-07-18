import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { MonsterListComponent } from './monster-list/monster-list.component';


const routes: Routes = [
    {
      path: '',
      data: {
        title: 'monster'
      },
      children: [
        {
          path: '',
          redirectTo: 'all'
        },
        {
            path: 'all',
            component: MonsterListComponent
        }
      ]
    }
]
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class MonsterRoutingModule {}