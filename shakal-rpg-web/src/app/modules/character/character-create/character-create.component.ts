import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CharacterService } from '../character.module.service';
import { CharacterCreateInput } from 'src/app/domain/models/character/character.create.input';
import { CharacterCreate } from 'src/app/domain/models/character/character.create';
import mapFormToDTO from 'src/app/domain/mappers/character.mapper';
import { ToastrService } from 'ngx-toastr';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from 'src/app/pages/auth.service';

@Component({
  selector: 'app-character-create',
  templateUrl: './character-create.component.html',
  styleUrls: ['./character-create.component.scss']
})
export class CharacterCreateComponent implements OnInit {

  public inputValues: CharacterCreateInput;

  public generalInformationFormGroup: FormGroup;
  public raceAndClassFormGroup: FormGroup;
  private storyId: number;
  
  profilePicture: string;
  constructor(private _formBuilder: FormBuilder,private characterService: CharacterService,
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
  }
  public onSubmit(){
    var monsterDTO: CharacterCreate = mapFormToDTO(this.raceAndClassFormGroup,this.generalInformationFormGroup);
    monsterDTO.userId = this.authService.getCurrentUser().id;
    monsterDTO.storyId = this.storyId;
    this.characterService.createCharacterOfPlayerInStory(monsterDTO).subscribe(
      response => (this.toastr.success("Monstro cadastrado com sucesso"),
                  this.router.navigate(['home/story/datail-player/' + this.storyId])),
      error => (this.toastr.error(error)) 
    )
  }

}
