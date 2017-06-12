package com.eeehit.board.controller;

import com.eeehit.board.domain.Article;
import com.eeehit.board.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by sppark on 2017-05-21.
 */
@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView main(HttpSession httpSession) {
        List<Article> articleList = articleService.getArticleList();
        ModelAndView mv = new ModelAndView("main");
        mv.addObject("articleList", articleList);
        return mv;
    }
}