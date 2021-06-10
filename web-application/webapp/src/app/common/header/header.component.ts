import { Component, ViewChild, OnInit } from '@angular/core';
import {MatSidenav} from '@angular/material/sidenav';
import { LoginserviceService } from 'src/app/loginservice.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  @ViewChild('sidenav') sidenav: MatSidenav;

  constructor( public service : LoginserviceService) { }


  close() {
    
    this.sidenav.close();
  }

  ngOnInit():void{
 
  }



}
