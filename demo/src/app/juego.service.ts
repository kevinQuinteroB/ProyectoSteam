import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Juego } from './juego';

@Injectable({
  providedIn: 'root'
})
export class JuegoService {

  private baseURL = "http://localhost:8080/juegos/search";

  constructor(private httpClient : HttpClient) {}

  consultarJuegoCaracter(busqueda: String): Observable<Juego[]>{
    return this.httpClient.get<Juego[]>(`${this.baseURL}/${busqueda}`);
  };

}
