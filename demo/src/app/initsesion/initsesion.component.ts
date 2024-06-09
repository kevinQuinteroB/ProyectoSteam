import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-initsesion',
  templateUrl: './initsesion.component.html',
  styleUrl: './initsesion.component.css'
})
export class InitsesionComponent {
  constructor(private router: Router, private usuarioService:UsuarioService){

  }

  nombrePag = 'Virtual Vault';
  usuario = 'Usuario';
  contrasenatexto = 'Contraseña'
  ingresar = 'Ingresar'
  Regs = 'Registrarse'
  RC = 'Recuperar Contraseña'
  email: string;
  contrasena: string;

  consulta(): void {

    this.usuarioService.consultarUsuario(this.email, this.contrasena).subscribe(response => {
      console.log('Usuario registrado:', response);
      if(response != null){
        this.router.navigate(['/tienda']);
      }
    },
    error => {
      console.error('Error al autenticar usuario:', error);
      this.mostrarModalError();
    }
    );
  }

  mostrarModalError(): void {
    const modalElement = document.getElementById('exampleModal');
    if (modalElement) {
      var myModal = new bootstrap.Modal(modalElement);
      myModal.show();
    }
  };
}
