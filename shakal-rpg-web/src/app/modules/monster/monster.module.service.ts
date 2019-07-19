import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Page } from 'src/app/infra/models/page';
import { MonsterOverview } from 'src/app/domain/models/monster.overview';
import { environment } from 'src/environments/environment';


@Injectable()
export class MonsterService {

  constructor(private httpClient: HttpClient) {
  }

  getOverview(pageNumber): Observable<Page<MonsterOverview>>{
    return this.httpClient.post<Page<MonsterOverview>>(`${environment.BASE_URL}monster`,{page:pageNumber, size:9});
  }
  getSearchResult(searchString: String, pageNumber): Observable<Page<MonsterOverview>>{
    return this.httpClient.post<Page<MonsterOverview>>(`${environment.BASE_URL}monster/filter?name=${searchString}`,{page:pageNumber, size:9});
  }
}