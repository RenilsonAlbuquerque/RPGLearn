import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Page } from 'src/app/infra/models/page';
import { MonsterOverview } from 'src/app/domain/models/monster.overview';
import { environment } from 'src/environments/environment';
import { MonsterInfo } from 'src/app/domain/models/monster/monster.info';
import { MonsterSheet } from 'src/app/domain/models/monster/monster.sheet';
import { MonsterCreateInput } from 'src/app/domain/models/monster/monster.create.input';
import { MonsterCreate } from 'src/app/domain/models/monster/monster.create';
import { CreatureCard } from 'src/app/domain/models/monster/creature.card';
import  {BASE_URL} from '../../infra/config/constants';


@Injectable()
export class MonsterService {

  
  
  constructor(private httpClient: HttpClient) {
  }

  getOverview(pageNumber): Observable<Page<MonsterOverview>>{
    return this.httpClient.post<Page<MonsterOverview>>(`${BASE_URL}monster/list`,{page:pageNumber, size:9});
  }
  getSearchResult(searchString: String, pageNumber): Observable<Page<MonsterOverview>>{
    return this.httpClient.post<Page<MonsterOverview>>(`${BASE_URL}monster/filter?name=${searchString}`,{page:pageNumber, size:9});
  }
  getMonsterInfoById(id): Observable<MonsterInfo>{
    return this.httpClient.get<MonsterInfo>(`${BASE_URL}monster/info/${id}`);
  }
  getMonsterSheetById(id): Observable<MonsterSheet>{
    return this.httpClient.get<MonsterSheet>(`${BASE_URL}monster/sheet/${id}`);
  }
  getMonsterCardById(id): Observable<CreatureCard>{
    return this.httpClient.get<CreatureCard>(`${BASE_URL}monster/card/${id}`);
  }
  getMonsterCreateInput(): Observable<MonsterCreateInput>{
    return this.httpClient.get<MonsterCreateInput>(`${BASE_URL}monster/input`);
  }
  createMonster(data : MonsterCreate): Observable<MonsterCreate>{
    return this.httpClient.post<MonsterCreate>(`${BASE_URL}monster`, data);
  }
}