INSERT INTO tracolab.utilisateurs (id,
                                   nom,
                                   prenom,
                                   datenaissance,
                                   pseudo,
                                   email,
                                   motdepasse,
                                   nbrearticlesencours,
                                   nbrearticlespublies,
                                   datecreation,
                                   datemaj)
VALUES (1,
        'admin',
        'admin',
        '2001-03-20',
        'ryan.bensalem@edu.ece.fr',
        'admin',
        'admin',
        0,
        0,
        NOW(),
        NOW());

CALL tracolab.PS_ArticleCreate(1,
                               'Iphone 15',
                               100,
                               50,
                               '/front-skeleton/assets/iphone15.jpg');


CALL tracolab.PS_ArticleCreate(1,
                               'GeForce RTX 4070 SUPER 12G GAMING X SLIM WHITE',
                               859,
                               593,
                               '/front-skeleton/assets/4070super.jpg');

CALL tracolab.PS_ArticleCreate(1,
                               'Abonnement Spotify Premium 1 an',
                               131,
                               64,
                               '/front-skeleton/assets/spotify.jpg');


CALL tracolab.PS_ArticleCreate(1,
                               'Vol A/R Paris (Orly) <-> Ibiza (îles Baleares)',
                               259,
                               40,
                               '/front-skeleton/assets/plage.jpg');
