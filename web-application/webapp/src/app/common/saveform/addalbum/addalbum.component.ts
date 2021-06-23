import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { SingerService } from 'src/app/Service/singer-service.service';

@Component({
  selector: 'app-addalbum',
  templateUrl: './addalbum.component.html',
  styleUrls: ['./addalbum.component.scss']
})
export class AddalbumComponent implements OnInit {


  
  constructor(public service: SingerService, private dialog: MatDialog) {

  }

  @Input() singer;

  ngOnInit(){
    console.log(this.singer);

  }

  // saveSinger() {
  //   //enable loader
  //   this.service.saveSinger(this.singer)
  //     .subscribe((item) => {
  //       this.dialog.closeAll();
  //       //close add singer modal
  //       //disable loader
  //       if (item) {
  //         hideloader();
  //       }
  //       console.log("response: ", item);
  //     });

  //   function hideloader() {
  //     document.getElementById('loading').style.display;
  //   }
  // }
}
