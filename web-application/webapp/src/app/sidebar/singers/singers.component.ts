import { Component, OnInit } from '@angular/core';
import singers from '/src/app/files/singers.json'

@Component({
  selector: 'app-singers',
  templateUrl: './singers.component.html',
  styleUrls: ['./singers.component.scss']
})
export class SingersComponent implements OnInit {

  SingerList:any;

  constructor() {
    this.SingerList = singers
   }

   applyFilter(filterValue: Event) {
    this.SingerList.singers.filter=((<HTMLInputElement>filterValue.target).value).toLowerCase().trim();
  }


  ngOnInit(): void {
  }

}
