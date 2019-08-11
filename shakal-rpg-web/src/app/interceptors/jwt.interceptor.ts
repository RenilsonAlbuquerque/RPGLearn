import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        request = request.clone({
            setHeaders: { 
                 Authorization: `Barer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZW5pbHNvbiIsImlkIjoxLCJyb2xlcyI6W10sImlhdCI6MTU1NTM4NDQxNSwiZXhwIjoxNTU1Mzg4MDE1fQ._8AzkwLNGsHvGBdmMnnXI8QXUiYLj44bzOiwzrmsjL4`
             }
        });
        return next.handle(request);
    }
}