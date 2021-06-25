import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Registermodel } from '../model/registermodel';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(public http: HttpClient) { }

  register(signup: Registermodel) {
    const url = '/auth/register';
    return this.http.post(url, signup);
  }
}
