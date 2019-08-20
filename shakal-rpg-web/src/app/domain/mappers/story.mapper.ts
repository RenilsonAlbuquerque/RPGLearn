import { FormGroup, FormArray } from '@angular/forms';
import { StoryCreate } from '../models/story/story-create';
import { PlaceCreate } from '../models/story/place-create';

function mapStoryFormToDTO(detailFormGroup: FormGroup,playersFormGroup : FormGroup,
  placesFormGroup : FormGroup): StoryCreate {
    return {
      name: detailFormGroup.controls['name'].value,
      background: detailFormGroup.controls['description'].value,
      folderImage: detailFormGroup.controls['profilePicture'].value,
      places: mapPlaceFormToDto(placesFormGroup),
      users: playersFormGroup.controls['players'].value,
     
    } as StoryCreate;
}

function mapPlaceFormToDto(placesFormGroup : FormGroup): PlaceCreate[]{
    const result: PlaceCreate[] = [];
    const control: FormArray = <FormArray> placesFormGroup.get('places');
    for (let value of control.controls) {
      console.log(value)
      var place = {
        name: value.value['name'],
        background: value.value['description'],
        map: value.value['map']
      } as PlaceCreate;
      console.log(place)
      result.push(place)
    }
    return result;
}
export  {mapPlaceFormToDto,mapStoryFormToDTO};