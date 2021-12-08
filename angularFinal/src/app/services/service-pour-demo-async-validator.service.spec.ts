import { TestBed } from '@angular/core/testing';

import { ServicePourDemoAsyncValidatorService } from './service-pour-demo-async-validator.service';

describe('ServicePourDemoAsyncValidatorService', () => {
  let service: ServicePourDemoAsyncValidatorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServicePourDemoAsyncValidatorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
