import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { Article } from '../models/article.model'; // replace with the actual path to the Article model
import { ArticleService } from '../services/articles.service'; // replace with the actual path to the ArticleService

@Injectable({
  providedIn: 'root'
})
export class ListeResolver implements Resolve<Article[]> {
  constructor(private articleService: ArticleService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Article[]> {
    return this.articleService.getArticle();
  }
}
