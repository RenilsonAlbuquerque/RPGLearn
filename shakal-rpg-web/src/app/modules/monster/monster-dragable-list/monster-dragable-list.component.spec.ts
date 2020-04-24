import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MonsterDragableListComponent } from './monster-dragable-list.component';

describe('MonsterDragableListComponent', () => {
  let component: MonsterDragableListComponent;
  let fixture: ComponentFixture<MonsterDragableListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MonsterDragableListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MonsterDragableListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
