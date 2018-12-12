import { Privilege } from './Privilege';

export interface IUser {
    id: number;
    firstName: string;
    lastName: string;
    country: string;
    email: string;
    password: string;
    privileges: Privilege[];
    shortName: string;
}
