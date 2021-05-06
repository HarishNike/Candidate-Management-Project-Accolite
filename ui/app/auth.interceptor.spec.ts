import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';

import { AuthInterceptor } from './auth.interceptor';
import { UserserviceService } from './userservice.service';
import { SecurityService } from './security.service';

describe('AuthInterceptor', () => {
  let httpmock:HttpTestingController;
  let service:UserserviceService
  beforeEach(() => {TestBed.configureTestingModule({
    imports: [HttpClientModule,RouterTestingModule,HttpClientTestingModule],
      
    providers: [
      AuthInterceptor,
      SecurityService,
      ]
  });
});

beforeEach( ()=>{
    httpmock=TestBed.inject(HttpTestingController);
     service=TestBed.inject(UserserviceService);


  }
  )
afterEach(()=>{
  httpmock.verify();
})

  it('should be created', () => {
    const interceptor: AuthInterceptor = TestBed.inject(AuthInterceptor);
    expect(interceptor).toBeTruthy();
  });
  it('should add content type and accept property in http header', () => {
    service.getAllCandidates().subscribe(res=>{
      expect(res).toBeTruthy();
    })
    const httpReq=httpmock.expectOne('http://localhost:8082/getallcandidates');
    expect(httpReq.request.headers.has('Content-Type')).toBeDefined();
    expect(httpReq.request.headers.has('Accept')).toBeDefined();
    expect(httpReq.request.headers.has('Content-Type')).toBe(false);
    
  });


});
