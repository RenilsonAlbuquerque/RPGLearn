import { MonsterCreate } from '../models/monster/monster.create'
import { FormGroup } from '@angular/forms';

export default function mapFormToDTO(informacoesFormGroup: FormGroup,habilitiesFormGroup : FormGroup,
    featuresFormGroup: FormGroup, actionsFormGroup: FormGroup): MonsterCreate {
    return {
      raceName: informacoesFormGroup.controls['name'].value,
      raceDescription: informacoesFormGroup.controls['description'].value,
      imagePath: informacoesFormGroup.controls['profilePicture'].value,
      size: informacoesFormGroup.controls['size'].value,
      alignment: informacoesFormGroup.controls['alignment'].value,
      type: informacoesFormGroup.controls['type'].value,
      armorClass:Number(habilitiesFormGroup.controls['armorClass'].value),
      lifePoints:Number(habilitiesFormGroup.controls['lifePoints'].value),
      speed: Number(habilitiesFormGroup.controls['moviment'].value),
      force:Number(habilitiesFormGroup.get('force').value),
      proeficientForce : habilitiesFormGroup.controls['proeficientForce'].value,
      dexterity:Number(habilitiesFormGroup.controls['dexterity'].value),
      proeficientDexterity : habilitiesFormGroup.controls['proeficientDexterity'].value,
      constitution:Number(habilitiesFormGroup.controls['constitution'].value),
      proeficientConstitution: habilitiesFormGroup.controls['proeficientConstitution'].value,
      inteligence: Number(habilitiesFormGroup.controls['inteligence'].value),
      proeficientInteligence: habilitiesFormGroup.controls['proeficientInteligence'].value,
      wisdom:Number(habilitiesFormGroup.controls['wisdom'].value),
      proeficientWisdom: habilitiesFormGroup.controls['proeficientWisdom'].value,
      charisma: Number(habilitiesFormGroup.controls['charisma'].value),
      proeficientCharisma: habilitiesFormGroup.controls['proeficientCharisma'].value,
      level: habilitiesFormGroup.controls['level'].value,
      damageImunity: habilitiesFormGroup.controls['damageImunity'].value,
      damageResistence: habilitiesFormGroup.controls['damageResistence'].value,
      languages: habilitiesFormGroup.controls['languages'].value,
      features: featuresFormGroup.controls['features'].value,
      actions: actionsFormGroup.controls['actions'].value
    } as MonsterCreate;
  }