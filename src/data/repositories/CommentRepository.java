package data.repositories;

import data.models.Comment;

import java.util.List;

public interface CommentRepository {
    Comment make(Comment maker);

    Comment findById(int id);

    long count();

    List<Comment> findAll(int id);

    Comment findByUserId(int id);

    Comment findByArticleId(int id);

    void delete (Comment maker);

    void delete (int id);

    void deleteAll();

    int getSize();
}
