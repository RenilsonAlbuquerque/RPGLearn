import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PlaceOverview } from 'src/app/domain/models/place/place.overview';
import { environment } from 'src/environments/environment';
import { PlaceCreate } from 'src/app/domain/models/story/place-create';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';
import { PlaceMarkCreate } from 'src/app/domain/models/place/place.mark.create';
import { PlaceMarkOverview } from 'src/app/domain/models/place/place.mak.overview';
import  {BASE_URL} from '../../infra/config/constants';

@Injectable()
export class PlaceService {

    constructor(private httpClient: HttpClient) {
        
    }
    getDetail(placeId): Observable<PlaceDetail>{
        return this.httpClient.get<PlaceDetail>(`${BASE_URL}place/info/${placeId}`);
    }
    getOverview(storyId): Observable<PlaceOverview[]>{
        return this.httpClient.get<PlaceOverview[]>(`${BASE_URL}place/list/${storyId}`);
    }
    createPlace(place: PlaceCreate): Observable<PlaceOverview>{
        return this.httpClient.post<PlaceOverview>(`${BASE_URL}place/create`,place);
    }
    createPlaceMark(placeMark: PlaceMarkCreate): Observable<PlaceMarkCreate>{
        return this.httpClient.post<PlaceMarkCreate>(`${BASE_URL}place/create/mark`,placeMark);
    }
    getPlaceMarkOverviews(placeId): Observable<PlaceMarkOverview[]>{
        return this.httpClient.get<PlaceMarkOverview[]>(`${BASE_URL}place/list/marks/${placeId}`);
    }
}