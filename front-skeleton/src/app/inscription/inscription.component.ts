// inscription.component.ts
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { InscriptionService } from '../services/inscription.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent {
  inscriptionForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private inscriptionService: InscriptionService) {
    this.inscriptionForm = this.formBuilder.group({
        nom: ['', Validators.required],
        prenom: ['', Validators.required],
        dateNaissance: ['', Validators.required],
        pseudo: ['', Validators.required],
        email: ['', [Validators.required, Validators.email]],
        motdepasse: ['', [Validators.required, Validators.minLength(6)]]
    });
  }

  onSubmit() {
    if (this.inscriptionForm.valid) {
      const utilisateurData = this.inscriptionForm.value;
      this.inscriptionService.inscription(utilisateurData).subscribe(
        response => {
          // Gérez la réponse du backend après la création de l'utilisateur
          console.log('Utilisateur créé avec succès:', response);
        },
        error => {
          console.error('Erreur lors de la création de l\'utilisateur:', error);
        }
      );
    }
  }
}
