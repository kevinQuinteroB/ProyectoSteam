import { Component } from '@angular/core';
import { UsuarioService } from '../services/usuario.service';
import { Usuario } from '../models/usuario';
import { JuegoService } from '../services/juego.service';
import { BusquedaService } from '../services/busqueda.service';
import { GeneroService } from '../services/genero.service';
import { Genero } from '../models/genero';
import { JuegoGeneroService } from '../services/juego-genero.service';
import { JuegoGenero } from '../models/juego-genero';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-juego',
  templateUrl: './juego.component.html',
  styleUrl: './juego.component.css'
})
export class JuegoComponent {
  nombrePag = 'Virtual Vault'
  noticias = 'Noticias'
  tienda = 'Tienda'
  soporte = 'Soporte'
  acerca = 'Nosotros'

  USUARIO = 'USUARIO'
  usuarioRegistrado: Usuario | null = null;

  constructor(private juegosGeneroService: JuegoGeneroService ,private generoService: GeneroService, private usuarioService: UsuarioService, private jugoService: JuegoService, private busquedaService: BusquedaService){

  }

    id: number
    nombre: string
    fecha_lanzamiento: Date
    portada: string
    valoracion: number
    desarrollador_id: number
    descuento: number
    precio: number
    descripcion: string
    preciofinal: number
    juegosGenero: JuegoGenero[] = [];
    generos: Genero[] = [];

  ngOnInit(){
     this.jugoService.getQuery().subscribe(query => {
      this.id = query.id;
      this.nombre = query.nombre;
      this.fecha_lanzamiento = query.fecha_lanzamiento;
      this.portada = query.portada;
      this.valoracion = query.valoracion;
      this.desarrollador_id = query.desarrollador_id;
      this.descuento = query.descuento;
      this.precio = query.precio;
      this.descripcion = query.descripcion;
      this.preciofinal = this.precio-((this.descuento/100)*this.precio)
      console.log(query)
    });

    this.juegosGeneroService.consultarGeneroJuego(this.id).subscribe(response => {
      this.juegosGenero = response;

    let observables = this.juegosGenero.map(juegoGenero => this.generoService.obtenerGenero(juegoGenero.id_Genero));

    forkJoin(observables).subscribe(results => { 

    this.generos = results as Genero[];
    console.log(this.generos)

    

    });
    }); 
    
  }

  isHovered = false;
  dropdownVisible = false;

  toggleHover() {
    this.isHovered = !this.isHovered;
  }

  toggleDropdown() {
    this.dropdownVisible = !this.dropdownVisible;
  }
  
}
