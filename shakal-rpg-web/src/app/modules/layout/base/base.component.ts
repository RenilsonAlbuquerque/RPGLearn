import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/pages/auth.service';

@Component({
  selector: 'app-base',
  templateUrl: './base.component.html',
  styleUrls: ['./base.component.scss']
})
export class BaseComponent implements OnInit {

  public userName: string;
  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.userName = this.authService.getCurrentUser().name
  }
  callLogout(){
    this.authService.logout();
  }

}
