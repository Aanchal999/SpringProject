import { Injectable } from '@angular/core';
import { Singer } from '../model/singer-model';
import { HttpClient, HttpParams } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { query } from '@angular/animations';

@Injectable({
  providedIn: 'root'
})
export class SingerService {

  constructor(public http: HttpClient) { }

  saveSinger(singer: Singer) {
    const url = environment.origin + '/singer/save';
    return this.http.post(url, singer);
  }

  getSinger() {
    const url = environment.origin + '/singer/all';
    return this.http.get(url);
  }

  searchSinger(keyword: string) {
    if (keyword == undefined) {
      keyword = "";
    }
    const params = new HttpParams({
      fromObject: {
        keyword: keyword
      }
    });
    console.log(keyword);
    const url = environment.origin + '/singer/search';
    return this.http.get(url, { params: params });
  }

  deleteSinger(id: number){
    const url = environment.origin + '/singer/delete/' +id;
    return this.http.delete(url);
  }
}
