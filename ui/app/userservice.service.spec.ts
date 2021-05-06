import { HttpClientModule } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { User } from './User';

import { UserserviceService } from './userservice.service';

describe('UserserviceService', () => {
 let service: UserserviceService;
  let httpctrl:HttpTestingController;
  let dataservice=UserserviceService
  beforeEach(() => {
    TestBed.configureTestingModule({
       imports: [HttpClientModule,RouterTestingModule,HttpClientTestingModule],
      providers: [UserserviceService]
    });
    service = TestBed.inject(UserserviceService);
  });
  beforeEach( ()=>{
    httpctrl=TestBed.inject(HttpTestingController);
    

  }
  )
afterEach(()=>{
  httpctrl.verify();
})
  it('should test http get request', () => {
   const test:User[]=[
     {id:0,email:'',name:'',joindate:new Date(),location:'',feedback:'',institution:'',jobDescription:'',cpp:"no",java:"no",angular:"no",python:"no",react:"no",javascript:"no",android:"no",contact:""},
   ];
      
      service.getAllCandidates().subscribe(
        (post)=>{
          expect(post).toBe(test,'should check mocked data');
        }
      );
      const req=httpctrl.expectOne("http://localhost:8082/getallcandidates");
        expect(req.cancelled).toBeFalsy();
        expect(req.request.responseType).toEqual('json');
        req.flush(test)
  });
it('should test http post request', () => {
   const test: User=
     {id:0,email:'',name:'',joindate:new Date(),location:'',feedback:'',institution:'',jobDescription:'',cpp:"no",java:"no",angular:"no",python:"no",react:"no",javascript:"no",android:"no",contact:""};
      
      service.doEnroll(test).subscribe(
        (post)=>{
          // expect(post).toBe(test,'should check mocked data');
        console.log(post)
        }
      );
      const req=httpctrl.expectOne("http://localhost:8082/addcandidate");
        expect(req.cancelled).toBeFalsy();
        expect(req.request.responseType).toEqual('text');
        req.flush(test)
  });
  it('should test http put request', () => {
   const test: User=
     {id:0,email:'',name:'',joindate:new Date(),location:'',feedback:'',institution:'',jobDescription:'',cpp:"no",java:"no",angular:"no",python:"no",react:"no",javascript:"no",android:"no",contact:""};
      
      service.updateCandidate(test,0).subscribe(
        (post)=>{
          expect(post).toBe(test,'should check mocked data');
        console.log(post)
        }
      );
      const req=httpctrl.expectOne("http://localhost:8082/updatecandidate/"+0);
        expect(req.cancelled).toBeFalsy();
        expect(req.request.responseType).toEqual('json');
        req.flush(test)
  });
  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

