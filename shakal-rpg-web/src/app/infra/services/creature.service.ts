import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CreatureToken } from 'src/app/domain/models/creature/creature.token';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';


@Injectable()
export class CreatureService {

    constructor(private httpClient: HttpClient) {
    }

    getCreatureTokenById(id): Observable<CreatureToken>{
        return this.httpClient.get<CreatureToken>(`${environment.BASE_URL}creature/token/${id}`);
    }
}