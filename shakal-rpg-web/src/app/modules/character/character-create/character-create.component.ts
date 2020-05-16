import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormArray, ValidatorFn, FormControl } from '@angular/forms';
import { CharacterService } from '../character.module.service';
import { CharacterCreateInput } from 'src/app/domain/models/character/character.create.input';
import { CharacterCreate } from 'src/app/domain/models/character/character.create';

import { ToastrService } from 'ngx-toastr';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/pages/auth.service';
import { RaceCreateInput } from 'src/app/domain/models/race/race.create.input';
import { RaceService } from 'src/app/infra/services/race.service';
import { KeyValue } from 'src/app/domain/models/comon/key.value';
import { ClassCreateInput } from 'src/app/domain/models/class/class.create.input';
import { ClassService } from 'src/app/infra/services/class.service';
import { mapFormToDTO } from 'src/app/domain/mappers/character.mapper';
import { convertFileToBase64 } from 'src/app/infra/helpers/file.helper';
import { getDefaultBarbarianToken } from 'src/app/infra/helpers/character.helper';


@Component({
  selector: 'app-character-create',
  templateUrl: './character-create.component.html',
  styleUrls: ['./character-create.component.scss']
})
export class CharacterCreateComponent implements OnInit {
  fullProeficiency: boolean = false;
  public classDetailInput:ClassCreateInput;

  public raceDetailInput: RaceCreateInput;
  public subRaceOptions: KeyValue[] = [];
  public inputValues: CharacterCreateInput;

  public generalInformationFormGroup: FormGroup;
  public raceAndClassFormGroup: FormGroup;
  public classFormGroup: FormGroup;
  public atributeFormGroup: FormGroup;
  private storyId: number;
  
  profilePicture: string;
  tokenImage: string = getDefaultBarbarianToken();
  constructor(private _formBuilder: FormBuilder,private characterService: CharacterService,
    private raceService:RaceService, private classService: ClassService,
    private toastr: ToastrService,private router: Router,private _activatedRoute: ActivatedRoute,
    private authService: AuthService) {
      this._activatedRoute.params.subscribe(params => {
        this.storyId = params['id'];
      });
   }

  ngOnInit() {
    this.characterService.getCharacterCreationMetadata().subscribe(
      response => (this.inputValues = response)   
    );
    this.raceAndClassFormGroup = this._formBuilder.group({
      race:[{}, Validators.required],
      subRace:[{},Validators.required],
    });
    this.classFormGroup = this._formBuilder.group({
      class:[{}, Validators.required],
      proeficiencies: new FormArray([]),
      proeficiencies2:this._formBuilder.array([  ])
      //proeficiencies: new FormArray([],this.maxSelectedCheckboxes(1)),
    });
    this.generalInformationFormGroup = this._formBuilder.group({
      alignment:[{},Validators.required],
      profilePicture: [''],
      tokenImage:[''],
      name: ['',Validators.required],
      age: [''],
      height:[''],
      widith:[''],
      description: ['',Validators.required]
    });
    this.atributeFormGroup = this._formBuilder.group({
      strength: [, Validators.required],
      dexterity: [, Validators.required],
      constitution: [, Validators.required],
      inteligence:[, Validators.required],
      wisdom:[, Validators.required],
      charisma: [, Validators.required]
    });
    this.raceAndClassFormGroup.get('race').valueChanges.subscribe(race =>{
      this.onChageRace(race);
    });
    this.raceAndClassFormGroup.get('subRace').valueChanges.subscribe(subRace =>{
      this.onChageSubRace(subRace);
    });
    this.classFormGroup.get('class').valueChanges.subscribe(classId =>{
      this.onChageClass(classId);
    });
    this.initializeDefaultValues();
  }
  onChageRace(raceId: number){
    if(this.inputValues && this.inputValues.races){
      this.inputValues.races.map(race => {
        if(race.id === raceId){
          this.subRaceOptions = race.subRaces;
        }
      });  
    }
    this.raceService.getRaceDetail(raceId).subscribe(
      raceDetail =>{
        this.raceDetailInput = raceDetail;
      }
    )
  }
  onChageSubRace(subRaceId: number){
    this.raceService.getSubRaceDetail(subRaceId).subscribe(
      subRaceDetail =>{
        this.raceDetailInput = subRaceDetail;
      }
    )
  }
  onChageClass(classId: number){
    this.classService.getClassDetail(classId).subscribe(
      classDetail => {
        this.classDetailInput = classDetail;
        this.addCheckboxes();
      }
    )
  }
  onChangeProeficiencies(event,proeficiency){
    const checkArray: FormArray = this.classFormGroup.get('proeficiencies') as FormArray;
    let i: number = 0;
    checkArray.controls.forEach((item: FormControl) => {
      //checa se existe
      if (item.value.id === proeficiency.id) {
        //se existe e foi deschecado então remova
        if(!event.target.checked){
          (this.classFormGroup.get('proeficiencies') as FormArray).removeAt(i);
        }
        return;
      }
      i++;
    });
    if(event.target.checked){
      //se não existe e foi checado então adiciona
      (this.classFormGroup.get('proeficiencies') as FormArray).controls.push(
        new FormControl({id:proeficiency.id,ckeck:true}));
        if((this.classFormGroup.get('proeficiencies') as FormArray).controls.length >= this.classDetailInput.proeficiencyChoose.choose){
          this.fullProeficiency = true;
        }
    }
   
   
    console.log(this.classFormGroup.controls.proeficiencies);
  }
    
  printTest(e){
    console.log(e);
  }
  public onSubmit(){
    var characterDTO: CharacterCreate = mapFormToDTO(this.raceAndClassFormGroup,
      this.classFormGroup, this.generalInformationFormGroup,this.atributeFormGroup);
    characterDTO.userId = this.authService.getCurrentUser().id;
    characterDTO.storyId = this.storyId;
    this.characterService.createCharacterOfPlayerInStory(characterDTO).subscribe(
      response => (this.toastr.success("Ficha criada"),
                  this.router.navigate(['home/story/datail-player/' + this.storyId])),
      error => (this.toastr.error(error)) 
    )
  }

  maxSelectedCheckboxes(max: number = 1) {
    const validator: ValidatorFn = (formArray: FormArray) => {
      const totalSelected = formArray.controls
        // get a list of checkbox values (boolean)
        .map(control => control.value)
        // total up the number of checked checkboxes
        .reduce((prev, next) => next ? prev + next : prev, 0);
  
      // if the total is not greater than the minimum, return the error message
      return totalSelected <= max ? null : { required: true };
    };
  
    return validator;
  }
  private addCheckboxes() {
    console.log(this.classFormGroup)
    this.classDetailInput.proeficiencyChoose.proeficiencies.forEach((o, i) => {
       let control = this._formBuilder.group({
         id:o.id,name: o.value,ckeck: false
      });
      //let control = new FormControl({id:o.id,value: o.value,ckeck:true}); // if first item set to true, else false
      (this.classFormGroup.controls.proeficiencies2 as FormArray).push(control);
    });
    console.log(this.classFormGroup.controls.proeficiencies2)
  }
  private initializeDefaultValues(){
    //this.raceAndClassFormGroup.controls.race.setValue(1);
    //this.raceAndClassFormGroup.controls.subRace.setValue(1);
    //this.classFormGroup.controls.class.setValue(1);
    
  }
  async changeTokenImage(event:any){
    let file = event.target.files[0];
    await convertFileToBase64(file).then(
      result => {
        this.tokenImage = result as string,
        this.generalInformationFormGroup.controls['tokenImage'].setValue(result as string)
      }
    );
  }

}
