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
public class UtilisateursDto {
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String pseudo;
    private String email;
    private String motdepasse;
    private int nbreArticlesEnCours;
    private int nbreArticlesPublies;
    private List<Articles> articles;
}
