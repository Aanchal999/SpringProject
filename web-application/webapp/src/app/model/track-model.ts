import { IdName } from "./id-name";

export class TrackModel {
    id:string;
    name:string;
    mediaType:string;
    mediaFormat: string;
    dateOfRelease:string;
    path:string;
    album:IdName;
    playlists: Array<IdName>;
    singers: Array<IdName>;
 
    constructor(  

        album:IdName,
        playlists: Array<IdName>,
        singers: Array<IdName>,
         ){
        this.album= album;
        this.playlists= playlists;
        this.singers=singers;      
    }
}
