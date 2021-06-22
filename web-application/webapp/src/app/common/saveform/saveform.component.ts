import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Track } from 'src/app/model/track-model';
import { TrackService } from 'src/app/Service/track.service';

@Component({
  selector: 'app-saveform',
  templateUrl: './saveform.component.html',
  styleUrls: ['./saveform.component.scss']
})
export class SaveformComponent implements OnInit {

  track: Track;

  constructor(public service: TrackService, private dialog: MatDialog) {
    this.track = new Track();
   }

  ngOnInit(): void {
  }

  saveTrack() {
    //enable loader
    console.log(this.track);
    this.service.saveTrack(this.track)
      .subscribe((item) => {
        this.dialog.closeAll();
        //close add singer modal
        //disable loader
      
        console.log("response: ", item);
      });

  }

}
