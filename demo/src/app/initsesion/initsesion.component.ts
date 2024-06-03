import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-initsesion',
  templateUrl: './initsesion.component.html',
  styleUrl: './initsesion.component.css'
})
export class InitsesionComponent {
  nombrePag = 'FullPlay';
  usuario = 'Usuario';
  contrasena = 'Contraseña'
  ingresar = 'Ingresar'
  Regs = 'Registrarse'
  RC = 'Recuperar Contraseña'
}
