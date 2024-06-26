import { Component } from '@angular/core';
import { UsuarioService } from '../usuario.service';
import { Usuario } from '../usuario';
import { Juego } from '../juego';
import { JuegoService } from '../juego.service';
import { BusquedaService } from '../busqueda.service';
import { Genero } from '../genero';
import { GeneroService } from '../genero.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-busqueda',
  templateUrl: './busqueda.component.html',
  styleUrl: './busqueda.component.css'
})
export class BusquedaComponent {
  nombrePag = 'Virtual Vault'
  noticias = 'Noticias'
  tienda = 'Tienda'
  soporte = 'Soporte'
  acerca = 'Nosotros'
  destacado = 'Destacado'
  ofertas = 'Ofertas'
  eventos = 'Festi Juegos'
  free = "Juegos Gratuitos"
  USUARIO = 'USUARIO'
  usuarioRegistrado: Usuario | null = null;
  textoBusqueda: string = '';
  juegos: Juego[];
  genero_id: number;
  generos: Genero[];

  constructor(private router: Router ,private generoService: GeneroService, private usuarioService: UsuarioService, private juegoService: JuegoService, private busquedaService: BusquedaService) {
  this.genero_id;
  }

  isHovered = false;

  toRedirect(juego: Juego){
    this.router.navigate(['/game']);
    console.log("redireccion", juego);
    this.juegoService.setQuery(juego);
  }

  toggleHover() {
    this.isHovered = !this.isHovered;
  }
  dropdownVisible = false;

  consultar(): void{
    this.juegoService.consultarJuegoCaracter(this.textoBusqueda).subscribe(response => {
        console.log(this.textoBusqueda);
        console.log('busqueda:', response);
        this.juegos = response; 
        console.log('links:', this.juegos)
    });
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
  this.busquedaService.getQuery().subscribe(query => {
    this.textoBusqueda = query;
    this.consultar();
  });
  }
  


  toggleDropdown() {
    this.dropdownVisible = !this.dropdownVisible;
  }

  
}
