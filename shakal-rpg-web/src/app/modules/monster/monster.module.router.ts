import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { MonsterListComponent } from './monster-list/monster-list.component';
import { MonsterDetailComponent } from './monster-detail/monster-detail.component';
import { MonsterCreateComponent } from './monster-create/monster-create.component';


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
        },
        {
          path: 'create',
          component: MonsterCreateComponent
        }
      ]
    }
]
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class MonsterRoutingModule {}