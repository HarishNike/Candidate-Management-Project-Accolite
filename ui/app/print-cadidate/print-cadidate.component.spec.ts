import { HttpClientModule } from '@angular/common/http';
import { async, ComponentFixture, inject, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { UserserviceService } from '../userservice.service';

import { PrintCadidateComponent } from './print-cadidate.component';

describe('PrintCadidateComponent', () => {
 let component: PrintCadidateComponent;
  let fixture: ComponentFixture<PrintCadidateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrintCadidateComponent ],
       imports: [HttpClientModule,RouterTestingModule,FormsModule],
      providers: [UserserviceService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrintCadidateComponent);
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

