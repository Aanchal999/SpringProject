import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { AlbumService } from 'src/app/Service/album.service';
import { SingerService } from 'src/app/Service/singer-service.service';

@Component({
  selector: 'app-addalbum',
  templateUrl: './addalbum.component.html',
  styleUrls: ['./addalbum.component.scss']
})
export class AddalbumComponent implements OnInit {


  
  constructor(public service: AlbumService, private dialog: MatDialog) {
    this.album={};

  }

  @Input() album;

  ngOnInit(){
    console.log(this.album);

  }

  saveAlbum() {
    //enable loader
    this.service.saveAlbum(this.album)
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
