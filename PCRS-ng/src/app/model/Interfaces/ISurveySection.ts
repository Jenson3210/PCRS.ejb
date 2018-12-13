import { ISurveySectionDefinitionImpl } from './ISurveySectionDefinitionImpl';
import { IRating } from './IRating';

export interface ISurveySection {
  id: number;
  surveySectionDefinition: ISurveySectionDefinitionImpl;
  ratings: IRating[];
}
