import { Component } from '@angular/core';
import { Router, RouterOutlet } from '@angular/router';
import { SharedModule } from './shared/shared.module';
import { UserStorageService } from './basic/basic-services/user-storage.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [SharedModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'attendancefrontend';

  isAdminLoggedIn:boolean = UserStorageService.isAdminLoggedIn();
  isEmployeeLoggedIn:boolean = UserStorageService.isEmployeeLoggedIn();
  isManagerLoggedIn:boolean = UserStorageService.isManagerLoggedIn();


  constructor(private router:Router){}

  ngOnInit(){
  this.router.events.subscribe(events=>{
  this.isAdminLoggedIn=UserStorageService.isAdminLoggedIn();
  this.isEmployeeLoggedIn=UserStorageService.isEmployeeLoggedIn();
  this.isManagerLoggedIn=UserStorageService.isManagerLoggedIn();
})
  }
}
