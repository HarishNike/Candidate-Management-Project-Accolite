import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
// import { SIGKILL } from 'constants';
import  { UserserviceService } from '../userservice.service'
@Component({
  selector: 'app-trends',
  templateUrl: './trends.component.html',
  styleUrls: ['./trends.component.scss']
})
export class TrendsComponent implements OnInit {

  constructor(private userService:UserserviceService) { }

title = 'Angular Charts';
 
  // count:LocationCount;
  counts:any;
  view: any[] = [600, 400];
single:any;
job:any;
trends:any;
  showXAxis = true;
  showYAxis = true;
  gradient = false;
  showLegend = true;
  showXAxisLabel = true;
  xAxisLabel1 = 'Locations';
  xAxisLabel2 = 'Job description';
  showYAxisLabel = true;
  yAxisLabel = 'Number of people';
  timeline = true;

  colorScheme = {
    domain: ['red', 'blue', 'black', 'brown', 'yellow', 'green']
  };
  showLabels = true;
  skill:any
  ngOnInit(): void {
    
    this.userService.countByLocation().subscribe((trends:any[]) => {
   console.log(trends)
      let data: any[] =[];     
      for (let trend of trends)
      {
         data.push({
             "name" : trend.location,
             "value" : trend.count,
          })
         }
        this.single =data;
      });


      this.userService.countByJob().subscribe((trends:any[]) => {
        console.log(trends)
           let data: any[] =[];     
           for (let trend of trends)
           {
              data.push({
                  "name" : trend.location,
                  "value" : trend.count,
               })
              }
             this.job =data;
           });
     let data: any[]=[];
     let s:string[] = ['cpp', 'java', 'python','angular','react','javascript','android'];
    this.userService.countByskill().subscribe((trends:any[]) => {
        console.log(trends)
        var i=0;
           let data: any[] =[];     
           for (let trend of trends)
           {
              data.push({
                  "name" : trend.location,
                  "value" : trend.count,
               })
              }
             this.skill =data;
           console.log(this.skill)
            });

}
}
