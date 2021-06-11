import { AfterViewInit, Component, ViewChild,  OnInit } from '@angular/core';
import tracks from '/src/app/files/tracks.json'
import { MatPaginator } from '@angular/material/paginator';
import singers from '/src/app/files/singers.json'

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements AfterViewInit {

TrackList:any;
SingerList:any;
  constructor() {
    this.TrackList = tracks
    this.SingerList = singers
   }

   @ViewChild(MatPaginator) paginator:MatPaginator;

   ngAfterViewInit() {
     
     this.TrackList.tracks.paginator=this.paginator;
   }
 


  applyFilter(filterValue: Event) {
    this.TrackList.tracks.filter=((<HTMLInputElement>filterValue.target).value).toLowerCase().trim();
  }

}
