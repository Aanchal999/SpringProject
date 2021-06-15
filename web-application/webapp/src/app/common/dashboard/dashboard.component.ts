import { AfterViewInit, Component, ViewChild, TemplateRef, OnInit,ViewContainerRef, Inject, EventEmitter, Output, Input } from '@angular/core';
import tracks from '/src/app/files/tracks.json'
import { MatPaginator } from '@angular/material/paginator';
import singers from '/src/app/files/singers.json'
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { SaveformComponent } from '../saveform/saveform.component';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements AfterViewInit {


TrackList:any;
SingerList:any;
  constructor(private dialog:MatDialog) {
    this.TrackList = tracks
    this.SingerList = singers
   }

   @ViewChild(MatPaginator) paginator:MatPaginator;


   @Input() selected: boolean;
   @Output() selectedChange = new EventEmitter<boolean>();
 

 
 
 
   public toggleSelected() {
     this.selected = !this.selected;
     this.selectedChange.emit(this.selected);
   }


   ngAfterViewInit() {
     
     this.TrackList.paginator=this.paginator;
   }
 
onCreate(){
  const dialogconfig = new MatDialogConfig();
  dialogconfig.disableClose = false;
  dialogconfig.autoFocus = true;
  this.dialog.open(SaveformComponent,dialogconfig);
}



  applyFilter(filterValue: Event) {
    this.TrackList.filter=((<HTMLInputElement>filterValue.target).value).toLowerCase().trim();
  }

}
