import {ComponentFixture, TestBed} from '@angular/core/testing';

import {ServiceClassComponent} from './service-class.component';

describe('ServiceClassComponent', () => {
  let component: ServiceClassComponent;
  let fixture: ComponentFixture<ServiceClassComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ServiceClassComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceClassComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
