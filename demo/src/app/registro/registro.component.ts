import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pais } from '../pais';
import { PaisService } from '../pais.service';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})


export class RegistroComponent implements OnInit{
  constructor(private router: Router, private paisServicio:PaisService, private usuarioService:UsuarioService) {
  this.email = '';
  this.contrasena = '';
  this.firstName = '';
  this.lastName = '';
  this.username = '';
  this.checkbox = false;
  this.pais_id;
  this.saldo = 0;
  }

  email: string;
  contrasena: string;
  firstName: string;
  lastName: string;
  username: string;
  checkbox: boolean;
  pais_id: number;
  saldo: number;
  paises:Pais[];
  mensaje: string;
  titulomensaje: string

  redirectToLogin() {
    this.router.navigate(['/login']);
  }
  ngOnInit(): void {
    this.obtenerPaises();
  }

  obtenerPaises(): void {
    this.paisServicio.obtenerPaises().subscribe(paises => {
      this.paises = paises;
    });
  }
  
  formularioCompleto(): boolean {
    const camposLlenos = this.camposLlenos();
    const terminosAceptados = this.terminosAceptados();
    return terminosAceptados && camposLlenos;
  }
  
  
  terminosAceptados(): boolean {
    const checkbox = document.getElementById('flexCheckDefault') as HTMLInputElement;
    return checkbox ? checkbox.checked : false;
  }
  
  camposLlenos(): boolean {
    return (
      this.email !== '' &&
      this.contrasena  !== '' &&
      this.firstName !== '' &&
      this.lastName  !== '' &&
      this.username  !== '' &&
      this.pais_id >= 1
    );
  }
  

  
registrar(): void {
  const usuario = {
    email: this.email,
    contrasena: this.contrasena,
    username: this.username,
    pais_id: Number(this.pais_id),
    saldo: 0
  };


  this.usuarioService.registrarUsuario(usuario).subscribe(response => {
    console.log('Usuario registrado:', response);
    this.titulomensaje = "Registro exitoso"
    this.mensaje = "¡Gracias por registrarte en nuestra página web! Nos alegra que te unas a nuestra comunidad. Estamos aquí para ofrecerte la mejor experiencia y cualquier ayuda que necesites. ¡Bienvenido/a!"
    
  }, error => {
    console.error('Error al registrar usuario:', error);
    this.titulomensaje = "Registro denegado"
    this.mensaje = "Parece que ingresaste un usuario o un email ya existente"
  });
}
}


