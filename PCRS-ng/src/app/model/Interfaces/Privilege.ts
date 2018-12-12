import { SurveyDefinition } from './SurveyDefinition';

export interface Privilege {
    active: boolean;
    id: number;
    privilegeType: string;
    surveyDefinition: SurveyDefinition;
    //surveySetTreeSet: SurveySet[];
}