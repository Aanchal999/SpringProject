import { Component, Input, OnInit } from '@angular/core';
import { AlbumService } from 'src/app/Service/album.service';

@Component({
  selector: 'app-delete-album',
  templateUrl: './delete-album.component.html',
  styleUrls: ['./delete-album.component.scss']
})
export class DeleteAlbumComponent implements OnInit {

  constructor(private service: AlbumService) { 
    this.album={};
  }

  ngOnInit(): void {
    console.log(this.album);
  }
  
  @Input() album;
  @Input() id: number;

  deleteAlbum(){
    console.log(this.album.id);
    this.service.deleteAlbum(this.album.id)
    .subscribe((item) => {
      console.log("response: ", item);
    });
  }
}
