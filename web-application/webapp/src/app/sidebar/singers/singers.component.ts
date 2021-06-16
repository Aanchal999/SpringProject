import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import singers from '/src/app/files/singers.json';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddsingerComponent } from 'src/app/common/saveform/addsinger/addsinger.component';
import { DeletemodalComponent } from 'src/app/common/saveform/deletemodal/deletemodal.component';

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



   @Input() selected: boolean;
   @Output() selectedChange = new EventEmitter<boolean>();
 

 
   ngOnInit() {
   }
 
   public toggleSelected() {
     this.selected = !this.selected;
     this.selectedChange.emit(this.selected);
   }

   applyFilter(filterValue: Event) {
    this.SingerList.filter=((<HTMLInputElement>filterValue.target).value).toLowerCase().trim();
  }

   
onCreate(){
  const dialogconfig = new MatDialogConfig();
  dialogconfig.disableClose = false;
  dialogconfig.autoFocus = true;
  this.dialog.open(AddsingerComponent,dialogconfig);
}

openModal(){
  const dialogconfig = new MatDialogConfig();
  dialogconfig.disableClose = false;
  dialogconfig.autoFocus = true;
  this.dialog.open(DeletemodalComponent,dialogconfig);
}


}
