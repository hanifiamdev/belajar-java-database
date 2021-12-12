package hanifiamdev.com.database;

import hanifiamdev.com.database.entity.Comment;
import hanifiamdev.com.database.repository.CommentRepository;
import hanifiamdev.com.database.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RepositoryTest {

    private CommentRepository commentRepository;

    @BeforeEach
    void setUp() {
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testinsert() {
        Comment comment = new Comment("hanif@test.com", "test insert");
        commentRepository.insert(comment);

        Assertions.assertNotNull(comment.getId());
        System.out.println(comment.getId());
    }

    @Test
    void tstFindById() {
        Comment comment = commentRepository.findById(5003);
        Assertions.assertNotNull(comment);
        System.out.println(comment.getId());
        System.out.println(comment.getEmail());
        System.out.println(comment.getComment());

        Comment notFound = commentRepository.findById(1000000);
        Assertions.assertNull(notFound);
    }

    @Test
    void testFindAll() {
        List<Comment> comments = commentRepository.findAll();
        System.out.println(comments.size());
    }

    @Test
    void testFindByEmail() {
        List<Comment> comments = commentRepository.findAllByEmail("hanif@test.com");
        System.out.println(comments.size());

    }
}
