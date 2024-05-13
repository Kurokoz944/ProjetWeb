package com.tracolab.backskeleton.controllers;

import com.takima.backskeleton.models.Student;
import com.tracolab.backskeleton.DTO.UtilisateursDto;
import com.tracolab.backskeleton.models.Utilisateurs;
import com.tracolab.backskeleton.services.UtilisateursService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RequestMapping("utilisateurs")
@RestController
@RequiredArgsConstructor
public class UtilisateursController {
    private final UtilisateursService utilisateursService;

    @GetMapping("/connexion")
    public Utilisateurs connexion(@RequestParam(required = false) String email, @RequestParam(required = false) String motdepasse) {
        if (email != null && motdepasse !=null) {
            return utilisateursService.Connexion(email, motdepasse);
        }
        return null;
    }

    @GetMapping("")
    public List<Utilisateurs> listUtilisateurs() {
        return utilisateursService.findAll();
    }

    @GetMapping("/{id}")
    public Utilisateurs getUtilisateursById(@PathVariable Long id) {
        return utilisateursService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateurs(@PathVariable Long id) {
        utilisateursService.deleteById(id);
    }

    @PostMapping("")
    public void addUtilisateurs(@RequestBody UtilisateursDto utilisateursDto) {
        utilisateursService.addUtilisateurs(utilisateursDto);
    }

    @PostMapping("/{id}")
    public void updateUtilisateurs(@RequestBody UtilisateursDto utilisateursDto, @PathVariable Long id) {
        utilisateursService.updateUtilisateurs(utilisateursDto, id);
    }
}
