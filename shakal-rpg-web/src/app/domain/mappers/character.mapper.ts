import { FormGroup } from '@angular/forms';
import { CharacterCreate } from '../models/character/character.create';
import { CharacterSheet } from '../models/character/character.sheet';


 function mapFormToDTO(raceFormGroup: FormGroup,classFormGroup: FormGroup,
    generalInformationFormGroup : FormGroup,atributeFormGroup: FormGroup): CharacterCreate {
    return {
        race:raceFormGroup.controls['race'].value,
        

        classs:classFormGroup.controls['class'].value,

        alignment: generalInformationFormGroup.controls['alignment'].value,
        name:generalInformationFormGroup.controls['name'].value,
        imagePath: generalInformationFormGroup.controls['profilePicture'].value,
        tokenImageRaw: generalInformationFormGroup.controls['tokenImage'].value,

        strength: Number(atributeFormGroup.controls['strength'].value),
        dexterity: Number(atributeFormGroup.controls['dexterity'].value),
        constitution: Number(atributeFormGroup.controls['constitution'].value),
        inteligence: Number(atributeFormGroup.controls['inteligence'].value),
        wisdom: Number(atributeFormGroup.controls['wisdom'].value),
        charisma:Number(atributeFormGroup.controls['charisma'].value),

        publicBackground:'',
        secretBackground:'',
        height: 180,
        weight:120
    } as CharacterCreate;
  }

  
 function initializeCharacterSheet(): CharacterSheet {
    return {
        id: 0,
        userId: 0,
    
        name: "",
        background: "",
    
        classLevels:[],
        race: {},
        alignment: {},
        experiencyPoints: 0,
        player: {},
    
        proeficiencBonus: 0,
        
        age: 0,
        height: 0,
        weight: 0,
        imagePath: "",
        
        lifePoints:{
          totalLifePoints: 0,
          currentLifePoints: 0,
          hitDice: ""
        }
    } as CharacterSheet;
  }
  export  {mapFormToDTO,initializeCharacterSheet}