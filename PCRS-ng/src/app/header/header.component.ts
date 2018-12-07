import { Component, OnInit } from '@angular/core';
import { User } from '../model/user';
import { SurveySet } from '../model/survey-set';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public user: User;
  public surveySets: Array<SurveySet> = new Array<SurveySet> ();

  constructor() { }

  ngOnInit() {
    this.user = new User();
    this.user.firstName = 'Laura';
    this.user.lastName = 'Lynn';
    this.user.id = 3;
    const surveySet: SurveySet = new SurveySet();
    surveySet.id = 2;
    surveySet.surveyYear = new Date(2017, 2, 12);
    this.surveySets.push(surveySet);
    const surveySet2: SurveySet = new SurveySet();
    surveySet2.id = 3;
    surveySet2.surveyYear = new Date(2016, 2, 12);
    this.surveySets.push(surveySet2);
    const surveySet3: SurveySet = new SurveySet();
    surveySet3.id = 4;
    surveySet3.surveyYear = new Date(2015, 2, 12);
    this.surveySets.push(surveySet3);
  }

}
