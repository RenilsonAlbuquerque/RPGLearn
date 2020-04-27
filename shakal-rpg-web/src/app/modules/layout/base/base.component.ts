import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/pages/auth.service';
import { SidebarItem, sidebarItems } from 'src/app/infra/models/sidebar';


@Component({
  selector: 'app-base',
  templateUrl: './base.component.html',
  styleUrls: ['./base.component.scss']
})
export class BaseComponent implements OnInit {

  public userName: string;
  public sidebarItems: SidebarItem[];
  public selectedIndex: number;
  constructor(private authService: AuthService) {
      this.sidebarItems = sidebarItems;
      this.selectedIndex = 0;
  }
  changeSelected(sidebar){
    sidebar.toggle();
  }

  ngOnInit() {
    this.userName = this.authService.getCurrentUser().name
  }
  callLogout(){
    this.authService.logout();
  }

}
