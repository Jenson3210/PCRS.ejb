import { ICompetenceLevel } from './ICompetenceLevel';

export interface ICompetence {
  id: number;
  name: String;
  competenceDescription: String;
  competenceLevels: ICompetenceLevel[];
}
