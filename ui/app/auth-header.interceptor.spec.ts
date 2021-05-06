import { HttpClientModule } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { AuthHeaderInterceptor } from './auth-header.interceptor';
import { SecurityService } from './security.service';

describe('AuthHeaderInterceptor', () => {
   beforeEach(() => TestBed.configureTestingModule({
     imports: [HttpClientModule,RouterTestingModule,HttpClientModule],
    providers: [
      AuthHeaderInterceptor,SecurityService
      ]
  }));

  it('should be created', () => {
    const interceptor: AuthHeaderInterceptor = TestBed.inject(AuthHeaderInterceptor);
    expect(interceptor).toBeTruthy();
  });
});
