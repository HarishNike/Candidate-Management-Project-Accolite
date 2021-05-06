import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, inject, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { SecurityService } from '../security.service';

import { LoginComponent } from './login.component';

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let testsecurityservice=SecurityService
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [HttpClientModule,RouterTestingModule],
      providers: [SecurityService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    testsecurityservice=TestBed.get(SecurityService)
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should check service', () => {
    expect(testsecurityservice instanceof SecurityService).toBeTruthy();
  });
  it('should inject service using inject function and check instance', 
  inject([SecurityService],(inj:SecurityService)=>{
    expect(inj).toBeTruthy();
    expect(inj instanceof SecurityService).toBeTruthy();
  })
  );

});
