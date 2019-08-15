import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StoryCreateComponent } from './story-create.component';

describe('StoryCreateComponent', () => {
  let component: StoryCreateComponent;
  let fixture: ComponentFixture<StoryCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StoryCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StoryCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
