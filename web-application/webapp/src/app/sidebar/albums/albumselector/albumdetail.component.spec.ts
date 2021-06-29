import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumselectorComponent } from './albumselector.component';

describe('AlbumselectorComponent', () => {
  let component: AlbumselectorComponent;
  let fixture: ComponentFixture<AlbumselectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlbumselectorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlbumselectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
