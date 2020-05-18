import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GridBoardComponent } from './grid-board.component';

describe('GridBoardComponent', () => {
  let component: GridBoardComponent;
  let fixture: ComponentFixture<GridBoardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GridBoardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GridBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
