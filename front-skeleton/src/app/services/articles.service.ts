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
    return this.http.get<Article[]>(`${this.apiUrl}`);

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
