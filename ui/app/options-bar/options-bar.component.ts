import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-options-bar',
  templateUrl: './options-bar.component.html',
  styleUrls: ['./options-bar.component.scss']
})
export class OptionsBarComponent implements OnInit {

  constructor() { }
  issign=true;
  ngOnInit(): void {
  }
public issig()
{
  this.issign=true;
}

}
