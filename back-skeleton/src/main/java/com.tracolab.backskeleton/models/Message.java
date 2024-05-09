package com.tracolab.backskeleton.models;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.*;

@Entity
@Table(name = "message", schema = "tracolab")
@Getter
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_messagerie")
    private Messagerie messagerie;

    @ManyToOne
    @JoinColumn(name = "id_utilisateurs")
    private Utilisateurs utilisateur;

    private String message;

    private Date dateCreation;

    // Getters and setters
}