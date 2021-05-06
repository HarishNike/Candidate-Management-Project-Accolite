import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { NgxPaginationModule } from 'ngx-pagination';
import { UserserviceService } from '../userservice.service';

import { ViewEditDeleteComponent } from './view-edit-delete.component';

describe('ViewEditDeleteComponent', () => {
 let component: ViewEditDeleteComponent;
  let fixture: ComponentFixture<ViewEditDeleteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewEditDeleteComponent ],
         imports: [HttpClientModule,RouterTestingModule,NgxPaginationModule],
      providers: [UserserviceService]
      
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewEditDeleteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

