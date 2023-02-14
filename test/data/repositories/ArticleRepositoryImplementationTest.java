package data.repositories;

import data.models.Article;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArticleRepositoryImplementationTest {

    private ArticleRepository articleRepository;

    private Article article;

    @BeforeEach

    public void setUp(){
        articleRepository = new ArticleRepositoryImplementation();
        article = new Article("a", " b");
//       article.setTitle("a");
//        article.setBody("b");
    }

    @Test

    public void saveTheCreatedArticleConfirmThatArticleSavedIsOneTest(){


        articleRepository.create(article);
        assertEquals(1, articleRepository.getSize());
    }

    @Test


    public void saveFirstUserConfirmThatIdOfTheArticleIsOneTest(){
        Article createdArticle = articleRepository.create(article);

        assertEquals(1, createdArticle.getId());
    }

    @Test


    public void saveOneUserConfirmThatIdOfTheUserIsStillOneAfterUpdatingSameArticleTest(){
        Article createdArticle = articleRepository.create(article);

        assertEquals(1, createdArticle.getId());

        createdArticle.setBody("Tee");
        articleRepository.create(createdArticle);
        assertEquals(1, articleRepository.getSize());
        assertEquals(1, articleRepository.count());
        assertEquals(1, createdArticle.getId());
    }

    @Test


    public void createOneArticleAndFindByIdTest(){
        Article createdArticle = articleRepository.create(article);

        assertEquals(1, createdArticle.getId());

        Article foundArticle = articleRepository.findById(1);

        assertEquals(foundArticle, createdArticle);
    }

    @Test
    public void createdAnArticleDeleteTheArticleAndConfirmThatItIsDeletedTest(){
        Article createdArticle = articleRepository.create(article);

        assertEquals(1, articleRepository.getSize());

        assertEquals(1, createdArticle.getId());

        articleRepository.delete(1);

       // System.out.println(userRepository.findById(1));

        assertEquals(0, articleRepository.getSize());
    }

    @Test
    public void saveMultipleArticlesDeleteAllArticlesAndConfirmThatTheyAreAllDeletedTest(){

        articleRepository.create(article);

        article = new Article("cc", "g");
        articleRepository.create(article);
        article = new Article("", "");
        articleRepository.create(article);


        assertEquals(3, articleRepository.getSize());

        articleRepository.deleteAll();


        assertEquals(0, articleRepository.getSize());
    }

}