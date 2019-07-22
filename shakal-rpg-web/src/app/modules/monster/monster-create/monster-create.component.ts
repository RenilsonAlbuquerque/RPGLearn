import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators, FormArray} from '@angular/forms';
import { MonsterCreate } from 'src/app/domain/models/monster/monster.create';
import { MonsterCreateInput } from 'src/app/domain/models/monster/monster.create.input';
import { MonsterService } from '../monster.module.service';
import { KeyValue } from 'src/app/domain/models/comon/key.value';
import { NameDescription } from 'src/app/domain/models/comon/name-description';


@Component({
  selector: 'app-monster-create',
  templateUrl: './monster-create.component.html',
  styleUrls: ['./monster-create.component.scss']
})
export class MonsterCreateComponent implements OnInit {

  //Business objectss
  public inputValues: MonsterCreateInput;
  
  //FormGroups
  public informacoesFormGroup: FormGroup;
  public habilitiesFormGroup: FormGroup;
  public featuresFormGroup: FormGroup;
  

  //Items of the component
  public features: FormArray;
  profilePicture: string;

  constructor(private _formBuilder: FormBuilder,private monsterService: MonsterService) { }

  ngOnInit() {
    this.monsterService.getMonsterCreateInput().subscribe(
      response => (this.inputValues = response)   
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
      damageResistence:[[],Validators.required],
      damageImunity:[[],Validators.required],
      languages:[[],Validators.required]
    });
    this.featuresFormGroup = this._formBuilder.group({
      features: this._formBuilder.array([  ])
    });
    this.features = this.featuresFormGroup.get('features') as FormArray;
  }
  public onSubmit(){
    console.log(this.mapFormToDTO());
    this.monsterService.createMonster(this.mapFormToDTO()).subscribe(
      response => (console.log(response))   
    )
  }
  private mapFormToDTO(): MonsterCreate {
    return {
      raceName: this.informacoesFormGroup.controls['profilePicture'].value,
      raceDescription: this.informacoesFormGroup.controls['description'].value,
      imagePath: this.informacoesFormGroup.controls['profilePicture'].value,
      level: this.habilitiesFormGroup.controls['level'].value,
      damageImunity: this.habilitiesFormGroup.controls['damageImunity'].value,
      damageResistence: this.habilitiesFormGroup.controls['damageResistence'].value,
      langauges: this.habilitiesFormGroup.controls['languages'].value,
      features: this.featuresFormGroup.controls['features'].value
    } as MonsterCreate;
  }
  changeLanguages(elements: KeyValue[]){
    this.habilitiesFormGroup.controls['languages'].setValue(elements);
  }
  changeDamageImunities(elements: KeyValue[]){
    this.habilitiesFormGroup.controls['damageImunity'].setValue(elements);
  }
  changeDamageResistences(elements: KeyValue[]){
    this.habilitiesFormGroup.controls['damageResistence'].setValue(elements);
  }
  addFeature(){
    this.features.push(this.createNameDescriptionItem());
  }
  removeFeature(index) {
    this.features.removeAt(index);
  }
  createNameDescriptionItem(): FormGroup {
    return this._formBuilder.group({
      name: ['',Validators.required],
      description: ['',Validators.required],
    });
  }

}
