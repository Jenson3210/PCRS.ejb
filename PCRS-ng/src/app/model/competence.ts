import { CompetenceLevel } from './competence-level';

export class Competence {

  id: number;
  name: string;
  competenceDescription: string;
  competenceLevels: Array<CompetenceLevel> = new Array<CompetenceLevel>();

  constructor() {}

  getOrderedLevels() {
    return this.competenceLevels.sort((a, b) => (a.orderLevel > b.orderLevel) ? 1 : ((b.orderLevel > a.orderLevel) ? -1 : 0));
  }
}
