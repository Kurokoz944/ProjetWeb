package com.tracolab.backskeleton.DTO;

import com.takima.backskeleton.DTO.StudentDto;
import com.takima.backskeleton.models.Student;
import com.tracolab.backskeleton.models.Utilisateurs;
import jdk.jshell.execution.Util;

import java.io.IOException;

public class UtilisateursMapper {
    public static Utilisateurs fromDto(UtilisateursDto dto, Long id) throws IOException {
        return new Utilisateurs.Builder()
                .id(id)
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .dateNaissance(dto.getDateNaissance())
                .pseudo(dto.getPseudo())
                .motdepasse(dto.getMotdepasse())
                .nbreArticlesEnCours(dto.getNbreArticlesEnCours())
                .nbreArticlesPublies(dto.getNbreArticlesPublies())
                .articles(dto.getArticles())
                .build();
    }

    public static UtilisateursDto toDto (Utilisateurs utilisateurs){
        return UtilisateursDto.builder()
                .nom(utilisateurs.getNom())
                .prenom(utilisateurs.getPrenom())
                .dateNaissance(utilisateurs.getDateNaissance())
                .pseudo(utilisateurs.getPseudo())
                .motdepasse(utilisateurs.getMotdepasse())
                .nbreArticlesEnCours(utilisateurs.getNbreArticlesEnCours())
                .nbreArticlesPublies(utilisateurs.getNbreArticlesPublies())
                .articles(utilisateurs.getArticles())
                .build();
    }
}
