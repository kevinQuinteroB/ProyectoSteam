import { Component } from '@angular/core';
import { UsuarioService } from '../usuario.service';
import { Usuario } from '../usuario';

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
  ofertas = 'Ofertas'
  eventos = 'Festi Juegos'
  free = "Juegos Gratuitos"
  USUARIO = 'USUARIO'
  usuarioRegistrado: Usuario | null = null;

  constructor(private usuarioService: UsuarioService) {}

  dropdownVisible = false;

  ngOnInit(): void {
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
