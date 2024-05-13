package com.tracolab.backskeleton.DAO;

import com.tracolab.backskeleton.models.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateursDao extends JpaRepository<Utilisateurs, Long> {
    @Query("SELECT u FROM Utilisateurs u WHERE u.email= :email AND u.motdepasse = :motdepasse ")
    Utilisateurs connexion(String email, String motdepasse);
}
