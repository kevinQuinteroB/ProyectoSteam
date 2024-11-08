import { Component } from '@angular/core';
import { UsuarioService } from '../services/usuario.service';
import { Usuario } from '../models/usuario';
import { Router } from '@angular/router';
import { BusquedaService } from '../services/busqueda.service';
import { GeneroService } from '../services/genero.service';
import { Genero } from '../models/genero';

@Component({
  selector: 'app-tienda',
  templateUrl: './tienda.component.html',
  styleUrl: './tienda.component.css'
})
export class TiendaComponent {
  nombrePag = 'Virtual Vault'
  noticias = 'Noticias'
  tienda = 'Tienda'
  soporte = 'Soporte'
  acerca = 'Nosotros'
  destacado = 'Destacado'
  ofertas = 'Otros destacados'
  eventos = 'Eventos'
  free = "Dales una oportunidad"
  USUARIO = 'USUARIO'
  usuarioRegistrado: Usuario | null = null;
  textoBusqueda: string = '';
  genero_id: number;
  generos: Genero[];

  isHovered = false;

  toggleHover() {
    this.isHovered = !this.isHovered;
  }
  
  constructor(private usuarioService: UsuarioService, private router: Router, private busquedaService: BusquedaService, private generoService: GeneroService) {
    this.genero_id;
  }

  dropdownVisible = false;

  consultar(){
    this.router.navigate(['/busqueda']);
    this.busquedaService.setQuery(this.textoBusqueda);
  }

  ngOnInit(): void {
    this.generoService.obtenerGeneros().subscribe(generos =>{
      this.generos = generos;
    })
    this.usuarioRegistrado = this.usuarioService.getUsuarioRegistrado();
    console.log(this.usuarioRegistrado);
    if (this.usuarioRegistrado) {
      this.USUARIO = this.usuarioRegistrado.username;
      console.log(this.usuarioRegistrado.username);
    }
  }
  
  toggleDropdown() {
    this.dropdownVisible = !this.dropdownVisible;
  }
}
