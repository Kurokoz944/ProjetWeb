// inscription.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Utilisateurs } from '../models/utilisateurs.model';

@Injectable({
  providedIn: 'root'
})
export class InscriptionService {
  private apiUrl = 'http://localhost:8080/utilisateurs'; // Remplacez par l'URL de votre backend

  constructor(private http: HttpClient) { }

  inscription(utilisateur: Utilisateurs): Observable<any> {
    return this.http.post<any>(this.apiUrl, utilisateur);
  }
}
