create table utilisateurs {
    id SERIAL PRIMARY KEY,
    nom VARCHAR(30)
    prenom VARCHAR(20)
    nom_utilisateur VARCHAR(20)
    e-mail VARCHAR(50)
    password TEXT
    }

create table promotions {
    id SERIAL PRIMARY KEY,
    nom VARCHAR(50)
    description TEXT
    AncienPrix INT
    NouveauPrix INT
    }