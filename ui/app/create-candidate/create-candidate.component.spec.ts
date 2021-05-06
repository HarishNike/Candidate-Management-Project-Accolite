import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, inject, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { UserserviceService } from '../userservice.service';

import { CreateCandidateComponent } from './create-candidate.component';

describe('CreateCandidateComponent', () => {
let component: CreateCandidateComponent;
  let fixture: ComponentFixture<CreateCandidateComponent>;
  let testsecurityservice:UserserviceService
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateCandidateComponent ],
       imports: [HttpClientModule,RouterTestingModule,FormsModule],
      providers: [UserserviceService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateCandidateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('should inject service using inject function and check instance',
  inject([UserserviceService],(inj:UserserviceService)=>{
    expect(inj).toBeTruthy();
    expect(inj instanceof UserserviceService).toBeTruthy();
  }));

  it('[Email - Check - Invalid] - Should check email is not valid',async( () => {
  
    fixture.whenStable().then(()=>{
      let email=component.userForm.form.controls['email'];
  // expect(email.valid).toBeFalsy()
  expect(component.userForm.valid).toBeFalsy();
    email.setValue('harishnike2605@gmail.com');
    expect(email.valid).toBeTruthy();
  
    }

    );
  
  }));


});
