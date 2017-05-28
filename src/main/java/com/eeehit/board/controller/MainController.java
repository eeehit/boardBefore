package com.eeehit.board.controller;

import com.eeehit.board.domain.Article;
import com.eeehit.board.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by sppark on 2017-05-21.
 */
@Controller
@RequestMapping("/")
@EnableAutoConfiguration
public class MainController {
    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView main() {
        List<Article> articleList = articleService.getArticleList();
        ModelAndView mv = new ModelAndView("main");
        mv.addObject("articleList", articleList);
        return mv;
    }
}