import { PlaceCreate } from './place-create';
import { KeyValue } from '../comon/key.value';

export interface StoryCreate{
    name: string,
    background: string,
    folderImage: string,
    places: PlaceCreate[],
    users: KeyValue[]
}