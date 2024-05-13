package com.tracolab.backskeleton.DTO;

import com.tracolab.backskeleton.models.Articles;
import com.tracolab.backskeleton.models.Utilisateurs;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.Date;
import java.util.List;
@Builder
@Getter
public class ArticlesDto {
    private String nomarticle;
    private int ancienprix;
    private int nouveauprix;
    private int votepositif;
    private int votenegatif;
    private String photoarticle;
    private Utilisateurs utilisateur;
}
