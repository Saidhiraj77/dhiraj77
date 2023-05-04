import { TestBed } from '@angular/core/testing';

import { PayBookService } from './pay-book.service';

describe('PayBookService', () => {
  let service: PayBookService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PayBookService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
