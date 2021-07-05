import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(public http: HttpClient) { }

  getUser() {
    const url = '/user/all';
    return this.http.get(url);
  }

  searchUser(keyword: string){
    if (keyword == undefined) {
      keyword = "";
    }
    const params = new HttpParams({
      fromObject: {
        keyword: keyword
      }
    });
    console.log(keyword);
    const url = '/user/search';
    return this.http.get(url, { params: params });
  }
}
