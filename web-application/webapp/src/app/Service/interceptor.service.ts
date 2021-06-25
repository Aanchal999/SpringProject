import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InterceptorService implements HttpInterceptor {

  constructor(private route: Router) { }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const url = request.url;
    const token = localStorage.getItem("token");
    if (token == undefined || token == null || token == "") {
      if (url != "/auth/login" && url != "/auth/register") {
        this.route.navigate(['/login']);
      }
    }

    request = request.clone({
      url: environment.origin + url
    });


    if (url != "/auth/login" && url != "/auth/register") {
      request = request.clone({
        setHeaders: {
          Authorization: `Bearer ${token}`
        }
      });
    }

    return next.handle(request);
  }

}

