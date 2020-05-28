import { BrowserModule, HammerGestureConfig, HAMMER_GESTURE_CONFIG } from '@angular/platform-browser';
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
import { CanActivateRouteGuard } from './interceptors/can.activate';
import { RegisterPlayerComponent } from './pages/register-player/register-player.component';
import { UserService } from './modules/user/user.module.service';
import { SpinnerService } from './infra/services/spinner.service';


import { FontAwesomeModule} from '@fortawesome/angular-fontawesome';
import { DirectivesModule } from './modules/generalmodules/directives.module';
import { ServiceWorkerModule } from '@angular/service-worker';
import { environment } from '../environments/environment';


export class HammerConfig extends HammerGestureConfig {
  overrides = <any> {
      'pinch': { enable: false },
      'rotate': { enable: false }
  }
}


@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
    RegisterPlayerComponent
  ],
  imports: [
    DirectivesModule,
    LayoutModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgbModule,
    MaterialModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    FontAwesomeModule,
    ToastrModule.forRoot(),
    ServiceWorkerModule.register('ngsw-worker.js', { enabled: environment.production })
    
  ],
  providers: [
    AuthService,
    CanActivateRouteGuard,
    UserService,
    SpinnerService,
    FontAwesomeModule,
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    {
      provide: HAMMER_GESTURE_CONFIG,
      useClass: HammerConfig
    }],
  bootstrap: [AppComponent]
})
export class AppModule { 
}
