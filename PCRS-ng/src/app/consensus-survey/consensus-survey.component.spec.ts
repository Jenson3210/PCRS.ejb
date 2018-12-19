import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import {  ConsensusSurveyComponent } from './consensus-survey.component';

describe('SurveyComponent', () => {
  let component: ConsensusSurveyComponent;
  let fixture: ComponentFixture<ConsensusSurveyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConsensusSurveyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsensusSurveyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
