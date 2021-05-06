import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, inject, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { UserserviceService } from '../userservice.service';

import { EditingFormComponent } from './editing-form.component';

describe('EditingFormComponent', () => {
   let component: EditingFormComponent;
  let fixture: ComponentFixture<EditingFormComponent>;

  beforeEach(async(() => {
 
 TestBed.configureTestingModule({
      declarations: [ EditingFormComponent ],
       imports: [HttpClientModule,RouterTestingModule,FormsModule],
      providers: [UserserviceService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditingFormComponent);
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
});
