import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { IdName } from 'src/app/model/id-name';
import { UserModel } from 'src/app/model/user-model';
import { RoleService } from 'src/app/Service/role.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {
  
  name = 'Angular';
  selectedItems = [];
  dropdownSettings = {};
  roleSelectorList: Array<IdName>;

  constructor(public service: RoleService , private dialog: MatDialog) {
    this.user = new UserModel();
    this.service.selector().subscribe((response: any) => {
      this.roleSelectorList = response;
    })
   }

   @Input() user;

  ngOnInit(): void {
    this.user.roles = [
 
    ];
    this.dropdownSettings = {
      singleSelection: false,
      idField: 'id',
      textField: 'name',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      limitSelection: -1,
      allowSearchFilter: true
    };
  }
  saveUser() {
    //enable loader
    console.log(this.user);
    console.log(this.user.roles );
    this.service.saveUser(this.user)
      .subscribe((item) => {
        this.dialog.closeAll();
        //close add singer modal
        //disable loader
      
        console.log("response: ", item);
      });

  }

}
