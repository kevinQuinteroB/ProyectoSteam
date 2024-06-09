import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TiendaComponent } from './tienda/tienda.component';
import { InitsesionComponent } from './initsesion/initsesion.component';
import { RecuperarcontrasenaComponent } from './recuperarcontrasena/recuperarcontrasena.component';
import { NosotrosComponent } from './nosotros/nosotros.component';
import { SoporteComponent } from './soporte/soporte.component';
import { RegistroComponent } from './registro/registro.component';

const routes: Routes = [
  { path:'', redirectTo:'/login', pathMatch:'full'},
  { path: 'tienda', component: TiendaComponent },
  { path: 'login', component: InitsesionComponent },
  { path: 'recuperarcontrasena', component: RecuperarcontrasenaComponent },
  { path: 'nosotros', component: NosotrosComponent },
  { path: 'soporte', component: SoporteComponent},
  { path: 'registro', component: RegistroComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
