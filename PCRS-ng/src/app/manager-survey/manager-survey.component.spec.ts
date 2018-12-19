import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import {  ManagerSurveyComponent } from './manager-survey.component';

describe('SurveyComponent', () => {
  let component: ManagerSurveyComponent;
  let fixture: ComponentFixture<ManagerSurveyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerSurveyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerSurveyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
