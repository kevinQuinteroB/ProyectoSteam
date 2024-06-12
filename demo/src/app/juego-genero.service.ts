import { Injectable } from '@angular/core';
import { JuegoGenero } from './juego-genero';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class JuegoGeneroService {

  private baseURLjuegos = "http://localhost:8080/juegosGenero";

  constructor(private httpClient : HttpClient) { 

  }

  consultarGeneroJuego(id_juego: number): Observable<JuegoGenero[]> {
    return this.httpClient.get<JuegoGenero[]>(`${this.baseURLjuegos}/${id_juego}`);
  }
}
