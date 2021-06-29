import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { Router } from '@angular/router';
import { AddalbumComponent } from 'src/app/common/saveform/addalbum/addalbum.component';
import { DeletemodalComponent } from 'src/app/common/saveform/deletemodal/deletemodal.component';
import { AlbumService } from 'src/app/Service/album.service';
import { SingerService } from 'src/app/Service/singer-service.service';
import { AlbumselectorComponent } from './albumselector/albumselector.component';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.scss']
})
export class AlbumsComponent implements OnInit {
 
  keyword: string;
  albumList: any;

  constructor(private dialog: MatDialog, public service: AlbumService, private route: Router) {
    this.albumList = [];
    this.album = {};
  }

  @Input() album;
  id: number;
  name:string;
  @Input() selected: boolean;
  @Output() selectedChange = new EventEmitter<boolean>();



  ngOnInit() {
    this.getAlbum();
  }





  onCreate(selectedItem) {
    // let config = new MatDialogConfig();
    // let dialogRef = this.dialog.open(AddalbumComponent, config);
    // dialogRef.componentInstance.album = selectedItem;
  }

  openSelector(selectedItem) {
    this.route.navigate(['/albumselector/' + selectedItem.id + '/' + selectedItem.name] )
  //  let config = new MatDialogConfig();
  //  let dialogRef = this.dialog.open(AlbumselectorComponent, config);
  //  dialogRef.componentInstance.album = selectedItem;
  
  }

  add() {
    let config = new MatDialogConfig();
    let dialogRef = this.dialog.open(AddalbumComponent, config);
  }

  openModal() {
    // const dialogconfig = new MatDialogConfig();
    // dialogconfig.disableClose = false;
    // dialogconfig.autoFocus = true;
    // const modalRef= this.dialog.open(DeletemodalComponent, dialogconfig);
    // (<DeletemodalComponent>modalRef.componentInstance).id = this.id;
  }

  getAlbum() {
    this.service.getAlbum().subscribe((response) => {
      this.albumList = response;
    });
  }

  searchAlbum() {
    this.service.searchAlbum(this.keyword).subscribe((item) => {
      this.albumList = item;
      console.log(item);
    });
  }


}
function albumselectorComponent(albumselectorComponent: any, config: MatDialogConfig<any>) {
  throw new Error('Function not implemented.');
}

