import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import singers from '/src/app/files/singers.json';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddsingerComponent } from 'src/app/common/saveform/addsinger/addsinger.component';
import { DeletemodalComponent } from 'src/app/common/saveform/deletemodal/deletemodal.component';
import { SingerService } from 'src/app/Service/singer-service.service';
import { Singer } from 'src/app/model/singer-model';

@Component({
  selector: 'app-singers',
  templateUrl: './singers.component.html',
  styleUrls: ['./singers.component.scss']
})
export class SingersComponent implements OnInit {

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

    const dialogconfig = new MatDialogConfig();
    dialogconfig.disableClose = false;
    dialogconfig.autoFocus = true;
    this.dialog.open(AddsingerComponent, dialogconfig);
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
