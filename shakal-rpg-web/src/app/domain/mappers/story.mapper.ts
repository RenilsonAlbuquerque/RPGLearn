import { FormGroup } from '@angular/forms';
import { StoryCreate } from '../models/story/story-create';

export default function mapStoryFormToDTO(detailFormGroup: FormGroup,playersFormGroup : FormGroup): StoryCreate {
    return {
      name: detailFormGroup.controls['name'].value,
      background: detailFormGroup.controls['description'].value,
      folderImage: detailFormGroup.controls['profilePicture'].value,
      places: [],
      users: playersFormGroup.controls['players'].value,
     
    } as StoryCreate;
  }