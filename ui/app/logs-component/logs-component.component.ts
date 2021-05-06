import { Component, OnInit } from '@angular/core';
import { UserserviceService } from '../userservice.service';

@Component({
  selector: 'app-logs-component',
  templateUrl: './logs-component.component.html',
  styleUrls: ['./logs-component.component.scss']
})
export class LogsComponentComponent implements OnInit {
  constructor(private userService:UserserviceService) { }
  users:any;
  ngOnInit(): void {
let resp= this.userService.getlogs();
    console.log(resp)
    resp.subscribe((data)=>this.users=data); 
  }

}
