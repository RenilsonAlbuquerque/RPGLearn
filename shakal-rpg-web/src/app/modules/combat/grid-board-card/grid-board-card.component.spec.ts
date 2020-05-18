import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GridBoardCardComponent } from './grid-board-card.component';

describe('GridBoardCardComponent', () => {
  let component: GridBoardCardComponent;
  let fixture: ComponentFixture<GridBoardCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GridBoardCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GridBoardCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
