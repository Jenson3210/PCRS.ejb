import { CompetenceImpl } from './competence-impl';
import { EnergyOrInterestOption } from './energy-or-interest-option.enum';

export class Rating {

  id: number;
  level: number;
  energy: EnergyOrInterestOption;
  interest: EnergyOrInterestOption;
  competenceImpl: CompetenceImpl;

  constructor() {}

  setLevel(l: number) {
    this.level = l;
  }
}
