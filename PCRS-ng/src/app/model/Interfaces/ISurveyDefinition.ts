import { ISurveySectionDefinitionImpl } from './ISurveySectionDefinitionImpl';


export interface ISurveyDefinition {
  country: String;
  function: String;
  id: number;
  operatingUnit: String;
  surveySections: ISurveySectionDefinitionImpl[];
}
