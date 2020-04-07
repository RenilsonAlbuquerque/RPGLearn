import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { UserService } from 'src/app/modules/user/user.module.service';
import { UserCreate } from 'src/app/domain/models/user/user.create';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-player',
  templateUrl: './register-player.component.html',
  styleUrls: ['./register-player.component.scss']
})
export class RegisterPlayerComponent implements OnInit {

  registerForm: FormGroup;
  loading = false;
  submitted = false;
  constructor(private toastr: ToastrService,private formBuilder: FormBuilder, 
    private userService: UserService,private router: Router) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      username: ['', Validators.required],
      password: ['', Validators.required],
      confirmPassword: ['', Validators.required]
    });
  }
  onSubmit() {
    this.submitted = true;

    if (this.registerForm.invalid) {
        return;
    }
    let usr: string = this.registerForm.controls['username'].value;
    let pass: string = this.registerForm.controls['password'].value;
    let confPass: string = this.registerForm.controls['confirmPassword'].value; 
    if(pass != confPass){
      this.toastr.error("As senhas não conferem");
      return;
    }

    this.loading = true;
    var user = {
      username: usr,
      password: pass } as UserCreate;
    
      this.userService.createUser(user).subscribe(
        data =>{
          this.loading = false;
          this.toastr.error("Usuário cadastrado");
          this.router.navigate(['/login'])
        },
        err => {
          this.loading = false;
        },
      );
  }

}
