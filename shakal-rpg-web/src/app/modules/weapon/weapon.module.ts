import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { WeaponListComponent } from './weapon-list/weapon-list.component';
import { WeaponDetailComponent } from './weapon-detail/weapon-detail.component';
import { WeaponModuleService } from './weapon.module.service';



@NgModule({
  declarations: [WeaponListComponent, WeaponDetailComponent],
  providers:[WeaponModuleService],
  imports: [
    CommonModule
  ],exports:[WeaponDetailComponent]
})
export class WeaponModule { }
