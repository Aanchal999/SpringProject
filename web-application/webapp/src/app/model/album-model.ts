import { IdName } from "./id-name";

export class AlbumModel {
    id:string;
    name:string; 
    tracks:Array<IdName>;

    constructor( 
        tracks:Array<IdName> ){        
        

    }
}