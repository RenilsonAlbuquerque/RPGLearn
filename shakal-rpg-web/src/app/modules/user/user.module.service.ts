import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserCreate } from 'src/app/domain/models/user/user.create';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import  {BASE_URL} from '../../infra/config/constants';
import { UserManagement } from 'src/app/domain/models/user/user.management.input';

@Injectable()
export class UserService {

    constructor(private httpClient: HttpClient) {
    }

    createUser(data : UserCreate): Observable<UserCreate>{
        return this.httpClient.post<UserCreate>(`${BASE_URL}user`, data);
    }
    getUserManagementMetadata(storyId: number): Observable<UserManagement>{
        return this.httpClient.get<UserManagement>(`${BASE_URL}user/manage-story/metadata/${storyId}`);
    }
}