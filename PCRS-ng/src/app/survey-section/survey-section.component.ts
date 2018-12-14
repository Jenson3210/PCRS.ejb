import { Component, OnInit, Input } from '@angular/core';
import { SurveyKind } from '../model/survey-kind.enum';
import { ISurveySection } from '../model/Interfaces/ISurveySection';

@Component({
  selector: 'app-survey-section',
  templateUrl: './survey-section.component.html',
  styleUrls: ['./survey-section.component.css']
})
export class SurveySectionComponent implements OnInit {
  @Input()
  surveySection: ISurveySection;
  @Input()
  surveyKind: SurveyKind;
  levelWidth: number;

  constructor() {
  }

  ngOnInit() {
    let width: number;
    width = 45;
    if (this.surveySection.surveySectionDefinition.surveySectionDefinitionBo.surveySectionStrategy.energyRated) {
      width = width - 10;
    }
    if (this.surveySection.surveySectionDefinition.surveySectionDefinitionBo.surveySectionStrategy.interestRated) {
      width = width - 10;
    }
    if (this.surveyKind === SurveyKind.Consensus) {
      width = width - 5;
    }
    this.levelWidth =  width / this.surveySection.surveySectionDefinition.surveySectionDefinitionBo.surveySectionStrategy.amountOfLevels;
  }

  arrayCreator(n: number) {
    const numbers: Array<number> = new Array<number>(n);
    return numbers;
  }
  isConsensus() {
    let consensus = false;
    if (this.surveyKind === SurveyKind.Consensus) {
      consensus = true;
    }
    return consensus;
  }
}
