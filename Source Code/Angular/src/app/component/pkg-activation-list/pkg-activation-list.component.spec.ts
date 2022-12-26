import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PkgActivationListComponent } from './pkg-activation-list.component';

describe('PkgActivationListComponent', () => {
  let component: PkgActivationListComponent;
  let fixture: ComponentFixture<PkgActivationListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PkgActivationListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PkgActivationListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
