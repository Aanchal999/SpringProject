import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Login } from 'src/app/model/login';
import { LoginService } from 'src/app/Service/login.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.scss']
})
export class UserloginComponent implements OnInit {

  login: Login;

  constructor(public service: LoginService, private route: Router) {
    this.login = new Login();
  }

  msg: string = "";
  ngOnInit() {
  }

  userlogin() {
    this.service.userlogin(this.login).subscribe((item:any) => {
      console.log(item);
      localStorage.setItem('email',item.email);
      localStorage.setItem('id',item.id);
      localStorage.setItem('roles',item.roles);
      localStorage.setItem('token',item.token);
      localStorage.setItem('username',item.username);
      this.route.navigate(['/dashboard'])
    });
  }

}
