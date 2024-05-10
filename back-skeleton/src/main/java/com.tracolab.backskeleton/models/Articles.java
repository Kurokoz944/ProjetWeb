package com.tracolab.backskeleton.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "articles", schema = "tracolab")
@Getter
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articles_id_seq" )
    private Long id;
    @Column(name = "NomArticle")
    private String nomArticle;
    @Column(name = "AncienPrix")
    private int AncienPrix;
    @Column(name = "NouveauPrix")
    private int NouveauPrix;
    @Column(name = "VotePositif")
    private int VotePositif;
    @Column(name = "VoteNegatif")
    private int VoteNegatif;
    @Column(name = "PhotoArticle")
    private String PhotoArticle;
    @JoinColumn(name = "utilisateurs_id")
    @ManyToOne
    private Utilisateurs utilisateur;


    private Articles(Articles.Builder builder){
        this.id = builder.id;
        this.nomArticle = builder.nomArticle;
        this.AncienPrix = builder.AncienPrix;
        this.NouveauPrix = builder.NouveauPrix;
        this.VotePositif = builder.VotePositif;
        this.VoteNegatif = builder.VoteNegatif;
        this.PhotoArticle = builder.PhotoArticle;
        this.utilisateur = builder.utilisateur;
    }

    public Articles(){}

    public static class Builder {
        private Long id;
        private String nomArticle;
        private int AncienPrix;
        private int NouveauPrix;
        private int VotePositif;
        private int VoteNegatif;
        private String PhotoArticle;
        private Utilisateurs utilisateur;

        public Articles.Builder id (Long id) {
            this.id = id;
            return this;
        }
        public Articles.Builder nomArticle (String nom) {
            this.nomArticle = nomArticle;
            return this;
        }
        public Articles.Builder ancienPrix (int ancienPrix) {
            this.AncienPrix = ancienPrix;
            return this;
        }
        public Articles.Builder nouveauPrix (int nouveauPrix) {
            this.NouveauPrix = nouveauPrix;
            return this;
        }
        public Articles.Builder votePositif (int votePositif) {
            this.VotePositif = votePositif;
            return this;
        }
        public Articles.Builder voteNegatif (int voteNegatif) {
            this.VoteNegatif = voteNegatif;
            return this;
        }
        public Articles.Builder photoArticle (String photoArticle) {
            this.PhotoArticle = photoArticle;
            return this;
        }
        public Articles.Builder utilisateur (Utilisateurs utilisateur) {
            this.utilisateur = utilisateur;
            return this;
        }
        public Articles build() {
            return new Articles(this);
        }
    }
}
