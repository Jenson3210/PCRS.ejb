import { Component, OnInit } from '@angular/core';
import { EnergyOrInterestOption } from '../model/energy-or-interest-option.enum';
import { SurveyService } from '../service/survey.service';
import { ISurvey } from '../model/Interfaces/ISurvey';
import { SurveyKind } from '../model/survey-kind.enum';
import { UserService } from '../service/user.service';
import { Router, ActivatedRoute } from '@angular/router';
import { IAlert } from '../model/Interfaces/IAlert';
import { AlertType } from '../model/alert-type.enum';
import { IUser } from '../model/Interfaces/IUser';

@Component({
  selector: 'app-managersurvey',
  templateUrl: './manager-survey.component.html',
  styleUrls: ['./manager-survey.component.css']
})
export class ManagerSurveyComponent implements OnInit {
  survey$: ISurvey;
  private errors: IAlert[];
  subjectUser: IUser;

  constructor(public surveyService: SurveyService, private userService: UserService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit() {
    this.errors = [];
    console.log(this.route.snapshot.queryParamMap);
    this.userService.getUserById(this.route.snapshot.queryParamMap.get("userId")).subscribe(
      x => {
        this.subjectUser = x.body[0];
        
        this.surveyService.getSurveyForUser(this.subjectUser, SurveyKind.TeamManager).subscribe(
          x => {
            this.survey$ = x.body;
          },
          (error) => {
            switch (error.status) {
              case 404: {
                this.errors.push({message: error.error, type: AlertType.DANGER});
                break;
              }
              default: {
                this.errors.push({message: error.error, type: AlertType.DANGER});
                break;
              }
            }
          }
        );
      },
      (error) => {
        switch (error.status) {
          case 404: {
            this.errors.push({message: error.error, type: AlertType.DANGER});
            break;
          }
          default: {
            this.errors.push({message: error.error, type: AlertType.DANGER});
            break;
          }
        }
      }
    );
  }

  finished(): boolean {
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
    this.survey$.dateCompleted = (new Date()).toISOString().substring(0, 10);
    this.saveSurvey();
    this.router.navigate(['survey']);
  }
  saveSurvey() {
    this.surveyService.save(this.survey$);
  }
}
