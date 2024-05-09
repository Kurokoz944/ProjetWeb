package com.tracolab.backskeleton.services;

import com.tracolab.backskeleton.DTO.ArticlesDto;
import com.tracolab.backskeleton.DTO.ArticlesMapper;
import com.tracolab.backskeleton.DAO.ArticlesDao;
import com.tracolab.backskeleton.models.Articles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArticlesService {
    @Autowired
    private ArticlesDao articlesDao;

    public Articles getById(Long id){ return articlesDao.findById(id).orElseThrow();}

    @Transactional
    public void deleteArticle(Long utilisateurId, Long articleId) {
        articlesDao.deleteArticle(utilisateurId, articleId);
    }

    public void createArticle(ArticlesDto articlesDto) {
        articlesDao.createArticle(articlesDto.getUtilisateur().getId(), articlesDto.getNomArticle(), articlesDto.getAncienPrix(), articlesDto.getNouveauPrix(), articlesDto.getPhotoArticle());
    }
    public void updateArticle(ArticlesDto articlesDto, Long id) {
        articlesDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student doesn't exist"));
        Articles article;
        try {
            article = ArticlesMapper.fromDto(articlesDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with Student image", e);
        }
        articlesDao.save(article);
    }
}