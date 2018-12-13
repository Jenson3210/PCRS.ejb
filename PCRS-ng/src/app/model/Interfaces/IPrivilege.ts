import { ISurveyDefinition } from './ISurveyDefinition';
import { ISurveySet } from './ISurveySet';
import { PrivilegeType } from '../PrivilegeType.enum';

export interface IPrivilege {
  active: boolean;
  id: number;
  privilegeType: PrivilegeType;
  surveyDefinition: ISurveyDefinition;
  surveySetTreeSet: ISurveySet[];
}
