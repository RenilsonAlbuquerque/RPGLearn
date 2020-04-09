import { Component } from '@angular/core';
import { SpinnerService } from './infra/services/spinner.service';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'shakal-rpg-web';
  isLoading: Subject<boolean> = this.loaderService.isLoading;
  
  constructor(private loaderService: SpinnerService){}
}
