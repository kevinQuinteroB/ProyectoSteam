import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { tap } from 'rxjs/operators';
import { Desarrollador } from '../models/desarrollador';

@Injectable({
  providedIn: 'root'
})
export class DesarrolladorService {
  private baseURL = 'http://localhost:8080/desarrollador';
  
  constructor(private httpClient: HttpClient) { }

  registrarDesarrollador(desarrollador: any): Observable<any> {
    return this.httpClient.post(`${this.baseURL}/register`, desarrollador);
  }

  consultarDesarrollador(email: string, contrasena: string): Observable<Desarrollador> {
    return this.httpClient.get<Desarrollador>(`${this.baseURL}/login/${email}/${contrasena}`)
      .pipe(
        tap(desarrollador => {
          console.log('Desarrollador Antes de registrar:', this.getDesarrolladorRegistrado());
          localStorage.setItem('desarrolladorRegistrado', JSON.stringify(desarrollador));
          console.log('Desarrollador registrado:', this.getDesarrolladorRegistrado());
        })
      );
  }

  getDesarrolladorRegistrado(): Desarrollador {
    return JSON.parse(localStorage.getItem('desarrolladorRegistrado') || '{}');
  }
}
