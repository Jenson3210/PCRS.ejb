import { Component, OnInit, Input } from '@angular/core';
import { ISurvey } from '../model/Interfaces/ISurvey';

@Component({
  selector: 'app-survey-overview',
  templateUrl: './survey-overview.component.html',
  styleUrls: ['./survey-overview.component.css']
})
export class SurveyOverviewComponent implements OnInit {

  @Input()
  survey: ISurvey;


  constructor() { }

  ngOnInit() {
  }

}
