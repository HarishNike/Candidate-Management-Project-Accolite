import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, inject, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { SecurityService } from '../security.service';

import { HomeComponent } from './home.component';

describe('HomeComponent', () => {
 let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;
  let testsecurityservice=SecurityService
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeComponent ],
       imports: [HttpClientModule,RouterTestingModule],
      providers: [SecurityService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {

const fixture = TestBed.createComponent(HomeComponent);
    const app = fixture.componentInstance;
    expect(component).toBeTruthy();
  });
  it('should inject service using inject function and check instance',
  inject([SecurityService],(inj:SecurityService)=>{
    expect(inj).toBeTruthy();
    expect(inj instanceof SecurityService).toBeTruthy();
  })
  );
});
