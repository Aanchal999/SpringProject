export class AlbumModel {

    id:String;
    name:string;
    tracks:string;

    constructor(   id:String,
        name:string,
        tracks:string ){
        this.id=id;
        this.tracks=tracks;
        this.name = name;
      
    }
}
