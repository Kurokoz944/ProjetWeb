import { Component } from '@angular/core';
import { Link } from "../models/links.model"
import { Utilisateurs } from "../models/utilisateurs.model"
import { ConnexionService } from "../services/connexion.service"

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  links: Link[] = []
  utilisateur: Utilisateurs | null = null;

  constructor(private connexionService: ConnexionService) {
    this.links.push({ name: "Bons Plans", href: "articles" })
    this.links.push({ name: "Compte", href: "Compte" })
    this.links.push({ name: "Messagerie", href: "Messagerie" })
  }

  ngOnInit() {
    this.connexionService.connexion('email@example.com', 'password123') // Remplacez par les vraies valeurs
      .subscribe(
        (data: Utilisateurs) => {
          this.utilisateur = data;
        },
        (error) => {
          console.error('Une erreur s\'est produite : ', error);
        }
      );
  }

}
