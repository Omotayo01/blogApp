package data.repositories;

import data.models.Article;


import java.util.List;


public interface ArticleRepository {

    Article create(Article owner);

    Article findById(int id);

    long count();

    List<Article> findAll(int id);

    Article findByAuthorOrUserId(int id);

    void delete (Article owner);

    void delete (int id);

    void deleteAll();

    int getSize();
}
