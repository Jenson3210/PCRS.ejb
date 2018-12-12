import { IUser } from 'src/app/model/newModel/User';


export class UserClass {
    
    constructor(public user: IUser){

    }

    calculate(){
        console.log("***" + this.user.email);
    }
}