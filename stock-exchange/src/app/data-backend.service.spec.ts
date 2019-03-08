import { TestBed, inject } from '@angular/core/testing';

import { DataBackendServiceService } from './data-backend.service';

describe('DataBackendServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DataBackendServiceService]
    });
  });

  it('should be created', inject([DataBackendServiceService], (service: DataBackendServiceService) => {
    expect(service).toBeTruthy();
  }));
});
