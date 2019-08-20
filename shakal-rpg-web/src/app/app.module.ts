import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { LayoutModule } from './modules/layout/layout.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import { MaterialModule } from './modules/material-design/material.module';
import { AuthService } from './pages/auth.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { JwtInterceptor } from './interceptors/jwt.interceptor';
import { ErrorInterceptor } from './interceptors/error.interceptor';


@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent
  ],
  imports: [
    LayoutModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    MaterialModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    ToastrModule.forRoot()
    
  ],
  providers: [
    AuthService,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },],
  bootstrap: [AppComponent]
})
export class AppModule { }
