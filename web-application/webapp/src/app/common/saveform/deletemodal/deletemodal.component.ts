import { Component, Input, OnInit } from '@angular/core';
import { SingerService } from 'src/app/Service/singer-service.service';

@Component({
  selector: 'app-deletemodal',
  templateUrl: './deletemodal.component.html',
  styleUrls: ['./deletemodal.component.scss']
})
export class DeletemodalComponent implements OnInit {

  constructor(private service: SingerService) { }

  ngOnInit(): void {
  }

  @Input() id: number;

  deleteSinger(){
    this.service.deleteSinger(this.id)
    .subscribe((item) => {
      console.log("response: ", item);
    });
  }

}
