// inscription.service.ts
import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpParams } from "@angular/common/http"
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Utilisateurs } from '../models/utilisateurs.model';

@Injectable({
  providedIn: 'root'
})
export class ConnexionService {
  private connexionUrl = 'http://localhost:8080/utilisateurs/connexion'; // Remplacez par l'URL de votre backend

  constructor(private http: HttpClient) { }

  connexion(email: string, motdepasse: string): Observable<Utilisateurs> {
    const params = new HttpParams()
      .set('email', email)
      .set('motdepasse', motdepasse);
    this.http.get<Utilisateurs>(this.connexionUrl, {
      params: {
        email: email,
        motdepasse: motdepasse
      }
    }).subscribe(
      (data: Utilisateurs) => {
        // La requête a réussi, afficher les détails de l'utilisateur ou effectuer d'autres opérations
        console.log('Utilisateur récupéré : ', data);
        alert('Utilisateur récupéré : ' + data);
      },
      (error) => {
        // Une erreur s'est produite lors de la requête, afficher un message d'erreur
        console.error('Une erreur s\'est produite : ', error);
        alert('Une erreur s\'est produite lors de la connexion.');
      }
    );return this.http.get<Utilisateurs>(this.connexionUrl).pipe(
      catchError((error: HttpErrorResponse) => {
        let errorMessage = 'Une erreur s\'est produite';
        if (error.error instanceof ErrorEvent) {
          errorMessage = `Erreur : ${error.error.message}`;
        } else {
          errorMessage = `Code d'erreur : ${error.status}\nMessage : ${error.message}`;
        }
        return throwError(errorMessage);
      })
    );
  }
}
