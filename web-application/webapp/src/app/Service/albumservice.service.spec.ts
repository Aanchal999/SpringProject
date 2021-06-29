import { TestBed } from '@angular/core/testing';

import { AlbumserviceService } from './albumservice.service';

describe('AlbumserviceService', () => {
  let service: AlbumserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AlbumserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
