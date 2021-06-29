import { Component, Input, OnInit } from '@angular/core';
import { SingerService } from 'src/app/Service/singer-service.service';

@Component({
  selector: 'app-deletemodal',
  templateUrl: './deletemodal.component.html',
  styleUrls: ['./deletemodal.component.scss']
})
export class DeletemodalComponent implements OnInit {

  constructor(private service: SingerService) { 
    this.singer={};
  }

  ngOnInit(): void {
    console.log(this.singer);
  }
  
  @Input() singer;
  @Input() id: number;

  deleteSinger(){
    console.log(this.singer.id);
    this.service.deleteSinger(this.singer.id)
    .subscribe((item) => {
      console.log("response: ", item);
    });
  }
}