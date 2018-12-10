import { Component, OnInit } from '@angular/core';
import { Survey } from '../model/survey';
import { EnergyOrInterestOption } from '../model/energy-or-interest-option.enum';
import { SurveyService } from '../service/survey.service';

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
  styleUrls: ['./survey.component.css']
})
export class SurveyComponent implements OnInit {
  survey: Survey;

  constructor(public surveyService: SurveyService) {}

  ngOnInit() {
    
    this.surveyService.testFakeUrl().subscribe(
      x => {
        console.log("observable :" + JSON.stringify(x));
      }
    );
    this.survey = this.surveyService.getSurveyForUser();
  }

  finished() {
    let finished = true;
    for (const surveySection of this.survey.surveySections) {
      if (finished) {
        for (const rating of surveySection.ratings) {
          if (finished) {
            if (rating.level == null) {
              finished = false;
            }
            if (surveySection.surveySectionDefinition.surveySectionDefinition.surveySectionStrategy.energyRated) {
              if (rating.energy == null) {
                finished = false;
              }
            }
            if (surveySection.surveySectionDefinition.surveySectionDefinition.surveySectionStrategy.interestRated) {
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
    this.survey.dateCompleted = new Date();
    this.saveSurvey();
  }
  saveSurvey() {
    this.surveyService.save(this.survey);
    for (const surveySection of this.survey.surveySections) {
      for (const rating of surveySection.ratings) {
        console.log(rating);
        console.log(EnergyOrInterestOption[rating.energy] + 'energy');
      }
    }
  }
}
