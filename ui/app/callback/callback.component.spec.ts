import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, inject, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { SecurityService } from '../security.service';

import { CallbackComponent } from './callback.component';

describe('CallbackComponent', () => {
   let component: CallbackComponent;
  let fixture: ComponentFixture<CallbackComponent>;
let testsecurityservice=SecurityService
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CallbackComponent ],
       imports: [HttpClientModule,RouterTestingModule],
      providers: [SecurityService]
      
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CallbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should inject service using inject function and check instance',
  inject([SecurityService],(inj:SecurityService)=>{
    expect(inj).toBeTruthy();
    expect(inj instanceof SecurityService).toBeTruthy();
  })
  );
});
