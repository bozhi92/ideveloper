package com.hubbleadvance.utils.ideveloper.domain.article;

import com.hubbleadvance.utils.ideveloper.controller.Page;
public class ArticleQuery extends Page {
    private static final long serialVersionUID = 1L;
    private String search;

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
