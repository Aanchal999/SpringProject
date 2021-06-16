import { IdName } from "./id-name";

export class SingerModel {
    id:string;
    name:string;
    gender:string;
    nationality:string;
    tracks:Array<IdName>;
    

    constructor(  
        tracks:Array<IdName>){
        this.tracks=tracks;

    }
}
