import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatDialog, matDialogAnimations, MatDialogClose, MatDialogConfig } from '@angular/material/dialog';
import { Singer } from 'src/app/model/singer-model';
import { SingerService } from 'src/app/Service/singer-service.service';

@Component({
  selector: 'app-addsinger',
  templateUrl: './addsinger.component.html',
  styleUrls: ['./addsinger.component.scss']
})
export class AddsingerComponent implements OnInit {



  constructor(public service: SingerService, private dialog: MatDialog) {

  }

  @Input() singer;

  ngOnInit(): void {
    console.log(this.singer);

  }

  saveSinger() {
    //enable loader
    this.service.saveSinger(this.singer)
      .subscribe((item) => {
        this.dialog.closeAll();
        //close add singer modal
        //disable loader
        if (item) {
          hideloader();
        }
        console.log("response: ", item);
      });

    function hideloader() {
      document.getElementById('loading').style.display;
    }
  }

}
