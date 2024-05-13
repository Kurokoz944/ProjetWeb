import { Utilisateurs } from "./utilisateurs.model"

export interface Article {
  id: number; // Identifiant unique de l'article
  nomArticle: string; // Nom de l'article
  ancienPrix: number; // Ancien prix de l'article
  nouveauPrix: number; // Nouveau prix de l'article
  votePositif: number; // Nombre de votes positifs
  voteNegatif: number; // Nombre de votes négatifs
  photoArticle: string; // URL de la photo de l'article
  utilisateur: string; // Nom de l'utilisateur ayant posté l'article
}
