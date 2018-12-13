import { Component, OnInit } from '@angular/core';
import { IUser } from '../model/Interfaces/IUser';
import { ISurveySet } from '../model/Interfaces/ISurveySet';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public user = {} as IUser;
  public surveySets: ISurveySet[] = [];

  constructor() { }

  ngOnInit() {
    this.user.firstName = 'Laura';
    this.user.lastName = 'Lynn';
    this.user.id = 3;
    const surveySet = {} as ISurveySet;
    surveySet.id = 2;
    surveySet.surveyYear = new Date(2017, 2, 12);
    this.surveySets.push(surveySet);
    const surveySet2 = {} as ISurveySet;
    surveySet2.id = 3;
    surveySet2.surveyYear = new Date(2016, 2, 12);
    this.surveySets.push(surveySet2);
    const surveySet3 = {} as ISurveySet;
    surveySet3.id = 4;
    surveySet3.surveyYear = new Date(2015, 2, 12);
    this.surveySets.push(surveySet3);
  }

}
