import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CouraselMovieComponent } from './courasel-movie.component';

describe('CouraselMovieComponent', () => {
  let component: CouraselMovieComponent;
  let fixture: ComponentFixture<CouraselMovieComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CouraselMovieComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CouraselMovieComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
