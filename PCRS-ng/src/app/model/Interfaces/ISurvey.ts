import { ISurveySection } from './ISurveySection';
import { SurveyKind } from '../survey-kind.enum';

export interface ISurvey {
  id: number;
  surveyKind: SurveyKind;
  dateCompleted: Date;
  surveySections: ISurveySection[];
}
