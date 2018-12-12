import { SurveyKind } from './survey-kind.enum';
import { SurveySection } from './survey-section';

export interface ISurvey {

  id: number;
  surveyKind: SurveyKind;
  dateCompleted: Date;
  surveySections: Array<SurveySection>;

}
