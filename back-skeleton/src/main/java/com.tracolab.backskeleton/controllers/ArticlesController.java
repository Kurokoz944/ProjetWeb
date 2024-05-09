package com.tracolab.backskeleton.controllers;

import com.tracolab.backskeleton.DTO.ArticlesDto;
import com.tracolab.backskeleton.models.Articles;
import com.tracolab.backskeleton.services.ArticlesService;
import com.tracolab.backskeleton.services.UtilisateursService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin
@RequestMapping("articles")
@RestController
@RequiredArgsConstructor
public class ArticlesController {
    private final ArticlesService articlesService;
    @GetMapping("/{id}")
    public Articles getArticlesById(@PathVariable Long id) {
        return articlesService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteArticles(@PathVariable Long utilisateurId, Long articleId) {
        articlesService.deleteArticle(utilisateurId, articleId);
    }

    @PostMapping("")
    public void addArticles(@RequestBody ArticlesDto articlesDto) {
        articlesService.createArticle(articlesDto);
    }

    @PostMapping("/{id}")
    public void updateArticles(@RequestBody ArticlesDto articlesDto, @PathVariable Long id) {
        articlesService.updateArticle(articlesDto, id);
    }
}
