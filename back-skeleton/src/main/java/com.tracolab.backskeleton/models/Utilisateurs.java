package com.tracolab.backskeleton.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "utilisateurs", schema = "tracolab")
@Getter
 public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilisateurs_id_seq")
    private long id;
    @Column(name="Nom")
    private String nom;
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "DateNaissance")
    private Date dateNaissance;
    @Column(name = "pseudo")
    private String pseudo;
    @Column(name = "email")
    private String email;
    @Column(name = "motdepasse")
    private String motdepasse;
    @Column(name = "nbreArticlesEnCours")
    private int nbreArticlesEnCours;
    @Column(name = "nbreArticlesPublies")
    private int nbreArticlesPublies;
    @OneToMany(mappedBy = "utilisateur")
    private List<Articles> articles;

    private Utilisateurs(Builder builder){
        this.id = builder.id;
        this.nom = builder.nom;
        this.prenom = builder.prenom;
        this.dateNaissance = builder.dateNaissance;
        this.pseudo = builder.pseudo;
        this.email = builder.email;
        this.motdepasse = builder.motdepasse;
        this.nbreArticlesEnCours = builder.nbreArticlesEnCours;
        this.nbreArticlesPublies = builder.nbreArticlesPublies;
        this.articles = builder.articles;
    }

    public Utilisateurs(){}

    public static class Builder {
        private Long id;
        private String nom;
        private String prenom;
        private Date dateNaissance;
        private String pseudo;
        private String email;
        private String motdepasse;
        private int nbreArticlesEnCours;
        private int nbreArticlesPublies;
        private List<Articles> articles;

        public Utilisateurs.Builder id (Long id) {
            this.id = id;
            return this;
        }
        public Utilisateurs.Builder nom (String nom) {
            this.nom = nom;
            return this;
        }
        public Utilisateurs.Builder prenom (String prenom) {
            this.prenom = prenom;
            return this;
        }
        public Utilisateurs.Builder dateNaissance (Date dateNaissance) {
            this.dateNaissance = dateNaissance;
            return this;
        }
        public Utilisateurs.Builder pseudo (String pseudo) {
            this.pseudo = pseudo;
            return this;
        }
        public Utilisateurs.Builder email (String email) {
            this.email = email;
            return this;
        }
        public Utilisateurs.Builder motdepasse (String motdepasse) {
            this.motdepasse = motdepasse;
            return this;
        }
        public Utilisateurs.Builder nbreArticlesEnCours (int nbreArticlesEnCours) {
            this.nbreArticlesEnCours = nbreArticlesEnCours;
            return this;
        }
        public Utilisateurs.Builder nbreArticlesPublies (int nbreArticlesPublies) {
            this.nbreArticlesPublies = nbreArticlesPublies;
            return this;
        }
        public Utilisateurs.Builder articles (List<Articles> articles) {
            this.articles = articles;
            return this;
        }
        public Utilisateurs build() {
            return new Utilisateurs(this);
        }
    }
}
