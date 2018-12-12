import { SurveyKind } from './survey-kind.enum';
import { SurveySection } from './survey-section';
import { ISurvey } from './isurvey';

export class Survey implements ISurvey{

  id: number;
  surveyKind: SurveyKind;
  dateCompleted: Date;
  surveySections: Array<SurveySection> = new Array<SurveySection>();

}
