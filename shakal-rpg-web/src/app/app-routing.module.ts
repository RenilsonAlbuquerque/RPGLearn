import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { BaseComponent } from './modules/layout/base/base.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { CanActivateRouteGuard } from './interceptors/can.activate';
import { RegisterPlayerComponent } from './pages/register-player/register-player.component';


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
    path: 'register',
    component: RegisterPlayerComponent
  },
  {
    path: 'home',
    canActivate:[CanActivateRouteGuard],
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
      },
      {
        path: 'character',
        loadChildren: './modules/character/character.module#CharacterModule'
      }

    ]
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
