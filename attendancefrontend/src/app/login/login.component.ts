import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from './authbasicservice/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginForm!:FormGroup;
  message: any;

  constructor(private fb:FormBuilder,  private authService:AuthService)
  {}

  ngOnInit()
  {

    this.loginForm=this.fb.group({
      email: [null, [Validators.required]],
      password: [null, [Validators.required]],
    })
  }

  submitForm()
  {
this.authService.loginUser(this.loginForm.value).subscribe(res=>{

console.log(res);
}, error=>{
  this.message.error('Erreur de coordonnées')
})
  }

}
