import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Track } from 'src/app/model/track-model';
import { TrackService } from 'src/app/Service/track.service';

@Component({
  selector: 'app-saveform',
  templateUrl: './saveform.component.html',
  styleUrls: ['./saveform.component.scss']
})
export class SaveformComponent implements OnInit {


  name = 'Angular';
  dropdownList = [];
  selectedItems = [];
  dropdownSettings = {};

  constructor(public service: TrackService, private dialog: MatDialog) {}

  @Input() track;
  ngOnInit(){


    this.dropdownList = [
      { item_id: 1, item_text: 'Mumbai' },
      { item_id: 2, item_text: 'Bangaluru' },
      { item_id: 3, item_text: 'Pune' },
      { item_id: 4, item_text: 'Navsari' },
      { item_id: 5, item_text: 'New Delhi' }
    ];
    this.selectedItems = [
      { item_id: 3, item_text: 'Pune' },
      { item_id: 4, item_text: 'Navsari' }
    ];
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'item_id',
      textField: 'item_text',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 3,
      allowSearchFilter: true
    };

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
