import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AlbumModel } from '../model/album-model';

@Injectable({
  providedIn: 'root'
})
export class AlbumService {
  constructor(public http: HttpClient) { }

  saveAlbum(album: AlbumModel) {
    const url = '/album/save';
    return this.http.post(url, album);
  }

  getAlbum() {
    const url = '/album/all';
    return this.http.get(url);
  }


  selector() {
    const url = '/album/selector';
    return this.http.get(url);
  }

  searchAlbum(keyword: string) {
    if (keyword == undefined) {
      keyword = "";
    }
    const params = new HttpParams({
      fromObject: {
        keyword: keyword
      }
    });
    console.log(keyword);
    const url = '/album/search';
    return this.http.get(url, { params: params });
  }

  deleteAlbum(id: number) {

    const url = '/album/delete/' + id;
    return this.http.delete(url);
  }
}
