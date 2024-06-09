import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InitsesionComponent } from './initsesion/initsesion.component';
import { TiendaComponent } from './tienda/tienda.component';
import { RecuperarcontrasenaComponent } from './recuperarcontrasena/recuperarcontrasena.component';
import { NosotrosComponent } from './nosotros/nosotros.component';
import { SoporteComponent } from './soporte/soporte.component';
import { RegistroComponent } from './registro/registro.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    InitsesionComponent,
    TiendaComponent,
    RecuperarcontrasenaComponent,
    NosotrosComponent,
    SoporteComponent,
    RegistroComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
