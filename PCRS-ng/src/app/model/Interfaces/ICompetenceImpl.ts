import { ICompetence } from './ICompetence';

export interface ICompetenceImpl {
  id: number;
  name: String;
  competenceDescription: String;
  minLevel: number;
  competence: ICompetence;
}
