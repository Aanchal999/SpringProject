import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserModel } from '../model/user-model';
import { AdminService } from './admin.service';

@Injectable({
  providedIn: 'root'
})
export class RoleService {

  constructor(public http: HttpClient) { }
  
  selector() {
    const url = '/role/selector';
    return this.http.get(url);
  }

  saveUser(user: UserModel) {
    const url = '/user/save';
    return this.http.post(url, user);
  }
  
}
