import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InitsesionComponent } from './initsesion/initsesion.component';
import { TiendaComponent } from './tienda/tienda.component';
import { RecuperarcontrasenaComponent } from './recuperarcontrasena/recuperarcontrasena.component';

@NgModule({
  declarations: [
    AppComponent,
    InitsesionComponent,
    TiendaComponent,
    RecuperarcontrasenaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
