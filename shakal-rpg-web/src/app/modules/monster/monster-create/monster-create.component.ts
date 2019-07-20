import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { MonsterCreate } from 'src/app/domain/models/monster/monster.create';

@Component({
  selector: 'app-monster-create',
  templateUrl: './monster-create.component.html',
  styleUrls: ['./monster-create.component.scss']
})
export class MonsterCreateComponent implements OnInit {

  public monster: MonsterCreate;
  public informacoesFormGroup: FormGroup;
  public habilitiesFormGroup: FormGroup;

  profilePicture: string;

  constructor(private _formBuilder: FormBuilder) { }

  ngOnInit() {
    this.informacoesFormGroup = this._formBuilder.group({
      profilePicture: [''],
      name: ['',Validators.required],
      description: ['',Validators.required]
    });
    this.habilitiesFormGroup = this._formBuilder.group({
      armorClass: ['', Validators.required],
      lifePoints: ['', Validators.required],
      moviment: ['', Validators.required],
      force: ['', Validators.required],
      dexterity: ['', Validators.required],
      constitution: ['', Validators.required],
      inteligence: ['', Validators.required],
      wisdom: ['', Validators.required],
      charisma: ['', Validators.required]

    });
  }

}
