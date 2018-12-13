import { IPrivilege } from './IPrivilege';

export interface IUser {
    id: number;
    firstName: string;
    lastName: string;
    country: string;
    email: string;
    password: string;
    privileges: IPrivilege[];
    shortName: string;
}
