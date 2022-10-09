import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './componets/header/header.component';
import { LogoComponent } from './componets/logo/logo.component';
import { BanerComponent } from './componets/baner/baner.component';
import { RedesComponent } from './componets/redes/redes.component';
import { AcercadeComponent } from './componets/acercade/acercade.component';
import { ProyectosComponent } from './componets/proyectos/proyectos.component';
import { EducacionComponent } from './componets/educacion/educacion.component';
import { FooterComponent } from './componets/footer/footer.component';
import { NgCircleProgressModule } from 'ng-circle-progress';
import {HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './componets/home/home.component';
import { LoginComponent } from './componets/login/login.component';
import { interceptorProvider } from './servicio/interceptor-service';
import { FormsModule } from '@angular/forms';
import { HabComponent } from './componets/hab/hab.component';
import { NueveeducacionComponent } from './componets/educacion/nueveeducacion.component';
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    LogoComponent,
    BanerComponent,
    RedesComponent,
    AcercadeComponent,
    ProyectosComponent,
    EducacionComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    HabComponent,
    NueveeducacionComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule,
    FormsModule,
  ],
  providers: [
    interceptorProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

