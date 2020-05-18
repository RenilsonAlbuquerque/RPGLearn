import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MasterMenuControlComponent } from './master-menu-control.component';

describe('MasterMenuControlComponent', () => {
  let component: MasterMenuControlComponent;
  let fixture: ComponentFixture<MasterMenuControlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MasterMenuControlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MasterMenuControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
