import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Login } from '../model/login';
import { Registermodel } from '../model/registermodel';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(public http: HttpClient) { }

  userlogin(login: Login) {
    const url = '/auth/login';
    return this.http.post(url, login);
  }
}
