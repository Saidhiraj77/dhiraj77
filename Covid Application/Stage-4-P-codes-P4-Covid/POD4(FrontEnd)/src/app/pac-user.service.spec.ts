import { TestBed } from '@angular/core/testing';

import { PacUserService } from './pac-user.service';

describe('PacUserService', () => {
  let service: PacUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PacUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
