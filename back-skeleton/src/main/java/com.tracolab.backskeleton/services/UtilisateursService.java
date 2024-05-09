package com.tracolab.backskeleton.services;

import com.tracolab.backskeleton.DAO.UtilisateursDao;
import com.tracolab.backskeleton.DTO.UtilisateursDto;
import com.tracolab.backskeleton.DTO.UtilisateursMapper;
import com.tracolab.backskeleton.models.Utilisateurs;
import jdk.jshell.execution.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UtilisateursService {
    private final UtilisateursDao utilisateursDao;

    public List<Utilisateurs> findAll() {
        Iterable<Utilisateurs> it = utilisateursDao.findAll();
        List <Utilisateurs> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

    public Utilisateurs getById(Long id) {
        return utilisateursDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        utilisateursDao.deleteById(id);
    }

    @Transactional
    public void addUtilisateurs(UtilisateursDto utilisateursDto) {
        Utilisateurs student;
        try {
            student = UtilisateursMapper.fromDto(utilisateursDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with Student image", e);
        }

        utilisateursDao.save(student);
    }

    @Transactional
    public void updateUtilisateurs(UtilisateursDto utilisateursDto, Long id) {
        utilisateursDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student doesn't exist"));
        Utilisateurs student;
        try {
            student = UtilisateursMapper.fromDto(utilisateursDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with Student image", e);
        }
        utilisateursDao.save(student);
    }
}
