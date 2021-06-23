import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddalbumComponent } from 'src/app/common/saveform/addalbum/addalbum.component';
import { DeletemodalComponent } from 'src/app/common/saveform/deletemodal/deletemodal.component';
import { SingerService } from 'src/app/Service/singer-service.service';

@Component({
  selector: 'app-albums',
  templateUrl: './albums.component.html',
  styleUrls: ['./albums.component.scss']
})
export class AlbumsComponent implements OnInit {

  keyword: string;
  singerList: any;

  constructor(private dialog: MatDialog, public service: SingerService) {
    this.singerList = [];
  }

  id: number;
  @Input() selected: boolean;
  @Output() selectedChange = new EventEmitter<boolean>();



  ngOnInit() {
    this.getSinger();
  }

  public toggleSelected() {
    this.selected = !this.selected;
    this.selectedChange.emit(this.selected);
  }

  applyFilter(filterValue: Event) {
    this.singerList.filter = ((<HTMLInputElement>filterValue.target).value).toLowerCase().trim();
  }


  onCreate(selectedItem) {

    const editData:Array<any> = [
      {id: selectedItem.id},
      {name: selectedItem.name},
      {date: selectedItem.dateOfRelease},
      {albumid:selectedItem.albumId}
    ];
      console.log(editData);

   // const dialogconfig = new MatDialogConfig();
    //dialogconfig.disableClose = false;
    //dialogconfig.autoFocus = true;
    //this.dialog.open(AddsingerComponent, dialogconfig);
    

    let config = new MatDialogConfig();
    let dialogRef = this.dialog.open(AddalbumComponent, config);
    dialogRef.componentInstance.singer = selectedItem;


  }

  openModal() {
    const dialogconfig = new MatDialogConfig();
    dialogconfig.disableClose = false;
    dialogconfig.autoFocus = true;
    const modalRef= this.dialog.open(DeletemodalComponent, dialogconfig);
    (<DeletemodalComponent>modalRef.componentInstance).id = this.id;
  }

  getSinger() {
    this.service.getSinger().subscribe((response) => {
      this.singerList = response;
    });
  }

  searchSinger() {
    this.service.searchSinger(this.keyword).subscribe((item) => {
      this.singerList = item;
      console.log(item);
    });
  }


}
