import { SurveyKind } from './survey-kind.enum';
import { SurveySection } from './survey-section';

export class Survey {

  id: number;
  surveyKind: SurveyKind;
  dateCompleted: Date;
  surveySections: Array<SurveySection> = new Array<SurveySection>();

}
