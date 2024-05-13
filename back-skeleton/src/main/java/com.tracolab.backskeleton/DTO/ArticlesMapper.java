package com.tracolab.backskeleton.DTO;

import com.tracolab.backskeleton.models.Articles;

import java.io.IOException;

public class ArticlesMapper {
    public static Articles fromDto(ArticlesDto dto, Long id) throws IOException {
        return new Articles.Builder()
                .id(id)
                .nomarticle(dto.getNomArticle())
                .ancienprix(dto.getAncienPrix())
                .nouveauprix(dto.getNouveauPrix())
                .photoarticle(dto.getPhotoArticle())
                .utilisateur(dto.getUtilisateur())
                .build();
    }

    public static ArticlesDto toDto (Articles articles){
        return ArticlesDto.builder()
                .nomArticle(articles.getNomarticle())
                .AncienPrix(articles.getAncienprix())
                .NouveauPrix(articles.getNouveauprix())
                .PhotoArticle(articles.getPhotoarticle())
                .utilisateur(articles.getUtilisateurs())
                .build();
    }
}
