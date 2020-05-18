import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CoinIconComponent } from './coin-icon/coin-icon.component';



@NgModule({
  declarations: [CoinIconComponent],
  imports: [
    CommonModule
  ],
  exports:[CoinIconComponent]
})
export class CoinModule { }
