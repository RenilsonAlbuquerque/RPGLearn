import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CharacterService } from '../character.module.service';
import { CharacterCreateInput } from 'src/app/domain/models/character/character.create.input';
import { CharacterCreate } from 'src/app/domain/models/character/character.create';
import mapFormToDTO from 'src/app/domain/mappers/character.mapper';
import { ToastrService } from 'ngx-toastr';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/pages/auth.service';
import { RaceCreateInput } from 'src/app/domain/models/race/race.create.input';
import { RaceService } from 'src/app/infra/services/race.service';
import { KeyValue } from 'src/app/domain/models/comon/key.value';


@Component({
  selector: 'app-character-create',
  templateUrl: './character-create.component.html',
  styleUrls: ['./character-create.component.scss']
})
export class CharacterCreateComponent implements OnInit {

  public raceDetailInput: RaceCreateInput;
  public subRaceOptions: KeyValue[] = [];
  public inputValues: CharacterCreateInput;

  public generalInformationFormGroup: FormGroup;
  public raceAndClassFormGroup: FormGroup;
  public classFormGroup: FormGroup;
  private storyId: number;
  
  profilePicture: string;
  constructor(private _formBuilder: FormBuilder,private characterService: CharacterService,
    private raceService:RaceService,
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
      alignment:[{},Validators.required],
      race:[{}, Validators.required],
      subRace:[{},Validators.required],
      
    });
    this.classFormGroup = this._formBuilder.group({
      class:[{}, Validators.required]
    });
    this.generalInformationFormGroup = this._formBuilder.group({
      profilePicture: [''],
      name: ['',Validators.required],
      age: [''],
      height:[''],
      widith:[''],
      description: ['',Validators.required]
    });
    this.raceAndClassFormGroup.get('race').valueChanges.subscribe(race =>{
      this.onChageRace(race);
    })
    this.raceAndClassFormGroup.get('subRace').valueChanges.subscribe(subRace =>{
      this.onChageSubRace(subRace);
    })
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
        console.log(raceDetail)
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
    
  public onSubmit(){
    var monsterDTO: CharacterCreate = mapFormToDTO(this.raceAndClassFormGroup,this.generalInformationFormGroup);
    monsterDTO.userId = this.authService.getCurrentUser().id;
    monsterDTO.storyId = this.storyId;
    this.characterService.createCharacterOfPlayerInStory(monsterDTO).subscribe(
      response => (this.toastr.success("Ficha criada"),
                  this.router.navigate(['home/story/datail-player/' + this.storyId])),
      error => (this.toastr.error(error)) 
    )
  }

}
