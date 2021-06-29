import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DetasharingService {
public subject = new BehaviorSubject<any>("");

emit<T>(data: T){
  this.subject.next(data);
}
  constructor() { }

  on<T>(): Observable<T>{
    return this.subject.asObservable();
  }

  }

