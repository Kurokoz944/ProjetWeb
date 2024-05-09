package com.tracolab.backskeleton.DTO;

import com.tracolab.backskeleton.models.Articles;
import com.tracolab.backskeleton.DTO.ArticlesDto;

import java.io.IOException;

public class ArticlesMapper {
    public static Articles fromDto(ArticlesDto dto, Long id) throws IOException {
        return new Articles.Builder()
                .id(id)
                .nomArticle(dto.getNomArticle())
                .ancienPrix(dto.getAncienPrix())
                .nouveauPrix(dto.getNouveauPrix())
                .photoArticle(dto.getPhotoArticle())
                .utilisateur(dto.getUtilisateur())
                .build();
    }

    public static ArticlesDto toDto (Articles articles){
        return ArticlesDto.builder()
                .nomArticle(articles.getNomArticle())
                .AncienPrix(articles.getAncienPrix())
                .NouveauPrix(articles.getNouveauPrix())
                .PhotoArticle(articles.getPhotoArticle())
                .utilisateur(articles.getUtilisateur())
                .build();
    }
}
