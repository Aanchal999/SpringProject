import { AfterViewInit, Component, ViewChild, TemplateRef, OnInit,ViewContainerRef, Inject, EventEmitter, Output, Input } from '@angular/core';
import tracks from '/src/app/files/tracks.json'
import { MatPaginator } from '@angular/material/paginator';
import singers from '/src/app/files/singers.json'
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { SaveformComponent } from '../saveform/saveform.component';
import { DeletemodalComponent } from '../saveform/deletemodal/deletemodal.component';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements AfterViewInit {

  searchKey: string;
  p: number = 1;
TrackList:any;
SingerList:any;
  constructor(private dialog:MatDialog) {
    this.TrackList = tracks
    this.SingerList = singers
   }

   @ViewChild(MatPaginator) paginator:MatPaginator;



   ngAfterViewInit() {
     
     this.TrackList.paginator=this.paginator;
   }
 
onCreate(){
  const dialogconfig = new MatDialogConfig();
  dialogconfig.disableClose = false;
  dialogconfig.autoFocus = true;
  this.dialog.open(SaveformComponent,dialogconfig);
}

openModal(){
  const dialogconfig = new MatDialogConfig();
  dialogconfig.disableClose = false;
  dialogconfig.autoFocus = true;
  this.dialog.open(DeletemodalComponent,dialogconfig);
}



  applyFilter() {
    this.TrackList.tracks.filter=this.searchKey.toLowerCase().trim();
  }

  onSelect(selectedItem){
    console.log("Selected Id:", selectedItem.id);
  }

}
