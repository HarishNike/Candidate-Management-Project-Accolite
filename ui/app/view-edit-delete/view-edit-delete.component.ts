import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Logs } from '../Logs';
import { User } from '../User';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-view-edit-delete',
  templateUrl: './view-edit-delete.component.html',
  styleUrls: ['./view-edit-delete.component.scss']
})
export class ViewEditDeleteComponent implements OnInit {

p:number=1;
  curr:number;
  showedit=false;
  users:any;
  yes:'yes'
  name:any;
  msg:any;
  http: any;
  constructor(private userService: UserserviceService,private router: Router) { }
  Loc=["Bangalore","Mumbai","Chennai","Hyderabad","Delhi"];
  Role=["Intern","Employee","Manager","HR"];
  ngOnInit(): void {
    this.cppfv=0,this.jv=0,this.pyv=0,this.jsv=0,this.angv=0,this.rev=0,this.anv=0;
    let resp= this.userService.getAllCandidates();
    resp.subscribe((data)=>this.users=data);
    let resp1=this.userService.getUserInfo()
    resp1.subscribe((data) => this.name = data);
    
      }
  public viewCandidate(i:any)
  {
    this.router.navigate(['/print'],{queryParams:{'id':i}});
  }
searchcontent:any;
  func(f:any)
  {if(f=='yes')return true; return false;} 
searchGrad(searchcontent:string){
    
      let resp=this.userService.getUserByemail(searchcontent);
      resp.subscribe((data)=> this.users=data);
    }
  cppfv:number;jv:number;pyv:number;jsv:number;angv:number;rev:number;anv:number
  cppf(user:User){if(this.cppfv==0)user.cpp='yes',this.cppfv=1;else user.cpp='no',this.cppfv=0;};
  j(user:User){if(this.jv==0)user.java='yes',this.jv=1;else user.java='no',this.jv=0;}
pye(user:User){if(this.pyv==0)user.python='yes',this.pyv=1;else user.python='no',this.pyv=0;}
jse(user:User){if(this.jsv==0)user.javascript='yes',this.jsv=1;else user.javascript='no',this.jsv=0;}
ange(user:User){if(this.angv==0)user.angular='yes',this.angv=1;else user.angular='no',this.angv=0;}
re(user:User){if(this.rev==0)user.react='yes',this.rev=1;else user.react='no',this.rev=0;}
an(user:User){if(this.anv==0)user.android='yes',this.anv=1;else user.android='no',this.anv=0;}
newcpp(user:User){user.cpp='yes'}
  public openEdit(id:number,user:User)
{
  this.curr=id;
  user.cpp='no',user.android='no',user.python='no',user.java='no',user.javascript='no',
  user.angular='no',user.react='no';

      let f=new Date();
let l:Logs=new Logs(this.name,'update',f);    
let resp1=this.userService.addlogs(l);
resp1.subscribe((data)=>this.msg=data);
  this.router.navigate(['/editing'],{queryParams:{'id':id}});
}

public deleteCandidate(id:number)
  {
    let f=new Date();
let l:Logs=new Logs(this.name,'delete',f);    
let resp1=this.userService.addlogs(l);
resp1.subscribe((data)=>this.name=data);
var r=confirm("Delete this record permanently");
if(r==true)
{   let resp=this.userService.deleteById(id);
    resp.subscribe((data)=>
    this.reload());
}   
  }
  reload()
  {  let resp= this.userService.getAllCandidates();
    console.log(resp)
    resp.subscribe((data)=>this.users=data)
  
  }
  
public updateDetails(id:number,user:User){
  this.showedit=false;
      let f=new Date();
let l:Logs=new Logs(this.name,'update',f);    
let resp1=this.userService.addlogs(l);
resp1.subscribe((data)=>this.msg=data);
console.log(this.name);
  let resp=this.userService.updateCandidate(user,id);
 resp.subscribe((data)=> this.users=data);
}

}











  //  ang(f:any)
  // {if(f=='yes')return true; return false;}
  //  reac(f:any)
  // {if(f=='yes')return true; return false;}
  //  jav(f:any)
  // { if(f=='yes')return true; return false;}
  //  py(f:any)
  // { if(f=='yes')return true; return false;}
  //  cp(f:any)
  //  { if(f=='yes')return true; return false;}
  //  js(f:any)
  // { if(f=='yes')return true; return false;}