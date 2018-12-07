import { Component, OnInit, Input } from '@angular/core';
import { Survey } from '../model/survey';

@Component({
  selector: 'app-survey-overview',
  templateUrl: './survey-overview.component.html',
  styleUrls: ['./survey-overview.component.css']
})
export class SurveyOverviewComponent implements OnInit {

  @Input()
  survey: Survey;


  constructor() { }

  ngOnInit() {
  }

}
