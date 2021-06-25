import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { IdName } from 'src/app/model/id-name';
import { Track } from 'src/app/model/track-model';
import { SingerService } from 'src/app/Service/singer-service.service';
import { TrackService } from 'src/app/Service/track.service';

@Component({
  selector: 'app-saveform',
  templateUrl: './saveform.component.html',
  styleUrls: ['./saveform.component.scss']
})
export class SaveformComponent implements OnInit {


  name = 'Angular';

  selectedItems = [];
  dropdownSettings = {};
  singerSelectorList: Array<IdName>;

  constructor(public service: TrackService, private dialog: MatDialog, public singerService: SingerService) {
    this.track = new Track();
    this.singerService.selector().subscribe((response: any) => {
      this.singerSelectorList = response;
    })
  }

  @Input() track;
  ngOnInit(){



    this.selectedItems = [
 
    ];
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'id',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      itemsShowLimit: 5,
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
