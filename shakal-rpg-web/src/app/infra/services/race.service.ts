import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { RaceCreateInput } from 'src/app/domain/models/race/race.create.input';
import  {BASE_URL} from '../config/constants';


@Injectable()
export class RaceService {

    constructor(private httpClient: HttpClient) {
    }

    getRaceDetail(id): Observable<RaceCreateInput>{
        return this.httpClient.get<RaceCreateInput>(`${BASE_URL}race/info/${id}`);
    }
    getSubRaceDetail(id): Observable<RaceCreateInput>{
        return this.httpClient.get<RaceCreateInput>(`${BASE_URL}race/subrace/info/${id}`);
    }
}