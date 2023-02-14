package data.repositories;

import data.models.Article;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryImplementation implements ArticleRepository {

    private int count;
    private List<Article> createdArticle = new ArrayList<>();


    @Override
    public Article create(Article owner) {

        boolean articleHasNotBeenCreated = owner.getId() == 0;
        if (articleHasNotBeenCreated) {

            owner.setId(generateUserId());
            createdArticle.add(owner);
            count++;
        }
        return owner;
    }

    private int generateUserId() {
        return count + 1;
    }

    @Override
    public Article findById(int id) {
        for (Article article : createdArticle) {
            if (article.getId() == id)
                return article;
        }
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Article> findAll(int id) {
        return null;
    }

    @Override
    public Article findByAuthorOrUserId(int id) {
        return null;
    }

    @Override
    public void delete(Article owner) {

    }

    @Override
    public void delete(int id) {

        for (Article article : createdArticle) {
            if (article.getId() == id) {
                createdArticle.remove(article);

                count--;
                break;
            }
        }

    }

    @Override
    public void deleteAll() {

        while (createdArticle.size() > 0) {

            createdArticle.remove(0);
            count--;

        }


    }

    @Override
    public int getSize() {
        return createdArticle.size();
    }
}
