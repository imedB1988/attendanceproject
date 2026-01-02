import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginForm!:FormGroup;

  constructor(private fb:FormBuilder)
  {}

  ngOnInit()
  {
    
    this.loginForm=this.fb.group({
      email: [null, [Validators.required]],
      password: [null, [Validators.required]],
    })
  }

}
