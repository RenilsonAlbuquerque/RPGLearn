import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BaseComponent } from './modules/layout/base/base.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginPageComponent
  },
  {
    path: 'home',
    component: BaseComponent,
    children:[
      {
        path: 'monster',
        loadChildren: './modules/monster/monster.module#MonsterModule'
      },
      {
        path: 'combat',
        loadChildren: './modules/combat/combat.module#CombatModule'
      },
      {
        path: 'story',
        loadChildren: './modules/story/story.module#StoryModule'
      }

    ]
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
