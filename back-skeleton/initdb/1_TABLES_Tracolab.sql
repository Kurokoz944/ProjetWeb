CREATE SCHEMA tracolab;

create table tracolab.utilisateurs
(
    id SERIAL PRIMARY KEY,
    Nom VARCHAR(50) null,
    Prenom VARCHAR(50) null,
    DateNaissance date null,
    pseudo VARCHAR(50) not null,
    email text null,
    motdepasse text not null,
    nbreArticlesEnCours INT,
    nbreArticlesPublies INT,
    DATECREATION TIMESTAMP,
    DATEMAJ TIMESTAMP
);

create table tracolab.articles
(
    id SERIAL PRIMARY KEY,
    NomArticle VARCHAR(50) null,
    AncienPrix INT,
    NouveauPrix INT,
    VotePositif INT,
    VoteNegatif INT,
    PhotoArticle VARCHAR(255),
    DATECREATION TIMESTAMP,
    DATEMAJ TIMESTAMP
);

create table tracolab.article_utilisateur(
    id SERIAL PRIMARY KEY,
    utilisateurs_id INT NOT NULL,
    articles_id INT NOT NULL,
    supprim INT NOT NULL
);

create table tracolab.messagerie
(
    id SERIAL PRIMARY KEY,
    id_utilisateurs1 INT NOT NULL,
    id_utilisateurs2 INT NOT NULL,
    DATECREATION TIMESTAMP
);

create table tracolab.message
(
    id SERIAL PRIMARY KEY,
    id_messagerie INT NOT NULL,
    id_utilisateurs INT NOT NULL,
    message TEXT,
    DATECREATION TIMESTAMP
);

CREATE OR REPLACE PROCEDURE tracolab.PS_ArticleDelete(in_UtilisateurId INT,
                                             in_ArticleId INT)
    LANGUAGE plpgsql
    AS $$
    BEGIN
    DELETE
    FROM tracolab.articles
    WHERE id = in_ArticleId;
    UPDATE tracolab.utilisateurs
    SET nbreArticlesEnCours = nbreArticlesEnCours - 1
    WHERE id = in_UtilisateurId;
    END;
$$;

CREATE OR REPLACE PROCEDURE tracolab.PS_ArticleCreate(in_UtilisateurId INT,
                                             in_NomArticle VARCHAR(50),
                                             in_AncienPrix INT,
                                             in_NouveauPrix INT,
                                             in_PhotoArticle VARCHAR(255)
       )
       LANGUAGE plpgsql
           AS $$
    DECLARE
        new_id INT;
    BEGIN
        INSERT INTO tracolab.articles (NomArticle,
                              AncienPrix,
                              NouveauPrix,
                              VotePositif,
                              VoteNegatif,
                              PhotoArticle,
                              DATECREATION,
                              DATEMAJ)
        VALUES (in_NomArticle,
                in_AncienPrix,
                in_NouveauPrix,
                0,
                0,
                in_PhotoArticle,
                NOW(),
                NOW()) RETURNING id INTO new_id;
        INSERT INTO tracolab.article_utilisateur(utilisateurs_id,
                                        articles_id,
                                        supprim)
        VALUES(in_UtilisateurId,
               new_id,
               0);
        UPDATE tracolab.utilisateurs
        SET nbreArticlesEnCours = nbreArticlesEnCours + 1,
            nbreArticlesPublies = nbreArticlesPublies + 1
        WHERE id = in_UtilisateurId;

    END;
$$;