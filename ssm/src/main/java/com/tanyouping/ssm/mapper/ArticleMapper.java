package com.tanyouping.ssm.mapper;

import com.tanyouping.ssm.model.Article;
import com.tanyouping.ssm.param.ArticleQueryParam;
import com.tanyouping.ssm.po.ArticleCustom;

import java.util.List;

public interface ArticleMapper {

    List<Article> selectArticle(ArticleQueryParam Article);

    List<ArticleCustom>listArticle(Integer id);

    List<Article> articles(Integer id);

    Integer saveArticle(Article article);

    Article getArticle(Integer id);

    void removeArticle(Integer id);

    void updateArticle(Article article);
}
