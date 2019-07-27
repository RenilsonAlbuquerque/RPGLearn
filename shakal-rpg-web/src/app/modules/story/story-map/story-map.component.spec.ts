import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StoryMapComponent } from './story-map.component';

describe('StoryMapComponent', () => {
  let component: StoryMapComponent;
  let fixture: ComponentFixture<StoryMapComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StoryMapComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StoryMapComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
