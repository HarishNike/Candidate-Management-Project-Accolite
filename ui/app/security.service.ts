import {Injectable} from '@angular/core';
import {environment} from "../environments/environment";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import { Router } from '@angular/router';
import { UserserviceService } from './userservice.service';

@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  private authorizeEndpoint = '/oauth2/authorization/google'
  private tokenEndpoint = '/login/oauth2/code/google';
  private baseUrl = environment.baseUrl;
  private tokenKey = 'token';

  constructor(private http: HttpClient,private router:Router,private userserv:UserserviceService) {
  this.m=20;
  this.d=new Date();
  }

  login() {
    window.open(this.baseUrl + this.authorizeEndpoint, '_self');
  }

  updateToken(token) {
    localStorage.setItem(this.tokenKey, token);
  }

  fetchToken(code, state): Observable<any> {
    return this.http.get(this.baseUrl + this.tokenEndpoint + '?code=' + code + '&state=' + state);
  }
r:any;
m:any;
d:Date;
getm()
{
return this.m;
}
setm(i:any)
{
  this.m=i;
}
settime(f:Date)
  {
      this.d=f;
    }
    rettime()
    {
      return this.d.getTime();
    }
  getToken() {

    var d1=new Date();
    this.r=false;
    var res=Math.abs((this.d.getTime()-d1.getTime())/1000);
    console.log(res);
    if(res>=40)
    {console.log("greater than 80")
    this.router.navigate(['/login']);
      this.logout().subscribe(() => {
      this.removeToken();
      this.router.navigate(['/login']);
    });
    }
    console.log("Access token",localStorage.getItem(this.tokenKey));
    if(res>this.getm())
    {
      var yes=window.confirm("Still want to be logged in");
      this.setm(1232334);
      if(yes==true)
      {
        
      }
    }  
    

    return localStorage.getItem(this.tokenKey);
  }

  isLoggedIn(): boolean {
    const token = this.getToken();
    return token != null;
  }

  removeToken() {
    localStorage.removeItem(this.tokenKey);
  }

  logout(): Observable<any> {
    return this.http.post(this.baseUrl + '/logout', this.getToken());
  }
}
