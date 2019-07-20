import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-combat-menu',
  templateUrl: './combat-menu.component.html',
  styleUrls: ['./combat-menu.component.scss']
})
export class CombatMenuComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit() {
  }
  goNewCombat(){
    this.router.navigate(['home/combat/screen'])
  }

}
