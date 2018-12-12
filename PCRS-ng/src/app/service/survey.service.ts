import { Injectable, OnInit } from '@angular/core';
import { Survey } from '../model/survey';
import { SurveyKind } from '../model/survey-kind.enum';
import { SurveySection } from '../model/survey-section';
import { SurveySectionDefinitionImpl } from '../model/survey-section-definition-impl';
import { SurveySectionDefinition } from '../model/survey-section-definition';
import { SurveySectionStrategy } from '../model/survey-section-strategy';
import { SurveySectionTitle } from '../model/survey-section-title';
import { Rating } from '../model/rating';
import { CompetenceImpl } from '../model/competence-impl';
import { Competence } from '../model/competence';
import { CompetenceLevel } from '../model/competence-level';
import { EnergyOrInterestOption } from '../model/energy-or-interest-option.enum';
import { ConsensusRating } from '../model/consensus-rating';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { User } from '../model/newModel/User';
import { UserClass } from '../model/newModel/UserClass';

@Injectable()
export class SurveyService {
  
  private testUrl: string = "PCRS-api/rest/v1/users";

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
   
  }

  testFakeUrl(): Observable<User[]> {
    return this.http.get<User[]>(this.testUrl).pipe(
      tap(x => console.log(x))
    );
  }

  save(survey: Survey) {

  }

  getSurveyForUser(): Survey {
    const survey: Survey = new Survey();
    survey.id = 5;
    survey.surveyKind = SurveyKind.CONSENSUS;
    //
    /* dummy section 1 */
    const surveySection1: SurveySection = new SurveySection();
    surveySection1.id = 1;
    const surveySectionDefinitionImpl1: SurveySectionDefinitionImpl = new SurveySectionDefinitionImpl();
    surveySectionDefinitionImpl1.id = 468;
    const surveySectionDefinition: SurveySectionDefinition = new SurveySectionDefinition();
    surveySectionDefinition.id = 4827;
    const surveySectionStrategy: SurveySectionStrategy = new SurveySectionStrategy();
    surveySectionStrategy.id = 4272;
    surveySectionStrategy.amountOfLevels = 4;
    surveySectionStrategy.interestRated = true;
    surveySectionStrategy.energyRated = true;
    surveySectionStrategy.flexibleDescription = true;
    surveySectionStrategy.hasMinimumLevel = false;
    surveySectionStrategy.descriptionRequired = true ;
    const surveySectionTitle: SurveySectionTitle = new SurveySectionTitle();
    surveySectionTitle.id = 137424;
    surveySectionTitle.title = 'Titel 1';
    surveySectionDefinition.surveySectionStrategy = surveySectionStrategy;
    surveySectionDefinition.surveySectionTitle = surveySectionTitle;
    surveySectionDefinitionImpl1.surveySectionDefinition = surveySectionDefinition;
    surveySection1.surveySectionDefinition = surveySectionDefinitionImpl1;

    //
    /*competences in titel 1*/
    const rating1: Rating = new Rating();

    const competenceLevel1: CompetenceLevel = new CompetenceLevel();
    competenceLevel1.id = 7;
    competenceLevel1.description = 'test description level 1';
    competenceLevel1.orderLevel = 1;

    const competenceLevel2: CompetenceLevel = new CompetenceLevel();
    competenceLevel2.id = 8;
    competenceLevel2.description = 'test description level 2';
    competenceLevel2.orderLevel = 2;

    const competenceLevel3: CompetenceLevel = new CompetenceLevel();
    competenceLevel3.id = 9;
    competenceLevel3.description = 'test description level 3';
    competenceLevel3.orderLevel = 3;

    const competenceLevel4: CompetenceLevel = new CompetenceLevel();
    competenceLevel4.id = 10;
    competenceLevel4.description = 'test description level 4';
    competenceLevel4.orderLevel = 4;

    const competence1: Competence = new Competence();

    competence1.competenceDescription = 'test description competence';
    competence1.competenceLevels.push(competenceLevel2);
    competence1.competenceLevels.push(competenceLevel3);
    competence1.competenceLevels.push(competenceLevel1);
    competence1.competenceLevels.push(competenceLevel4);
    competence1.id = 16854;
    competence1.name = 'test name';

    const competenceImpl1: CompetenceImpl = new CompetenceImpl();
    competenceImpl1.competence = competence1;
    competenceImpl1.competenceDescription = 'test description';
    competenceImpl1.id = 1835;
    competenceImpl1.minLevel = 2;


    rating1.competenceImpl = competenceImpl1;
    rating1.energy = EnergyOrInterestOption.NOIDEA;
    rating1.id = 134;
    rating1.level = 2;
    surveySection1.ratings.push(rating1);
    //
    /* dummy section 1 */
    const surveySection2: SurveySection = new SurveySection();
    surveySection2.id = 10;
    const surveySectionDefinitionImpl2: SurveySectionDefinitionImpl = new SurveySectionDefinitionImpl();
    surveySectionDefinitionImpl2.id = 48;
    const surveySectionDefinition2: SurveySectionDefinition = new SurveySectionDefinition();
    surveySectionDefinition2.id = 427;
    const surveySectionStrategy2: SurveySectionStrategy = new SurveySectionStrategy();
    surveySectionStrategy2.id = 422;
    surveySectionStrategy2.amountOfLevels = 4;
    surveySectionStrategy2.interestRated = true;
    surveySectionStrategy2.energyRated = false;
    surveySectionStrategy2.flexibleDescription = true;
    surveySectionStrategy2.hasMinimumLevel = false;
    surveySectionStrategy2.descriptionRequired = true ;
    const surveySectionTitle2: SurveySectionTitle = new SurveySectionTitle();
    surveySectionTitle2.id = 13424;
    surveySectionTitle2.title = 'Titel 2';
    surveySectionDefinition2.surveySectionStrategy = surveySectionStrategy2;
    surveySectionDefinition2.surveySectionTitle = surveySectionTitle2;
    surveySectionDefinitionImpl2.surveySectionDefinition = surveySectionDefinition2;
    surveySection2.surveySectionDefinition = surveySectionDefinitionImpl2;


    const rating2: Rating = new Rating();
    rating2.competenceImpl = competenceImpl1;
    rating2.id = 135;
    surveySection1.ratings.push(rating2);

    survey.surveySections.push(surveySection1);
    survey.surveySections.push(surveySection2);

    return survey;
  }
}
