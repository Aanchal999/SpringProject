import { Component, Input, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { AddUserComponent } from '../common/saveform/add-user/add-user.component';
import { AdminService } from '../Service/admin.service';

@Component({
  selector: 'app-admin-panel',
  templateUrl: './admin-panel.component.html',
  styleUrls: ['./admin-panel.component.scss']
})
export class AdminPanelComponent implements OnInit {

  keyword: string;
  userList: any;

  constructor(private dialog: MatDialog, public service: AdminService) { 
    this.userList = [];
    this.user={};
  }

  @Input() user;

  ngOnInit(){
    this.getUser();
  }

  
  getUser() {
    this.service.getUser().subscribe((response) => {
      this.userList = response;
    });
  }

  add(){
    let config = new MatDialogConfig();
    let dialogRef = this.dialog.open(AddUserComponent , config);
  }
  searchUser(){
    this.service.searchUser(this.keyword).subscribe((item) => {
      this.userList = item;
      console.log(item);
    });
  }

}
