import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MonsterSearchCardComponent } from './monster-search-card.component';

describe('MonsterSearchCardComponent', () => {
  let component: MonsterSearchCardComponent;
  let fixture: ComponentFixture<MonsterSearchCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MonsterSearchCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MonsterSearchCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
