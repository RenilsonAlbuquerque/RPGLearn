import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StoryDetailPlayerComponent } from './story-detail-player.component';

describe('StoryDetailPlayerComponent', () => {
  let component: StoryDetailPlayerComponent;
  let fixture: ComponentFixture<StoryDetailPlayerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StoryDetailPlayerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StoryDetailPlayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
