import { IdName } from "./id-name";

export class PlaylistModel {
   
    id:string;
    name:string;
    tracks:Array<IdName>;
    user:IdName;

    constructor(  
        tracks:Array<IdName>,
        user:IdName){
        this.tracks=tracks;
        this.user= user;
    }
}
