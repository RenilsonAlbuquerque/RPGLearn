import { Component, OnInit } from '@angular/core';
import { WeaponModuleService } from '../weapon.module.service';
import { WeaponInfo } from 'src/app/domain/models/weapon/weapon.info';

@Component({
  selector: 'app-weapon-detail',
  templateUrl: './weapon-detail.component.html',
  styleUrls: ['./weapon-detail.component.scss']
})
export class WeaponDetailComponent implements OnInit {

  public weapon:WeaponInfo = {
    id: 0,
    imagePath:"",
    name:"",
    description: "",
    rarity: {id:0,value:""},
    category: {id:0,value:""},
    classification: {id:0,value:""},
    range: {id:0,value:""},
    cost: {id:0,quantity:0,coin:{id: 0,
      name: "",
      abreviation: ""}},
    weight:0,
    damage:[],
    bonus:0
  };
  constructor(private weaponModuleService: WeaponModuleService) {
    this.weaponModuleService.getWeaponDetail(2).subscribe(
      result => {
        this.weapon = result;
      }
    )
   }

  ngOnInit() {
    
  }

}
