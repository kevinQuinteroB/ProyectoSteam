import { Component } from '@angular/core';
import { UsuarioService } from '../services/usuario.service';
import { Usuario } from '../models/usuario';
import { PaisService } from '../services/pais.service';
import { Pais } from '../models/pais';

@Component({
  selector: 'app-perfil-usuario',
  templateUrl: './perfil-usuario.component.html',
  styleUrl: './perfil-usuario.component.css'
})
export class PerfilUsuarioComponent {
  nombrePag = 'Virtual Vault'
  noticias = 'Noticias'
  tienda = 'Tienda'
  soporte = 'Soporte'
  acerca = 'Nosotros'
  USUARIO = 'USUARIO'
  username: string;
  telefono: number;
  pais_id: number;
  primerApellido: string;
  primerNombre: string;
  correo: string;
  usuarioRegistrado: Usuario | null = null;

  pais: Pais;
  NombrePais: string;

  dropdownVisible = false;

  toggleDropdown() {
    this.dropdownVisible = !this.dropdownVisible;
  }

  constructor(private usuarioService: UsuarioService, private paisService: PaisService) {

  }

  ngOnInit(): void {
    this.usuarioRegistrado = this.usuarioService.getUsuarioRegistrado();
    console.log(this.usuarioRegistrado);
    if (this.usuarioRegistrado) {
      this.USUARIO = this.usuarioRegistrado.username;
      this.username = this.usuarioRegistrado.username;
      this.primerNombre = this.usuarioRegistrado.primerNombre;
      this.primerApellido = this.usuarioRegistrado.primerApellido;
      this.pais_id = this.usuarioRegistrado.pais_id;
      this.telefono = this.usuarioRegistrado.telefono;
      this.correo = this.usuarioRegistrado.email

      this.paisService.obtenerPais(this.pais_id).subscribe(
        (data: Pais) => {
          this.pais = data;
          this.NombrePais = this.pais.nombre;
        },
        (error) => {
          console.error('Error al obtener el país', error);
        }
      );
      
    }
  }
}
