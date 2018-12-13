import { ICompetenceImpl } from './ICompetenceImpl';
import { EnergyOrInterestOption } from '../energy-or-interest-option.enum';

export interface IRating {
  id: number;
  level: number;
  energy: EnergyOrInterestOption;
  interest: EnergyOrInterestOption;
  competence: ICompetenceImpl;
  comment: String;
}
