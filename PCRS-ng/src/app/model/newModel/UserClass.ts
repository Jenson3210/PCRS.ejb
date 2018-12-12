import { User } from 'src/app/model/newModel/User';


export class UserClass {
    
    constructor(public user: User){}

    calculate(){
        console.log("***" + this.user.email);
    }
}