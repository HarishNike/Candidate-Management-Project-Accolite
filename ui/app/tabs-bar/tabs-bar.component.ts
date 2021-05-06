import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tabs-bar',
  templateUrl: './tabs-bar.component.html',
  styleUrls: ['./tabs-bar.component.scss']
})
export class TabsBarComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  public home()
{
  this.router.navigate(['/home']);
}

}
