package com.tanyouping.ssm.po;

import com.tanyouping.ssm.model.Article;

public class ArticleCustom extends Article{

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ArticleCustom{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
