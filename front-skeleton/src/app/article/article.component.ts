import { Component, Input } from '@angular/core';
import { Article } from '../models/article.model'; // Assurez-vous d'importer votre modèle Article

@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.scss']
})
export class ArticleComponent {
  @Input() articles: Article[] = [];
}
