package com.tracolab.backskeleton.DAO;

import com.tracolab.backskeleton.models.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.*;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticlesDao extends JpaRepository<Articles, Long> {
    @Procedure(name = "PS_ArticleCreate")
    void createArticle(Long utilisateursId, String NomArticle, int AncienPrix, int NouveauPrix, String PhotoArticle);
    @Procedure(name = "PS_ArticleDelete")
    void deleteArticle(Long utilisateursId, Long articlesId);
   }
