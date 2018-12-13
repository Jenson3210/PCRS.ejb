import { Component, OnInit } from '@angular/core';
import { EnergyOrInterestOption } from '../model/energy-or-interest-option.enum';
import { SurveyService } from '../service/survey.service';
import { ISurvey } from '../model/Interfaces/ISurvey';
import { SurveyKind } from '../model/survey-kind.enum';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-survey',
  templateUrl: './survey.component.html',
  styleUrls: ['./survey.component.css']
})
export class SurveyComponent implements OnInit {
  survey$: ISurvey;

  constructor(public surveyService: SurveyService, private userService: UserService, private router: Router) {}

  ngOnInit() {
  this.surveyService.getSurveyForUser(this.userService.user, SurveyKind.TeamMember).subscribe(
    x => {
      this.survey$ = x.body;
    },
    (error) => {
      switch (error.status) {
        case 404: {
          this.router.navigate(['survey'], {
            queryParams: {
              error: 'no survey for user'
            }
          });
        }
      }
    }
  );
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
