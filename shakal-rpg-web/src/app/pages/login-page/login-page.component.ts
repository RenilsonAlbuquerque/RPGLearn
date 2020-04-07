import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Login } from 'src/app/domain/models/auth/Login';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { User } from 'src/app/domain/models/auth/User';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.scss']
})
export class LoginPageComponent implements OnInit {
  loginForm: FormGroup;
  loading = false;
  submitted = false;

  constructor(private authService: AuthService,private formBuilder: FormBuilder
    ,private router: Router,private toastr: ToastrService) { }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

  }
  onSubmit() {
    this.submitted = true;

    if (this.loginForm.invalid) {
        return;
    }

    this.loading = true;
    var user = {
      username: this.loginForm.controls['username'].value,
      password: this.loginForm.controls['password'].value } as Login;
    
    this.authService.performLogin(user)
        .pipe(first())
        .subscribe(
            data => {
                localStorage.setItem('currentUser', JSON.stringify(data));
                this.router.navigate(['/home']);
                
            },
            error => {
                this.loading = false;
            });
  }
  goRegister(){
    this.router.navigate(['/register']);
  }

}
