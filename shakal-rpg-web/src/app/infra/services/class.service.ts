import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClassCreateInput } from 'src/app/domain/models/class/class.create.input';
import { environment } from 'src/environments/environment';
import  {BASE_URL} from '../config/constants';


@Injectable()
export class ClassService {

    constructor(private httpClient: HttpClient) {
    }

    getClassDetail(id): Observable<ClassCreateInput>{
        return this.httpClient.get<ClassCreateInput>(`${BASE_URL}class/info/${id}`);
    }
}