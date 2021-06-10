import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { FormGroup, NgForm } from '@angular/forms';


@Component({
  selector: 'app-userregister',
  templateUrl: './userregister.component.html',
  styleUrls: ['./userregister.component.scss']
})
export class UserregisterComponent implements OnInit {

  user:any={};

   constructor() { }
   emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"; 
   signup:any={};
   cities!: Array<any>;
   stateList:Array<any>=[
   {name:'Uttar Pradesh',cities:['Select City','Noida','Lucknow','Varanasi']},
   {name:'Rajasthan',cities:['Select City','Jaipur','Udaipur','Jodhpur']},
   {name:'Himachal Pradesh',cities:['Select City','Shimla','Manali','Dalhousie']},
   {name:'Haryana',cities:['Select City','Gurugram','Rohtak','Faridabad']},                      
   ];
 
   changeCountry(count:Event)
   {
     this.cities=this.stateList.find(con=>con.name==(<HTMLInputElement>count.target).value).cities;
   }
 
 
   ngOnInit(): void {
   }
  

   
  
   
}
