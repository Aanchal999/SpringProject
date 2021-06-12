import { Component, OnInit } from '@angular/core';
import singers from '/src/app/files/singers.json';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddsingerComponent } from 'src/app/common/saveform/addsinger/addsinger.component';

@Component({
  selector: 'app-singers',
  templateUrl: './singers.component.html',
  styleUrls: ['./singers.component.scss']
})
export class SingersComponent implements OnInit {

  SingerList:any;

  constructor(private dialog:MatDialog) {
    this.SingerList = singers
   }

   applyFilter(filterValue: Event) {
    this.SingerList.singers.filter=((<HTMLInputElement>filterValue.target).value).toLowerCase().trim();
  }

   
onCreate(){
  const dialogconfig = new MatDialogConfig();
  dialogconfig.disableClose = false;
  dialogconfig.autoFocus = true;
  this.dialog.open(AddsingerComponent,dialogconfig);
}



  ngOnInit(): void {
  }

}
