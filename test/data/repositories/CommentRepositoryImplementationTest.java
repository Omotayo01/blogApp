package data.repositories;

import data.models.Article;
import data.models.Comment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommentRepositoryImplementationTest {
    private CommentRepository commentRepository;

    private Comment comment;

    @BeforeEach

    public void setUp(){
        commentRepository = new CommentRepositoryImplementation();
        comment = new Comment("a");
       comment.setComment("bcd");

    }

    @Test

    public void saveTheMadeCommentAndConfirmThatCommentSavedIsOneTest(){


        commentRepository.make(comment);
        assertEquals(1, commentRepository.getSize());
    }

    @Test


    public void saveFirstCommentConfirmThatIdOfTheCommentIsOneTest(){
        Comment commentMade = commentRepository.make(comment);

        assertEquals(1, commentMade.getId());
    }

    @Test


    public void makeOneCommentConfirmThatIdOfTheCommentIsStillOneAfterUpdatingSameCommentTest(){
        Comment commentMade = commentRepository.make(comment);

        assertEquals(1, commentMade.getId());

        commentMade.setComment("Tee");
        commentRepository.make(commentMade);
        assertEquals(1, commentRepository.getSize());
        assertEquals(1, commentRepository.count());
        assertEquals(1, commentMade.getId());
    }

    @Test


    public void createOneCommentAndFindByIdTest(){
        Comment commentMade = commentRepository.make(comment);

        assertEquals(1, commentMade.getId());

        Comment foundComment = commentRepository.findById(1);

        assertEquals(foundComment, commentMade);
    }

    @Test
    public void createdACommentDeleteTheDeleteAndConfirmThatItIsDeletedTest(){
        Comment commentMade = commentRepository.make(comment);

        assertEquals(1, commentRepository.getSize());

        assertEquals(1, commentMade.getId());

        commentRepository.delete(1);

        // System.out.println(userRepository.findById(1));

        assertEquals(0, commentRepository.getSize());
    }

    @Test
    public void makeMultipleCommentsDeleteAllCommentsAndConfirmThatTheyAreAllDeletedTest(){

        commentRepository.make(comment);

        comment = new Comment("b");
        commentRepository.make(comment);
        comment = new Comment("c");
        commentRepository.make(comment);


        assertEquals(3, commentRepository.getSize());

        commentRepository.deleteAll();


        assertEquals(0, commentRepository.getSize());
    }


}