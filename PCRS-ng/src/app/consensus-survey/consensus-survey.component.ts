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
  selector: 'app-consensussurvey',
  templateUrl: './consensus-survey.component.html',
  styleUrls: ['./consensus-survey.component.css']
})
export class ConsensusSurveyComponent implements OnInit {
  survey$: ISurvey = {} as ISurvey;
  private errors: IAlert[];
  subjectUser: IUser;
  userSurvey: ISurvey = {} as ISurvey;
  managerSurvey: ISurvey = {} as ISurvey;

  constructor(public surveyService: SurveyService, private userService: UserService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit() {
    this.errors = [];
    this.userService.getUserById(this.route.snapshot.queryParamMap.get("userId")).subscribe(
      x => {
        this.subjectUser = x.body[0];
        
        this.setSurvey(this.survey$, SurveyKind.Consensus);
        this.setSurvey(this.userSurvey, SurveyKind.TeamMember);
        this.setSurvey(this.managerSurvey, SurveyKind.TeamManager);
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

  setSurvey(target: ISurvey, kind: SurveyKind) {
    this.surveyService.getSurveyForUser(this.subjectUser, kind).subscribe(
      x => {
        target.id = x.body.id;
        target.dateCompleted = x.body.dateCompleted;
        target.surveyKind = x.body.surveyKind;
        target.surveySections = x.body.surveySections;
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
}
