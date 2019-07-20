import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MonsterSheetComponent } from './monster-sheet.component';

describe('MonsterSheetComponent', () => {
  let component: MonsterSheetComponent;
  let fixture: ComponentFixture<MonsterSheetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MonsterSheetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MonsterSheetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
