import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { Juego } from '../models/juego';


@Injectable({
  providedIn: 'root'
})
export class JuegoService {

  private baseURL = "http://localhost:8080/juegos/search";
  private querySubject: BehaviorSubject<Juego> = new BehaviorSubject<Juego>({} as Juego);

  constructor(private httpClient : HttpClient) {}
  juego: Juego;

  consultarJuegoCaracter(busqueda: String): Observable<Juego[]>{
    return this.httpClient.get<Juego[]>(`${this.baseURL}/${busqueda}`);
  };

  setQuery(query: Juego): void {
    this.querySubject.next(query);
    console.log(query)
  }

  getQuery(): Observable<Juego> {
    return this.querySubject.asObservable();
    
  }
}
