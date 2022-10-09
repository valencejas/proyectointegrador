import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NueveeducacionComponent } from './componets/educacion/nueveeducacion.component';
import { HomeComponent } from './componets/home/home.component';
import { LoginComponent } from './componets/login/login.component';

const routes: Routes = [
  {path: '' , component: HomeComponent},
  {path: 'login' , component: LoginComponent},
  {path: 'nuevaeducacion', component: NueveeducacionComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
