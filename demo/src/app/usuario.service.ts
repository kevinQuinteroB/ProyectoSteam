import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient,  } from '@angular/common/http';
import { Usuario } from './usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  private baseURL = 'http://localhost:8080/user';

  constructor(private httpClient: HttpClient) {}

  registrarUsuario(usuario: any): Observable<any> {
    return this.httpClient.post(`${this.baseURL}/register`, usuario);
  }

  consultarUsuario(email: string, contrasena: string):Observable<any>{
    return this.httpClient.get(`${this.baseURL}/login/${email}/${contrasena}`);
  }
}

