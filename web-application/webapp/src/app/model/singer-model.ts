export class SingerModel {
    id:String;
    name:String;
    gender:String;
    nationality:String;
    tracks:string;
    

    constructor(  
        id:String,
        gender:String,
        name:String,
        nationality:String,
        tracks:string){
        this.id=id;
        this.tracks=tracks;
        this.name=name;
        this.gender= gender;
        this.nationality= nationality;
       
    }
}
