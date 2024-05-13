// inscription.component.ts
import { Component } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ConnexionService } from '../services/connexion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.scss']
})
export class ConnexionComponent {
  connexionForm: FormGroup;
  submitted = false;
  loading = false;
  error = 'test ';

  constructor(
    private formBuilder: FormBuilder,
    private connexionService: ConnexionService,
    private router: Router
  ) {
    this.connexionForm = this.formBuilder.group({
      email: ['', Validators.required],
      motdepasse: ['', Validators.required]
    });
  }

  onSubmit() {
    this.submitted = true;

    if (this.connexionForm.invalid) {
      return;
    }

    this.loading = true;
    this.connexionService.connexion(this.connexionForm.value.email, this.connexionForm.value.motdepasse)
      .subscribe(
        () => {
          this.router.navigate(['/']); // Redirige vers la page de tableau de bord après la connexion réussie
        },
        error => {
          this.error = error;
          this.loading = false;
        }
      );
  }
}
