import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Track } from '../model/track-model';

@Injectable({
  providedIn: 'root'
})
export class TrackService {

  constructor(public http: HttpClient) { }

  saveTrack(track: Track) {
    const url = '/track/save';
    return this.http.post(url, track);
  }

  getTrack() {
    const url = '/track/all';
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
    const url = '/track/search';
    return this.http.get(url, { params: params });
  }
}
