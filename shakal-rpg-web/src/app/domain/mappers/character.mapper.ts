import { FormGroup } from '@angular/forms';
import { CharacterCreate } from '../models/character/character.create';


export default function mapFormToDTO(raceAndClassFormGroup: FormGroup,generalInformationFormGroup : FormGroup): CharacterCreate {
    return {
        classs:raceAndClassFormGroup.controls['class'].value,
        race:raceAndClassFormGroup.controls['race'].value,
        alignment: raceAndClassFormGroup.controls['alignment'].value,
        name:generalInformationFormGroup.controls['name'].value,
        imagePath: generalInformationFormGroup.controls['profilePicture'].value,
        publicBackground:'',
        secretBackground:'',
        height: 180,
        weight:120
    } as CharacterCreate;
  }