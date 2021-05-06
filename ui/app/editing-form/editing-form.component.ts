import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../User';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-editing-form',
  templateUrl: './editing-form.component.html',
  styleUrls: ['./editing-form.component.scss']
})
export class EditingFormComponent implements OnInit {
  id:any;
  userModel:User = new User(0,'','',new Date(),'','','','',"no","no","no","no","no","no","no","");
  constructor(private userservice:UserserviceService,private ac:ActivatedRoute,private router:Router) 
  {
    this.ac.queryParams.subscribe(params=>{this.id=params.id});
    // console.log(this.user.email);
   }
   cppfv:number;jv:number;pyv:number;jsv:number;angv:number;rev:number;anv:number
cppf(){if(this.cppfv==0)this.userModel.cpp='yes',this.cppfv=1;else this.userModel.cpp='no',this.cppfv=0;}
j(){if(this.jv==0)this.userModel.java='yes',this.jv=1;else this.userModel.java='no',this.jv=0;}
py(){if(this.pyv==0)this.userModel.python='yes',this.pyv=1;else this.userModel.python='no',this.pyv=0;}
js(){if(this.jsv==0)this.userModel.javascript='yes',this.jsv=1;else this.userModel.javascript='no',this.jsv=0;}
ang(){if(this.angv==0)this.userModel.angular='yes',this.angv=1;else this.userModel.angular='no',this.angv=0;}
re(){if(this.rev==0)this.userModel.react='yes',this.rev=1;else this.userModel.react='no',this.rev=0;}
an(){if(this.anv==0)this.userModel.android='yes',this.anv=1;else this.userModel.android='no',this.anv=0;}


Skills=["C++","Java","Python","Angular","Spring"];
Loc=["Bangalore","Mumbai","Chennai","Hyderabad","Delhi"];
  func(f:any)
  {if(f=='yes')return false; return true;} 
  ngOnInit(): void {
    this.cppfv=0,this.jv=0,this.pyv=0,this.jsv=0,this.angv=0,this.rev=0,this.anv=0;
this.userservice.view(this.id).subscribe((data:User)=>{this.userModel=data;});
this.userModel.cpp="no",this.userModel.java="no",this.userModel.javascript="no"
this.userModel.python="no",this.userModel.angular="no",this.userModel.react="no"
this.userModel.android="no"
}
  public enrollNow()
  {
    let resp=this.userservice.updateCandidate(this.userModel,this.userModel.id); 
    resp.subscribe((data:User)=>{this.userModel=data});
    this.router.navigate(['home/newone']);
  
  }

}
