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
    private Long id;
    @Column(name="nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "datenaissance")
    private Date dateNaissance;
    @Column(name = "pseudo")
    private String pseudo;
    @Column(name = "email", unique=true)
    private String email;
    @Column(name = "motdepasse")
    private String motdepasse;
    @Column(name = "nbrearticlesencours")
    private int nbreArticlesEnCours;
    @Column(name = "nbrearticlespublies")
    private int nbreArticlesPublies;
    @OneToMany(mappedBy = "utilisateurs")
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

        public Builder id (Long id) {
            this.id = id;
            return this;
        }
        public Builder nom (String nom) {
            this.nom = nom;
            return this;
        }
        public Builder prenom (String prenom) {
            this.prenom = prenom;
            return this;
        }
        public Builder dateNaissance (Date dateNaissance) {
            this.dateNaissance = dateNaissance;
            return this;
        }
        public Builder pseudo (String pseudo) {
            this.pseudo = pseudo;
            return this;
        }
        public Builder email (String email) {
            this.email = email;
            return this;
        }
        public Builder motdepasse (String motdepasse) {
            this.motdepasse = motdepasse;
            return this;
        }
        public Builder nbreArticlesEnCours (int nbreArticlesEnCours) {
            this.nbreArticlesEnCours = nbreArticlesEnCours;
            return this;
        }
        public Builder nbreArticlesPublies (int nbreArticlesPublies) {
            this.nbreArticlesPublies = nbreArticlesPublies;
            return this;
        }
        public Builder articles (List<Articles> articles) {
            this.articles = articles;
            return this;
        }
        public Utilisateurs build() {
            return new Utilisateurs(this);
        }
    }
}
