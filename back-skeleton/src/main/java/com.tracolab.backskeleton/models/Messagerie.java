package com.tracolab.backskeleton.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "messagerie", schema = "tracolab")
@Getter
@NoArgsConstructor
public class Messagerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_utilisateurs1")
    private Utilisateurs utilisateur1;

    @ManyToOne
    @JoinColumn(name = "id_utilisateurs2")
    private Utilisateurs utilisateur2;

    private Date dateCreation;

    // Getters and setters
}
