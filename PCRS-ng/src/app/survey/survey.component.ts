import { Component, OnInit } from '@angular/core';
import { Survey } from '../model/survey';
import { EnergyOrInterestOption } from '../model/energy-or-interest-option.enum';
import { SurveyService } from '../service/survey.service';
import { User } from '../model/newModel/User';
import { UserClass } from '../model/newModel/UserClass';

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
  styleUrls: ['./survey.component.css']
})
export class SurveyComponent implements OnInit {
  survey: Survey;
  users: User[];

  constructor(public surveyService: SurveyService) {}

  ngOnInit() {
    this.surveyService.testFakeUrl().subscribe(
      x => {
        this.users = x;
        console.log("Users: " + JSON.stringify(this.users));
        let u2 : UserClass = new UserClass(this.users[0]);
        console.log(u2);
        //u.calculate();
        u2.calculate();
        //console.log(this.users[0].calculate());
        
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
