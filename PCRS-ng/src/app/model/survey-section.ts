import { SurveySectionDefinitionImpl } from './survey-section-definition-impl';
import { Rating } from './rating';

export class SurveySection {

  id: number;
  surveySectionDefinition: SurveySectionDefinitionImpl;
  ratings: Array<Rating> = new Array<Rating>();

  constructor() {}
}
