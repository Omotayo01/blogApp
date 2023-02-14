package data.repositories;

import data.models.Article;
import data.models.Comment;

import java.util.ArrayList;
import java.util.List;

public class CommentRepositoryImplementation implements CommentRepository{

    private int count;
    private List<Comment> commentsMade = new ArrayList<>();


    @Override
    public Comment make(Comment maker) {
        boolean commentHasNotBeenMade = maker.getId() == 0;
        if (commentHasNotBeenMade) {

            maker.setId(generateUserId());
            commentsMade.add(maker);
            count++;
        }
        return maker;
    }

    private int generateUserId() {

        return  count + 1;
    }

    @Override
    public Comment findById(int id) {
        for (Comment comment : commentsMade) {
            if (comment.getId() == id)
                return comment;
        }
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<Comment> findAll(int id) {
        return null;
    }

    @Override
    public Comment findByUserId(int id) {
        return null;
    }

    @Override
    public Comment findByArticleId(int id) {
        return null;
    }

    @Override
    public void delete(Comment maker) {

    }

    @Override
    public void delete(int id) {
        for (Comment comment : commentsMade) {
            if (comment.getId() == id) {
                commentsMade.remove(comment);

                count--;
                break;
            }
        }
    }

    @Override
    public void deleteAll() {
        while (commentsMade.size() > 0) {

            commentsMade.remove(0);
            count--;

        }
    }

    @Override
    public int getSize() {
        return commentsMade.size();
    }
}
