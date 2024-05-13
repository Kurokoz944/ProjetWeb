package com.tracolab.backskeleton.DTO;

import com.tracolab.backskeleton.models.Articles;

import java.io.IOException;

public class ArticlesMapper {
    public static Articles fromDto(ArticlesDto dto, Long id) throws IOException {
        return new Articles.Builder()
                .id(id)
                .nomarticle(dto.getNomarticle())
                .ancienprix(dto.getAncienprix())
                .nouveauprix(dto.getNouveauprix())
                .photoarticle(dto.getPhotoarticle())
                .utilisateur(dto.getUtilisateur())
                .build();
    }

    public static ArticlesDto toDto (Articles articles){
        return ArticlesDto.builder()
                .nomarticle(articles.getNomarticle())
                .ancienprix(articles.getAncienprix())
                .nouveauprix(articles.getNouveauprix())
                .photoarticle(articles.getPhotoarticle())
                .utilisateur(articles.getUtilisateurs())
                .build();
    }
}
