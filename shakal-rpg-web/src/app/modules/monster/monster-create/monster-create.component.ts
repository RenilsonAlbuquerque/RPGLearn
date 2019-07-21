import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { MonsterCreate } from 'src/app/domain/models/monster/monster.create';
import { MonsterCreateInput } from 'src/app/domain/models/monster/monster.create.input';
import { MonsterService } from '../monster.module.service';
import { KeyValue } from 'src/app/domain/models/comon/key.value';


@Component({
  selector: 'app-monster-create',
  templateUrl: './monster-create.component.html',
  styleUrls: ['./monster-create.component.scss']
})
export class MonsterCreateComponent implements OnInit {

  public inputValues: MonsterCreateInput;
  
  public monster: MonsterCreate;
  public informacoesFormGroup: FormGroup;
  public habilitiesFormGroup: FormGroup;
  public featuresFormGroup: FormGroup;

  public allLanguages: string[];

  profilePicture: string;

  constructor(private _formBuilder: FormBuilder,private monsterService: MonsterService) { }

  ngOnInit() {
    this.monsterService.getMonsterCreateInput().subscribe(
      response => (
        this.inputValues = response
        //this.allLanguages = response.languages.map((item, key) => item)
        )   
    )

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
      charisma: ['', Validators.required],
      level:[{}, Validators.required],
      damageResistence:[],
      damageImunity:[],
      languages:[]

    });
  }
  public onSubmit(){
    this.monsterService.createMonster(this.mapFormToDTO()).subscribe(
      response => (console.log(response))   
    )
  }
  private mapFormToDTO(): MonsterCreate {
    console.log(this.habilitiesFormGroup.get('languages').value)
    return {
      raceName: this.informacoesFormGroup.get('profilePicture').value,
      raceDescription: this.informacoesFormGroup.get('description').value,
      imagePath: this.informacoesFormGroup.get('profilePicture').value,
      level: this.habilitiesFormGroup.get('level').value
    } as MonsterCreate;
  }

}
