import { Component, OnInit } from '@angular/core';
import { EnergyOrInterestOption } from '../model/energy-or-interest-option.enum';
import { SurveyService } from '../service/survey.service';
import { ISurvey } from '../model/Interfaces/ISurvey';
import { IUser } from '../model/Interfaces/IUser';
import { SurveyKind } from '../model/survey-kind.enum';

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
  styleUrls: ['./survey.component.css']
})
export class SurveyComponent implements OnInit {
  survey$: ISurvey;

  constructor(public surveyService: SurveyService) {}

  ngOnInit() {

  const user = {} as IUser;
  user.id = 8;
  this.surveyService.getSurveyForUserAPI(user, SurveyKind.TeamMember).subscribe(
    x => {
      this.survey$ = x;
  });

    // this.survey = this.surveyService.getSurveyForUser();
  }

  finished() {
    let finished = true;
    for (const surveySection of this.survey$.surveySections) {
      if (finished) {
        for (const rating of surveySection.ratings) {
          if (finished) {
            if (rating.level == null) {
              finished = false;
            }
            if (surveySection.surveySectionDefinition.surveySectionDefinitionBo.surveySectionStrategy.energyRated) {
              if (rating.energy == null) {
                finished = false;
              }
            }
            if (surveySection.surveySectionDefinition.surveySectionDefinitionBo.surveySectionStrategy.interestRated) {
              if (rating.interest == null) {
                finished = false;
              }
            }
          }
        }
      }
    }
    return finished;
  }

  submitSurvey() {
    this.survey$.dateCompleted = new Date();
    this.saveSurvey();
  }
  saveSurvey() {
    this.surveyService.save(this.survey$);
    for (const surveySection of this.survey$.surveySections) {
      for (const rating of surveySection.ratings) {
        console.log(rating);
        console.log(EnergyOrInterestOption[rating.energy] + 'energy');
        console.log(EnergyOrInterestOption[rating.interest] + 'interest');
      }
    }
  }
}
