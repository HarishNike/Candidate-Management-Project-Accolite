import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Logs } from './Logs';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class UserserviceService {


  constructor(private  http: HttpClient) { }
 
public doEnroll(userModel:User){
  // console.log("This is also called")
  // console.log(userModel)

  return this.http.post("http://localhost:8082/addcandidate",userModel,{responseType:'text' as 'json'});
} 
public view(l:any)
{
  return this.http.get("http://localhost:8082/getbyid/"+l)
}
public getAllCandidates()
{
    return this.http.get("http://localhost:8082/getallcandidates")
}
public addlogs(l:Logs)
{
  return this.http.post("http://localhost:8082/addlogs",l,{responseType:'text' as 'json'});
}
public getlogs()
{
  return this.http.get("http://localhost:8082/getlogs");
}
public   getUserInfo() {
    return this.http.get("http://localhost:8082/name",{responseType:'text' as 'json'});
  }

public deleteById(id:number)
{
  return this.http.post("http://localhost:8082/deletecandidate/"+id,null)
}
public updateCandidate(user:User,id:number)
{ //return this.http.post("http://localhost:8082/deletecandidate/"+id,null)
  return  this.http.post("http://localhost:8082/updatecandidate/"+id,user)//,{responseType:'text' as 'json'});
  //return this.http.get("http://localhost:8082/getallcandidates");
}
public getUserByLocation(location:string)
{
  return this.http.get("http://localhost:8082/getcandidatebylocation/"+location)
}
public getUserByJob(location:string)
{
  return this.http.get("http://localhost:8082/getcandidatebyjob/"+location)
}
public countByLocation()
{
  return this.http.get("http://localhost:8082/getlocationcount")
}
public countByJob()
{
  return this.http.get("http://localhost:8082/getJobcount")
}
public countByskill()
{
  return this.http.get("http://localhost:8082/getskill");
}
public getUserByemail(l:string)
{
  return this.http.get("http://localhost:8082/getcandidatebyemail/"+l);
}
}
