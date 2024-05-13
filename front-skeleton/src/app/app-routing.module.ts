import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomeComponent} from "./home/home.component";
import { ListeComponent } from "./liste/liste.component"
import { ListeResolver } from './liste/liste.resolver';
import { InscriptionComponent } from './inscription/inscription.component';
import { ConnexionComponent } from './connexion/connexion.component';


const routes: Routes = [
  { path: "", component: HomeComponent },
  {
    path: "articles",
    component: ListeComponent,
    resolve: {
      articles: ListeResolver,
    }
  },
  { path: "inscription", component: InscriptionComponent },
  { path: "connexion", component: ConnexionComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
