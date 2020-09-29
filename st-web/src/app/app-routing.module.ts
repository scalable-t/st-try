import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
<<<<<<< HEAD
import { AuthGuard } from './core/auth/auth.guard';
import { HomeComponent } from './manage/home/home.component';
import { LayoutComponent } from './manage/layout/layout.component';
import { LoginComponent } from './pub/login/login.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'manage', component: LayoutComponent, canActivate: [AuthGuard], children: [
    { path: 'home', component: HomeComponent },
  ] },
];
=======

const routes: Routes = [];
>>>>>>> 11cf9df0a2440ebc8ff4178764bbcec158436da0

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
