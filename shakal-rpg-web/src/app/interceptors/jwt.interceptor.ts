import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../pages/auth.service';
import { SpinnerService } from '../infra/services/spinner.service';
import { finalize } from "rxjs/operators";

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private authenticationService: AuthService,
        public loaderService: SpinnerService) {}
    
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        
        this.loaderService.show();
        var  token = JSON.parse(localStorage.getItem('currentUser')) ? JSON.parse(localStorage.getItem('currentUser'))['token'] : ""; 
        request = request.clone({
            setHeaders: { 
                 Authorization: token
             }
        });
        return next.handle(request).pipe(
            finalize(() => this.loaderService.hide()));
    }
}