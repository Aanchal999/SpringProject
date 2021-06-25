import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { FormGroup, NgForm } from '@angular/forms';
import { Registermodel } from 'src/app/model/registermodel';
import { RegisterService } from 'src/app/Service/register.service';
import { ThemeService } from 'ng2-charts';


@Component({
  selector: 'app-userregister',
  templateUrl: './userregister.component.html',
  styleUrls: ['./userregister.component.scss']
})
export class UserregisterComponent implements OnInit {

  user: any = {};
  signup: any;
  serviceError: string;
  isServiceError: boolean;


  constructor(public service: RegisterService, private route:Router) {
    this.signup = {};
    this.isServiceError = false;
  }
  emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$";

  ngOnInit(): void {
  }

  register() {
    this.service.register(this.signup).subscribe((item: any) => {
      console.log(item);
      this.isServiceError = false;
      this.route.navigate(['/login']);
    }, (error: any) => {
      this.isServiceError = true;
      this.serviceError = error.error.message;
    });
  }

}
