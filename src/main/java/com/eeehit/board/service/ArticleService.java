package com.eeehit.board.service;

import com.eeehit.board.domain.Article;
import com.eeehit.board.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sppark on 2017-05-21.
 */
@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    public List<Article> getArticleList() {
        return this.articleRepository.findAll();
    }

    public Article getArticleById(long id) {
        return this.articleRepository.findById(id);
    }
}
