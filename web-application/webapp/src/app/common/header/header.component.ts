import { Component, ViewChild, OnInit } from '@angular/core';
import {MatSidenav} from '@angular/material/sidenav';
import { Router } from '@angular/router';
import { LoginserviceService } from 'src/app/loginservice.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  @ViewChild('sidenav') sidenav: MatSidenav;

  constructor( public service : LoginserviceService, public route: Router) { }


  close() {
    
    this.sidenav.close();
  }

  ngOnInit():void{
 
  }
  logout(){
    console.log("logout");
    localStorage.removeItem('email');
    localStorage.removeItem('id');
    localStorage.removeItem('roles');
    localStorage.removeItem('token');
    localStorage.removeItem('username');
    this.route.navigate(['/login'])
  }


}
