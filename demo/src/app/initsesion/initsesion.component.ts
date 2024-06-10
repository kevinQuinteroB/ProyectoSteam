import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from '../usuario.service';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-initsesion',
  templateUrl: './initsesion.component.html',
  styleUrls: ['./initsesion.component.css']
})
export class InitsesionComponent {
  nombrePag = 'Virtual Vault';
  usuario = 'Usuario';
  contrasenatexto = 'Contraseña';
  ingresar = 'Ingresar';
  Regs = 'Registrarse';
  RC = 'Recuperar Contraseña';
  email: string;
  contrasena: string;

  constructor(private router: Router, private usuarioService: UsuarioService) {}

  consulta(): void {
    this.usuarioService.consultarUsuario(this.email, this.contrasena).subscribe(response => {
      console.log('Usuario registrado:', response);
      if (response != null) {
        this.router.navigate(['/tienda']);
      } else {
        console.error('Error al autenticar usuario:');
        this.mostrarModalError();
      }
    });
  }

  mostrarModalError(): void {
    const modalElement = document.getElementById('exampleModal');
    if (modalElement) {
      const myModal = new bootstrap.Modal(modalElement);
      myModal.show();
    }
  }
}
