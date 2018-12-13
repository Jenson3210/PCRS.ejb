import { ISurveySectionDefinition } from './ISurveySectionDefinition';
import { SurveySectionRequirementLevel } from '../SurveySectionRequirementLevel.enum';

export interface ISurveySectionDefinitionImpl {
  id: number;
  surveySectionRequirementLevel: SurveySectionRequirementLevel;
  surveySectionDefinitionBo: ISurveySectionDefinition;
}
