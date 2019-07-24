import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators, FormArray} from '@angular/forms';
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
      response => (this.inputValues = response, console.log(response))   
    )
    //this.inputValues.alignments[0].id
    //this.inputValues.sizes[0].id
    this.informacoesFormGroup = this._formBuilder.group({
      alignment:[{},Validators.required],
      size:[{}, Validators.required],
      type:[{}, Validators.required],
      profilePicture: [''],
      name: ['',Validators.required],
      description: ['',Validators.required]
    });
    this.habilitiesFormGroup = this._formBuilder.group({
      armorClass: ['', Validators.required],
      lifePoints: ['', Validators.required],
      moviment: ['', Validators.required],
      force: [0, Validators.required],
      proeficientForce: [false],
      dexterity: [0, Validators.required],
      proeficientDexterity: [false],
      constitution: [0, Validators.required],
      proeficientConstitution: [false],
      inteligence: [0, Validators.required],
      proeficientInteligence: [false],
      wisdom: [0, Validators.required],
      proeficientWisdom: [false],
      charisma: [0, Validators.required],
      proeficientCharisma: [false],
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
      raceName: this.informacoesFormGroup.controls['name'].value,
      raceDescription: this.informacoesFormGroup.controls['description'].value,
      imagePath: this.informacoesFormGroup.controls['profilePicture'].value,
      size: this.informacoesFormGroup.controls['size'].value,
      alignment: this.informacoesFormGroup.controls['alignment'].value,
      type: this.informacoesFormGroup.controls['type'].value,
      armorClass:Number(this.habilitiesFormGroup.controls['armorClass'].value),
      lifePoints:Number(this.habilitiesFormGroup.controls['lifePoints'].value),
      force:Number(this.habilitiesFormGroup.get('force').value),
      proeficientForce : this.habilitiesFormGroup.controls['proeficientForce'].value,
      dexterity:Number(this.habilitiesFormGroup.controls['dexterity'].value),
      proeficientDexterity : this.habilitiesFormGroup.controls['proeficientDexterity'].value,
      constitution:Number(this.habilitiesFormGroup.controls['constitution'].value),
      proeficientConstitution: this.habilitiesFormGroup.controls['proeficientConstitution'].value,
      inteligence: Number(this.habilitiesFormGroup.controls['inteligence'].value),
      proeficientInteligence: this.habilitiesFormGroup.controls['proeficientInteligence'].value,
      wisdom:Number(this.habilitiesFormGroup.controls['wisdom'].value),
      proeficientWisdom: this.habilitiesFormGroup.controls['proeficientWisdom'].value,
      charisma: Number(this.habilitiesFormGroup.controls['charisma'].value),
      proeficientCharisma: this.habilitiesFormGroup.controls['proeficientCharisma'].value,
      level: this.habilitiesFormGroup.controls['level'].value,
      damageImunity: this.habilitiesFormGroup.controls['damageImunity'].value,
      damageResistence: this.habilitiesFormGroup.controls['damageResistence'].value,
      languages: this.habilitiesFormGroup.controls['languages'].value,
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
