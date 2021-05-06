import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../User';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-print-cadidate',
  templateUrl: './print-cadidate.component.html',
  styleUrls: ['./print-cadidate.component.scss']
})
export class PrintCadidateComponent implements OnInit {

id:any
  user:User = new User(0,'','',new Date(),'','','','',"no","no","no","no","no","no","no","");
  constructor(private userservice:UserserviceService,private ac:ActivatedRoute) { 

    this.ac.queryParams.subscribe(params=>{this.id=params.id;});
  }
public func(f:any){
  if(f=='yes')return true;
  return false;
}
  ngOnInit(): void {

    this.userservice.view(this.id).subscribe((data:User)=>{this.user=data;});
// this.user.name="harish";
  }
  public fetch()
  {

  }

}
