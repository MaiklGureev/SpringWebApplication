import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompRightNormComponent } from './comp-right-norm.component';

describe('CompRightNormComponent', () => {
  let component: CompRightNormComponent;
  let fixture: ComponentFixture<CompRightNormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompRightNormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CompRightNormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
