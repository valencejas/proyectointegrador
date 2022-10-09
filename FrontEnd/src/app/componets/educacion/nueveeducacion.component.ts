import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { EducacionService } from 'src/app/servicio/educacion.service';

@Component({
  selector: 'app-nueveeducacion',
  templateUrl: './nueveeducacion.component.html',
  styleUrls: ['./nueveeducacion.component.css']
})
export class NueveeducacionComponent {
  nombreE!: string;
  descripcionE!: string;

  constructor(private educacionS: EducacionService, private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void{
    const educacion = new Educacion(this.nombreE, this.descripcionE);
    this.educacionS.save(educacion).subscribe(
      data =>{
        alert("educacion añadida");
        this.router.navigate(['']);
      }, err =>{
        alert("fallo")
        this.router.navigate(['']);
      }
          )
  }

}
