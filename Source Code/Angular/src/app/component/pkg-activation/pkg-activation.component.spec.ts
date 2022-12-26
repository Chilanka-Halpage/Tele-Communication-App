import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PkgActivationComponent } from './pkg-activation.component';

describe('PkgActivationComponent', () => {
  let component: PkgActivationComponent;
  let fixture: ComponentFixture<PkgActivationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PkgActivationComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PkgActivationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
