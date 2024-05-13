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

  constructor() {
    this.links.push({ name: "Bons Plans", href: "articles" })
    this.links.push({ name: "Compte", href: "Compte" })
    this.links.push({ name: "Messagerie", href: "Messagerie" })
    this.links.push({ name: "Inscription", href: "inscription"})
    this.links.push({ name: "Connexion", href: "connexion"})
  }

  ngOnInit(): void {
  }

}
