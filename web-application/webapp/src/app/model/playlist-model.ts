import { IdName } from "./id-name";

export class PlaylistModel {
   
    id:String;
    name:string;
    tracks:Array<IdName>;
    user:String;

    constructor(  
        tracks:Array<IdName>,
        user:String){
        this.tracks=tracks;
        this.user= user;
    }
}
