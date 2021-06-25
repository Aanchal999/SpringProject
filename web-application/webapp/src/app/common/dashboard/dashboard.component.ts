import { AfterViewInit, Component, ViewChild, TemplateRef, OnInit, ViewContainerRef, Inject, EventEmitter, Output, Input } from '@angular/core';
import tracks from '/src/app/files/tracks.json'
import { MatPaginator } from '@angular/material/paginator';
import singers from '/src/app/files/singers.json'
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { SaveformComponent } from '../saveform/saveform.component';
import { DeletemodalComponent } from '../saveform/deletemodal/deletemodal.component';
import { TrackService } from 'src/app/Service/track.service';
import { SingersComponent } from 'src/app/sidebar/singers/singers.component';
import { SingerService } from 'src/app/Service/singer-service.service';
import { IdName } from 'src/app/model/id-name';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  keyword: string;
  searchKey: string;
  p: number = 1;
  TrackList: any;
  SingerList: any;
  
  constructor(private dialog: MatDialog, public service: TrackService) {
    this.TrackList = [];
    
  }

  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngOnInit() {
    this.getTrack();
  }

  getTrack() {
    this.service.getTrack().subscribe((response) => {
      this.TrackList = response;
    });
  }

  onCreate(selectedItem) {
    // const dialogconfig = new MatDialogConfig();
    // dialogconfig.disableClose = false;
    // dialogconfig.autoFocus = true;
    // this.dialog.open(SaveformComponent,dialogconfig);
    let config = new MatDialogConfig();
    let dialogRef = this.dialog.open(SaveformComponent, config);
    dialogRef.componentInstance.track = selectedItem;

  }

  add() {
    // const dialogconfig = new MatDialogConfig();
    // dialogconfig.disableClose = false;
    // dialogconfig.autoFocus = true;
    // this.dialog.open(SaveformComponent,dialogconfig);
    let config = new MatDialogConfig();
    let dialogRef = this.dialog.open(SaveformComponent, config);
  }

  openModal() {
    const dialogconfig = new MatDialogConfig();
    dialogconfig.disableClose = false;
    dialogconfig.autoFocus = true;
    this.dialog.open(DeletemodalComponent, dialogconfig);
  }



  applyFilter() {
    this.TrackList.tracks.filter = this.searchKey.toLowerCase().trim();
  }

  onSelect(selectedItem) {
    const editData: Array<any> = [
      { id: selectedItem.id },
      { name: selectedItem.name },
      { date: selectedItem.dateOfRelease },
      { albumid: selectedItem.albumId }
    ];
    console.log(editData);
  }
  searchTrack() {
    this.service.searchSinger(this.keyword).subscribe((item) => {
      this.TrackList = item;
      console.log(item);
    });
  }

}
