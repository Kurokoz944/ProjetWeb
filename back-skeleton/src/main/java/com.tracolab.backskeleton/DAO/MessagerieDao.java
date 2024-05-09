package com.tracolab.backskeleton.DAO;

import com.tracolab.backskeleton.models.Messagerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagerieDao extends JpaRepository<Messagerie, Long> {
}
