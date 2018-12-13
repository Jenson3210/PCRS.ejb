import { ICompetenceImpl } from './ICompetenceImpl';
import { ISurveySectionTitle } from './ISurveySectionTitle';
import { ISurveySectionStrategy } from './ISurveySectionStrategy';

export interface ISurveySectionDefinition {
  id: number;
  surveySectionTitle: ISurveySectionTitle;
  surveySectionStrategy: ISurveySectionStrategy;
  administratorCreated: boolean;
  surveySectionCompetences: ICompetenceImpl;
}
