import { FormGroup, FormArray } from "@angular/forms";
import { PlaceCreate } from '../models/story/place-create';

function mapPlaceInFormToDto(placesFormGroup : FormGroup): PlaceCreate{

    return {
        name: placesFormGroup.controls['name'].value,
        background: placesFormGroup.controls['background'].value,
        map: placesFormGroup.controls['map'].value,
        xDimension: placesFormGroup.controls['xDimension'].value,
        yDimension: placesFormGroup.controls['yDimension'].value,
        squareSize: placesFormGroup.controls['squareDimension'].value,
      } as PlaceCreate;
}
export  {mapPlaceInFormToDto};