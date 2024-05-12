import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {HomeComponent} from "./home/home.component";
import { ListeComponent } from "./liste/liste.component"
import { ListeResolver } from './liste/liste.resolver';


const routes: Routes = [
  { path: "", component: HomeComponent },
  {
    path: "articles",
    component: ListeComponent,
    resolve: {
      articles: ListeResolver,
    },
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
