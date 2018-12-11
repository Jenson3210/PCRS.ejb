import { Privilege } from './Privilege';

export interface User {
    id: number;
    firstName: string;
    lastName: string;
    country: string;
    email: string;
    password: string;
    privileges: Privilege[];
    shortName: string;
}