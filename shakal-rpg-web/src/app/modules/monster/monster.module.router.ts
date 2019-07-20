import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { MonsterListComponent } from './monster-list/monster-list.component';
import { MonsterDetailComponent } from './monster-detail/monster-detail.component';


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
        },
        {
          path: 'detail/:id',
          component: MonsterDetailComponent
        }
      ]
    }
]
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class MonsterRoutingModule {}