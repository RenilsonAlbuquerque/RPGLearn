import { PlaceDetail } from './place-detail';

export interface StoryDetail{
    id: number,
    name: String,
    background: String,
    folderImage: string,
    places: PlaceDetail[]
}