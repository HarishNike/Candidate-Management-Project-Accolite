import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LogsComponentComponent } from './logs-component.component';

describe('LogsComponentComponent', () => {
let component: LogsComponentComponent;
  let fixture: ComponentFixture<LogsComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LogsComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LogsComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  // it('should create', () => {
  //   expect(component).toBeTruthy();
  // });
});
