package com.tracolab.backskeleton.models;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "articles", schema = "tracolab")
@Getter
public class Articles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "articles_id_seq" )
    private Long id;
    @Column(name = "nomarticle")
    private String nomarticle;
    @Column(name = "ancienprix")
    private int ancienprix;
    @Column(name = "nouveauprix")
    private int nouveauprix;
    @Column(name = "votepositif")
    private int votepositif;
    @Column(name = "votenegatif")
    private int votenegatif;
    @Column(name = "photoarticle")
    private String photoarticle;
    @ManyToOne
    @JoinTable(
            name = "article_utilisateur",
            joinColumns = @JoinColumn(name = "articles_id"),
            inverseJoinColumns = @JoinColumn(name = "utilisateurs_id"))
    private Utilisateurs utilisateurs;


    private Articles(Articles.Builder builder){
        this.id = builder.id;
        this.nomarticle = builder.nomarticle;
        this.ancienprix = builder.ancienprix;
        this.nouveauprix = builder.nouveauprix;
        this.votepositif = builder.votepositif;
        this.votenegatif = builder.votenegatif;
        this.photoarticle = builder.photoarticle;
        this.utilisateurs = builder.utilisateur;
    }

    public Articles(){}

    public static class Builder {
        private Long id;
        private String nomarticle;
        private int ancienprix;
        private int nouveauprix;
        private int votepositif;
        private int votenegatif;
        private String photoarticle;
        private Utilisateurs utilisateur;

        public Articles.Builder id (Long id) {
            this.id = id;
            return this;
        }
        public Articles.Builder nomarticle (String nom) {
            this.nomarticle = nomarticle;
            return this;
        }
        public Articles.Builder ancienprix (int ancienprix) {
            this.ancienprix = ancienprix;
            return this;
        }
        public Articles.Builder nouveauprix (int nouveauprix) {
            this.nouveauprix = nouveauprix;
            return this;
        }
        public Articles.Builder votepositif (int votepositif) {
            this.votepositif = votepositif;
            return this;
        }
        public Articles.Builder votenegatif (int votenegatif) {
            this.votenegatif = votenegatif;
            return this;
        }
        public Articles.Builder photoarticle (String photoarticle) {
            this.photoarticle = photoarticle;
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
