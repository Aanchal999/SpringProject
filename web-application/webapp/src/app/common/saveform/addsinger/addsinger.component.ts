import { Component, OnInit,ViewChild } from '@angular/core';

@Component({
  selector: 'app-addsinger',
  templateUrl: './addsinger.component.html',
  styleUrls: ['./addsinger.component.scss']
})
export class AddsingerComponent implements OnInit {
  @ViewChild('closebutton') closebutton;
  constructor() { }

  ngOnInit(): void {
  }

  public onSave() {
    this.closebutton.nativeElement.click();
  }
}
