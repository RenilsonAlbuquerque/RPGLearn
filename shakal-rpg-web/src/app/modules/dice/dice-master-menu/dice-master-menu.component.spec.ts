import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiceMasterMenuComponent } from './dice-master-menu.component';

describe('DiceMasterMenuComponent', () => {
  let component: DiceMasterMenuComponent;
  let fixture: ComponentFixture<DiceMasterMenuComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiceMasterMenuComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiceMasterMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
