import { ISurvey } from './ISurvey';


export interface ISurveySet {
  id: number;
  surveyList: ISurvey[];
  surveyYear: Date;
}
