import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BaseComponent } from './base/base.component';
import { AppRoutingModule } from 'src/app/app-routing.module';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [BaseComponent],
  imports: [
 
  AppRoutingModule,
    CommonModule,
    NgbModule
  ]
})
export class LayoutModule { }
