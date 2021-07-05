import { IdName } from "./id-name";


export class UserModel {
    id:string;
    name:string;
    eMail:string;
    phoneNo: string;
    roles:Array<IdName>;
    
    constructor( ){ 
    }
}
