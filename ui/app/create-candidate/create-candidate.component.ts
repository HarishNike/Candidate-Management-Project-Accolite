import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Logs } from '../Logs';
import { User } from '../User';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-create-candidate',
  templateUrl: './create-candidate.component.html',
  styleUrls: ['./create-candidate.component.scss']
})
export class CreateCandidateComponent implements OnInit {

Loc=["Bangalore","Mumbai","Chennai","Hyderabad","Delhi"];
  Role=["Intern","Employee","Manager","HR"];
  Skills=["C++","Java","Python","Angular","Spring"];
  hasError=true;
  errorMsg="";
  constructor(private serv: UserserviceService,private router:Router) { }
message:any;
email:string;
  ngOnInit(): void {
    this.cppfv=0,this.jv=0,this.pyv=0,this.jsv=0,this.angv=0,this.rev=0,this.anv=0;
    this.email=this.userModel.email;
  }
message1:any;
userModel:User = new User(0,'','',new Date(),'','','','',"no","no","no","no","no","no","no","");
cppfv:number;jv:number;pyv:number;jsv:number;angv:number;rev:number;anv:number
cppf(){if(this.cppfv==0)this.userModel.cpp='yes',this.cppfv=1;else this.userModel.cpp='no',this.cppfv=0;}
j(){if(this.jv==0)this.userModel.java='yes',this.jv=1;else this.userModel.java='no',this.jv=0;}
py(){if(this.pyv==0)this.userModel.python='yes',this.pyv=1;else this.userModel.python='no',this.pyv=0;}
js(){if(this.jsv==0)this.userModel.javascript='yes',this.jsv=1;else this.userModel.javascript='no',this.jsv=0;}
ang(){if(this.angv==0)this.userModel.angular='yes',this.angv=1;else this.userModel.angular='no',this.angv=0;}
re(){if(this.rev==0)this.userModel.react='yes',this.rev=1;else this.userModel.react='no',this.rev=0;}
an(){if(this.anv==0)this.userModel.android='yes',this.anv=1;else this.userModel.android='no',this.anv=0;}
public enrollNow(){

 this.errorCheck();
  if (this.hasError==false){
    this.errorMsg="";
    console.log("calling the function")
    let resp=this.serv.doEnroll(this.userModel);
resp.subscribe((data)=>this.message=data);
let f=new Date();
let l:Logs=new Logs('harish','create',f);    
let resp1=this.serv.addlogs(l);
resp1.subscribe((data)=>this.message=data);
window.alert("Candidate added successfully ...");

  this.router.navigate(['home/newone']);

this.userModel.name='';
this.userModel.email='';
this.userModel.location='';
this.userModel.feedback='';
this.userModel.contact='';
this.userModel.joindate=new Date();
this.userModel.institution="";
}
  else {
    this.errorMsg="Enter correct Contact Number";
  }
}

@ViewChild('userForm',{static:true}) userForm:NgForm

public errorCheck(){
  if (this.userModel.contact==''){
    this.hasError=true;
  }
  else{
    this.hasError=false;
  }
}

}


