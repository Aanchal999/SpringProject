import { Component, Input, OnInit } from '@angular/core';
import { TrackService } from 'src/app/Service/track.service';

@Component({
  selector: 'app-delete-track',
  templateUrl: './delete-track.component.html',
  styleUrls: ['./delete-track.component.scss']
})
export class DeleteTrackComponent implements OnInit {

  constructor(private service: TrackService) { 
    this.track={};
  }

  ngOnInit(): void {
    console.log(this.track);
  }
  
  @Input() track;
  @Input() id: number;

  deleteTrack(){
    console.log(this.track.id);
    this.service.deleteTrack(this.track.id)
    .subscribe((item) => {
      console.log("response: ", item);
    });
  }

}
