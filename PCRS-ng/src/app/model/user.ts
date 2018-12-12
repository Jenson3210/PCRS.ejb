import { IUser } from 'src/app/model/newModel/User';
export class User {

  id: number;
  firstName: string;
  lastName: string;

  constructor(user: IUser) {
    this.id = user.id;
  }

}
