import { IdName } from "./id-name";

export class Track {
    id:string;
    name:string;
    mediaType:string;
    mediaFormat: string;
    dateOfRelease:string;
    path:string;
    album:IdName;
    playlists: Array<IdName>;
    singers: Array<IdName>;
 
    constructor(){};
}
