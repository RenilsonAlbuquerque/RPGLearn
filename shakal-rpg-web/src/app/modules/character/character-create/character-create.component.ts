import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { CharacterService } from '../character.module.service';
import { CharacterCreateInput } from 'src/app/domain/models/character/character.create.input';

@Component({
  selector: 'app-character-create',
  templateUrl: './character-create.component.html',
  styleUrls: ['./character-create.component.scss']
})
export class CharacterCreateComponent implements OnInit {

  public inputValues: CharacterCreateInput;
  public informacoesFormGroup: FormGroup;
  
  constructor(private _formBuilder: FormBuilder,private characterService: CharacterService) {
   
   }

  ngOnInit() {
    this.characterService.getCharacterCreationMetadata().subscribe(
      response => (this.inputValues = response)   
    );
    this.informacoesFormGroup = this._formBuilder.group({
      alignment:[{},Validators.required],
      race:[{}, Validators.required],
      class:[{}, Validators.required],
      profilePicture: [''],
      name: ['',Validators.required],
      description: ['',Validators.required]
    });
  }

}
