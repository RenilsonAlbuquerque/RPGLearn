import { RouterModule, Routes } from '@angular/router';
import { NgModule } from '@angular/core';
import { CombatMenuComponent } from './combat-menu/combat-menu.component';
import { CombatScreenComponent } from './combat-screen/combat-screen.component';

const routes: Routes = [
    {
      path: '',
      data: {
        title: 'combat'
      },
      children: [
        {
          path: '',
          redirectTo: 'menu'
        },
        {
            path: 'menu',
            component: CombatMenuComponent
        },
        {
            path: 'screen/:id',
            component: CombatScreenComponent
        }
      ]
    }
]
@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})
export class CombatRoutingModule {}