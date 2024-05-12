import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { Article } from '../models/article.model'; // Assurez-vous d'importer votre modèle Article

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  private apiUrl = 'https://exemple.com/api/articles'; // Remplacez l'URL par votre URL d'API

  constructor(private http: HttpClient) { }

  // Méthode pour récupérer les articles depuis l'API
  getArticle(): Observable<Article[]> {


      const mockArticles: Article[] = [
      {
        id: 1,
        nomArticle: 'Article 1',
        AncienPrix: 100,
        NouveauPrix: 80,
        VotePositif: 10,
        VoteNegatif: 2,
        PhotoArticle: 'url-to-image-1',
        utilisateur: 'User 1'
      },
      {
        id: 2,
        nomArticle: 'Article 2',
        AncienPrix: 200,
        NouveauPrix: 150,
        VotePositif: 20,
        VoteNegatif: 5,
        PhotoArticle: 'url-to-image-2',
        utilisateur: 'User 2'
      },
        {
          id: 3,
          nomArticle: 'Article 3',
          AncienPrix: 300,
          NouveauPrix: 250,
          VotePositif: 30,
          VoteNegatif: 8,
          PhotoArticle: 'url-to-image-3',
          utilisateur: 'User 3'
        },
        {
          id: 4,
          nomArticle: 'Article 4',
          AncienPrix: 400,
          NouveauPrix: 350,
          VotePositif: 40,
          VoteNegatif: 10,
          PhotoArticle: 'url-to-image-4',
          utilisateur: 'User 4'
        },
      // Add more mock articles as needed
    ];

    return of(mockArticles);


    /*
    return this.http.get<Article[]>(this.apiUrl);
    */

  }
}
