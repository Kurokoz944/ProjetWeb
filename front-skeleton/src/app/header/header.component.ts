import { Component } from '@angular/core';
import { Link } from "../models/links.model"

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {
  links: Link[] = []

  constructor() {
    this.links.push({ name: "Bons Plans", href: "articles" })
    this.links.push({ name: "Compte", href: "Compte" })
    this.links.push({ name: "Messagerie", href: "Messagerie" })
  }
}
