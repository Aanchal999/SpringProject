import { Component, Input, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { TrackService } from 'src/app/Service/track.service';

@Component({
  selector: 'app-albumselector',
  templateUrl: './albumselector.component.html',
  styleUrls: ['./albumselector.component.scss']
})
export class AlbumselectorComponent implements OnInit {

  id:number;
  name:string;
  keyword: string;
  searchKey: string;
  p: number = 1;
  TrackList: any;
  SingerList: any;
  
  constructor(private dialog: MatDialog, public service: TrackService,private _route: ActivatedRoute) {
    this.TrackList = [];
    this.album={};
  }

  @Input() album;

  ngOnInit() {
    this._route.paramMap.subscribe(
      (params: any) => {
        console.log(params.params.albumId);
     
   
    this.service.getselectorTrack(params.params.albumId).subscribe((response:any) => {
      this.TrackList = response;
      console.log(response.tracks);
    });
  });
  }

  getselectorTrack(){
    // this.service.getselectorTrack(this.id).subscribe((response: any) => {
    //   this.TrackList = response;
    // });
  }

  getTrack() {
    this.service.getTrack().subscribe((response) => {
      this.TrackList = response;
    });
  }

  onCreate(selectedItem) {

    // let config = new MatDialogConfig();
    // let dialogRef = this.dialog.open(SaveformComponent, config);
    // dialogRef.componentInstance.track = selectedItem;

  }

  add() {

    // let config = new MatDialogConfig();
    // let dialogRef = this.dialog.open(SaveformComponent, config);
  }

  openModal() {
    // const dialogconfig = new MatDialogConfig();
    // dialogconfig.disableClose = false;
    // dialogconfig.autoFocus = true;
    // this.dialog.open(DeletemodalComponent, dialogconfig);
  }



  applyFilter() {
    this.TrackList.tracks.filter = this.searchKey.toLowerCase().trim();
  }

  onSelect(selectedItem) {
    // const editData: Array<any> = [
    //   { id: selectedItem.id },
    //   { name: selectedItem.name },
    //   { date: selectedItem.dateOfRelease },
    //   { albumid: selectedItem.albumId }
    // ];
    // console.log(editData);
  }
  searchTrack() {
    // this.service.searchSinger(this.keyword).subscribe((item) => {
    //   this.TrackList = item;
    //   console.log(item);
    // });
  }



}
