import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { Article } from '../models/article.model'; // Assurez-vous d'importer votre modèle Article

@Injectable({
  providedIn: 'root'
})
export class ArticleService {
  private apiUrl = 'http://localhost:8080/articles'; // Remplacez l'URL par votre URL d'API

  constructor(private http: HttpClient) { }

  // Méthode pour récupérer les articles depuis l'API

  getArticle(): Observable<Article[]> {
    // return this.http.get<Article[]>(`${this.apiUrl}`);
    const mockArticles: Article[] = [
      {
        id: 1,
        nomArticle: 'Article 1',
        ancienPrix: 100,
        nouveauPrix: 80,
        votePositif: 10,
        voteNegatif: 2,
        photoArticle: 'url-to-image-1',
        utilisateur: 'User 1'
      },
      {
        id: 2,
        nomArticle: 'Article 2',
        ancienPrix: 200,
        nouveauPrix: 150,
        votePositif: 20,
        voteNegatif: 5,
        photoArticle: 'url-to-image-2',
        utilisateur: 'User 2'
      },
      {
        id: 3,
        nomArticle: 'Article 3',
        ancienPrix: 300,
        nouveauPrix: 250,
        votePositif: 30,
        voteNegatif: 8,
        photoArticle: 'url-to-image-3',
        utilisateur: 'User 3'
      },
      {
        id: 4,
        nomArticle: 'Article 4',
        ancienPrix: 400,
        nouveauPrix: 350,
        votePositif: 40,
        voteNegatif: 10,
        photoArticle: 'url-to-image-4',
        utilisateur: 'User 4'
      },
      // Add more mock articles as needed
    ];

    return of(mockArticles);
  }

  getArticleById(id: number): Observable<Article> {
    return this.http.get<Article>(`${this.apiUrl}/${id}`);
  }

  deleteArticle(utilisateurId: number, articleId: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${utilisateurId}/${articleId}`);
  }

  createArticle(article: Article): Observable<Article> {
    return this.http.post<Article>(`${this.apiUrl}`, article);
  }

  updateArticle(article: Article, id: number): Observable<Article> {
    return this.http.put<Article>(`${this.apiUrl}/${id}`, article);
  }

}
