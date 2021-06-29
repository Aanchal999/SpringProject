import { TestBed } from '@angular/core/testing';

import { DetasharingService } from './detasharing.service';

describe('DetasharingService', () => {
  let service: DetasharingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DetasharingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
