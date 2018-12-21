import { Component, OnInit, Input } from '@angular/core';
import { SurveyKind } from '../model/survey-kind.enum';
import { ISurveySection } from '../model/Interfaces/ISurveySection';
import { ISurvey } from '../model/Interfaces/ISurvey';
import { ISurveySet } from '../model/Interfaces/ISurveySet';
import { IRating } from '../model/Interfaces/IRating';
import { EnergyOrInterestOption } from '../model/energy-or-interest-option.enum';

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
  @Input()
  userSurvey: ISurvey;
  @Input()
  managerSurvey: ISurvey;
  levelWidth: number;
  energyOrInterestOption = EnergyOrInterestOption;

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
    if (SurveyKind[this.surveyKind] == SurveyKind.Consensus.toString()) {
      consensus = true;
    }
    return consensus;
  }

  userSelected(rating: IRating) {
    return this.findRating(rating, this.userSurvey).level;
  }
  managerSelected(rating: IRating) {
    return this.findRating(rating, this.managerSurvey).level;
  }
  findRating(rating: IRating, survey: ISurvey): IRating {
    let r: IRating = {} as IRating;
    let found = false;
    for(let section of survey.surveySections) {
      if (!found) {
        for (let rat of section.ratings){
          if (rat.competence.id == rating.competence.id) {
            r = rat;
            found = true;
          }
        }
      }
    }
    return r;
  }
}
