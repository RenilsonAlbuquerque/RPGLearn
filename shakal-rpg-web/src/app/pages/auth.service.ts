import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from '../domain/models/auth/Login';
//import { environment } from 'src/environments/environment';
import { User } from '../domain/models/auth/User';
import { Router } from '@angular/router';
import {BASE_URL} from '../infra/config/constants';


@Injectable()
export class AuthService {

  
  
  constructor(private httpClient: HttpClient,private router: Router) {
  }

  performLogin(login: Login): Observable<User>{
    return this.httpClient.post<User>(`${BASE_URL}login`,login);
  }
  getCurrentUser(): User{
    return JSON.parse(localStorage.getItem('currentUser')) as User
  }
  logout() {
    // remove user from local storage to log user out
    localStorage.removeItem('currentUser');
    this.router.navigate(['/login'])
  }
  isUserAuthenticated(): boolean{
    if(localStorage.getItem('currentUser')!= null){
      return true;
    }
    else{
      return false;
    }
  }
  
}