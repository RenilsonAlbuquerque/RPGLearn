import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { PlaceOverview } from 'src/app/domain/models/place/place.overview';
import { environment } from 'src/environments/environment';
import { PlaceCreate } from 'src/app/domain/models/story/place-create';
import { PlaceDetail } from 'src/app/domain/models/story/place-detail';

@Injectable()
export class PlaceService {

    constructor(private httpClient: HttpClient) {
        
    }
    getDetail(placeId): Observable<PlaceDetail>{
        return this.httpClient.get<PlaceDetail>(`${environment.BASE_URL}place/info/${placeId}`);
    }
    getOverview(storyId): Observable<PlaceOverview[]>{
        return this.httpClient.get<PlaceOverview[]>(`${environment.BASE_URL}place/list/${storyId}`);
    }
    createPlace(place: PlaceCreate): Observable<PlaceOverview>{
        return this.httpClient.post<PlaceOverview>(`${environment.BASE_URL}place/create`,place);
    }
}