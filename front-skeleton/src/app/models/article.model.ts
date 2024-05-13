export interface Article {
  id: number; // Identifiant unique de l'article
  nomArticle: string; // Nom de l'article
  AncienPrix: number; // Ancien prix de l'article
  NouveauPrix: number; // Nouveau prix de l'article
  VotePositif: number; // Nombre de votes positifs
  VoteNegatif: number; // Nombre de votes négatifs
  PhotoArticle: string; // URL de la photo de l'article
  utilisateur: string; // Nom de l'utilisateur ayant posté l'article
}
