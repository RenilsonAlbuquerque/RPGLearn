import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators, FormArray} from '@angular/forms';
import { MonsterCreate } from 'src/app/domain/models/monster/monster.create';
import { MonsterCreateInput } from 'src/app/domain/models/monster/monster.create.input';
import { MonsterService } from '../monster.module.service';
import { KeyValue } from 'src/app/domain/models/comon/key.value';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import mapFormToDTO from 'src/app/domain/mappers/monster.mapper';


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
  public actionsFormGroup: FormGroup;
  public legendaryActionsFormGroup: FormGroup;
  

  //Items of the component
  public features: FormArray;
  profilePicture: string;

  constructor(private _formBuilder: FormBuilder,private monsterService: MonsterService,
    private router: Router,private toastr: ToastrService) { }

  ngOnInit() {
    this.monsterService.getMonsterCreateInput().subscribe(
      response => (this.inputValues = response)   
    )
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
      force: [, Validators.required],
      proeficientForce: [false],
      dexterity: [, Validators.required],
      proeficientDexterity: [false],
      constitution: [, Validators.required],
      proeficientConstitution: [false],
      inteligence: [, Validators.required],
      proeficientInteligence: [false],
      wisdom: [, Validators.required],
      proeficientWisdom: [false],
      charisma: [, Validators.required],
      proeficientCharisma: [false],
      level:[{}, Validators.required],
      damageResistence:[[]],
      damageImunity:[[]],
      languages:[[],Validators.required]
    });
    this.featuresFormGroup = this._formBuilder.group({
      features: this._formBuilder.array([  ])
    });
    this.actionsFormGroup = this._formBuilder.group({
      actions: this._formBuilder.array([  ])
    });
    this.legendaryActionsFormGroup = this._formBuilder.group({
      legendaryActions: this._formBuilder.array([  ])
    });
    this.features = this.featuresFormGroup.get('features') as FormArray;
    this.initializeDefaultValues();
  }
  public onSubmit(){
    var monsterDTO: MonsterCreate = mapFormToDTO(this.informacoesFormGroup,this.habilitiesFormGroup,
    this.featuresFormGroup, this.actionsFormGroup, this.legendaryActionsFormGroup)
    console.log(monsterDTO)
    this.monsterService.createMonster(monsterDTO).subscribe(
      response => (this.toastr.success("Monstro cadastrado com sucesso"),
                  this.router.navigate(['home/monster/all'])),
      error => (this.toastr.error(error)) 
    )
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
  removeFeature(index: number) {
    this.features.removeAt(index);
  }
  addAction() {
    const control = <FormArray>this.actionsFormGroup.get('actions');
    control.push(this.createActionItem());
  }
  addLegendaryAction() {
    const control = <FormArray>this.legendaryActionsFormGroup.get('legendaryActions');
    control.push(this.createActionItem());
  }
  removeAction(index: number) {
    const control = <FormArray>this.actionsFormGroup.get('actions');
    control.removeAt(index);
  }
  removeLegendaryAction(index: number) {
    const control = <FormArray>this.legendaryActionsFormGroup.get('legendaryActions');
    control.removeAt(index);
  }
  addActionDamge(formIndex){
    const control = (<FormArray> (<FormArray> this.actionsFormGroup.get('actions')).controls[formIndex].get('damages')).controls;
    control.push(this.createDamageItem());
  }
  addLegendaryActionDamge(formIndex){
    const control = (<FormArray> (<FormArray> this.legendaryActionsFormGroup.get('legendaryActions')).controls[formIndex].get('damages')).controls;
    control.push(this.createDamageItem());
  }
  removeActionDamge(formIndex,damageIndex){
    const control = (<FormArray> (<FormArray> this.actionsFormGroup.get('actions')).controls[formIndex].get('damages'));
    control.removeAt(damageIndex);
  }
  removeLegendaryActionDamge(formIndex,damageIndex){
    const control = (<FormArray> (<FormArray> this.legendaryActionsFormGroup.get('legendaryActions')).controls[formIndex].get('damages'));
    control.removeAt(damageIndex);
  }
  createNameDescriptionItem(): FormGroup {
    return this._formBuilder.group({
      name: ['',Validators.required],
      description: ['',Validators.required],
    });
  }
  createActionItem(): FormGroup {
    
    return this._formBuilder.group({
      name: ['',Validators.required],
      description: ['',Validators.required],
      damages:this._formBuilder.array([ 
        this.createDamageItem()
       ])
    });
  }
  createDamageItem(): FormGroup {
    return this._formBuilder.group({
      quantity: ['',Validators.required],
      dice: [{},Validators.required],
      damageType: [{},Validators.required],
    });
  }
  initializeDefaultValues(){
    this.informacoesFormGroup.controls['profilePicture'].setValue('../../../../assets/img/default-monster.jpg');
    this.profilePicture = '../../../../assets/img/default-monster.jpg';
  }

}
