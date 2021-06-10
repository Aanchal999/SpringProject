import { Component, OnInit } from '@angular/core';
import tracks from '/src/app/files/tracks.json'
@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

TrackList:any;

  constructor() {
    this.TrackList = tracks
   }

  ngOnInit(): void {
    
  }

}
