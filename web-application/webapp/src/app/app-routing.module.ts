import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './common/dashboard/dashboard.component';
import { UserloginComponent } from './loginpage/userlogin/userlogin.component';
import { UserregisterComponent } from './loginpage/userregister/userregister.component';
import { AdminsComponent } from './sidebar/admins/admins.component';
import { AlbumsComponent } from './sidebar/albums/albums.component';
import { PlaylistsComponent } from './sidebar/playlists/playlists.component';
import { SingersComponent } from './sidebar/singers/singers.component';
import { UsersComponent } from './sidebar/users/users.component';

const routes: Routes = [
  { path: 'userregister', component: UserregisterComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'songs', component: DashboardComponent },
  { path: 'singers', component: SingersComponent },
  { path: 'albums', component: AlbumsComponent },
  { path: 'users', component: UsersComponent },
  { path: 'admins', component: AdminsComponent },
  { path: 'playlists', component: PlaylistsComponent },
  { path: '**', component: UserloginComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [
  UserloginComponent,
]