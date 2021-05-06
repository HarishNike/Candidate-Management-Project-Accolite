import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { TabsBarComponent } from './tabs-bar.component';

describe('TabsBarComponent', () => {
   let component: TabsBarComponent;
  let fixture: ComponentFixture<TabsBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TabsBarComponent ],
      imports:[RouterTestingModule]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TabsBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

});
