import { Component, OnInit, Input } from '@angular/core';
import { SurveySection } from '../model/survey-section';
import { SurveyKind } from '../model/survey-kind.enum';

@Component({
  selector: 'app-survey-section',
  templateUrl: './survey-section.component.html',
  styleUrls: ['./survey-section.component.css']
})
export class SurveySectionComponent implements OnInit {
  @Input()
  surveySection: SurveySection;
  @Input()
  surveyKind: SurveyKind;
  levelWidth: number;

  constructor() {
  }

  ngOnInit() {
    let width: number;
    width = 35;
    if (this.surveySection.surveySectionDefinition.surveySectionDefinition.surveySectionStrategy.energyRated) {
      width = width - 10;
    }
    if (this.surveySection.surveySectionDefinition.surveySectionDefinition.surveySectionStrategy.interestRated) {
      width = width - 10;
    }
    if (this.surveyKind === SurveyKind.CONSENSUS) {
      width = width - 5;
    }
    this.levelWidth =  width / this.surveySection.surveySectionDefinition.surveySectionDefinition.surveySectionStrategy.amountOfLevels;
  }

  arrayCreator(n: number) {
    const numbers: Array<number> = new Array<number>(n);
    return numbers;
  }
  isConsensus() {
    let consensus = false;
    if (this.surveyKind === SurveyKind.CONSENSUS) {
      consensus = true;
    }
    return consensus;
  }
}
