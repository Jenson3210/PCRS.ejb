export interface ISurveySectionStrategy {
  id: number;
  amountOfLevels: number;
  energyRated: boolean;
  interestRated: boolean;
  name: String;
  descriptionRequired: boolean;
  hasMinimumLevel: boolean;
  flexibleDescription: boolean;
}
