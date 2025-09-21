package dev.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FBFeedTest {

    private FBPost p1 = new FBPost("afonso", LocalDateTime.now(), "jogo de futebol", 35, new ArrayList<>());
    private FBPost p2 = new FBPost("carla", LocalDateTime.of(2024, 6, 12, 14, 55), "aulas o dia todo", 58, Arrays.asList("verdade", "seca"));
    private FBPost p3 = new FBPost("carla", LocalDateTime.of(2025, 8, 2, 10, 5), "opinião sobre Java", 12, Arrays.asList("lento", "estruturado", "antigo"));
    private FBPost p4 = new FBPost("diogo", LocalDateTime.now(), "dia de trabalho", 5, new ArrayList<>());
    private FBPost p5 = new FBPost("afonso", LocalDateTime.of(2025, 2, 26, 8, 30), "vou discoteca hoje", 134, Arrays.asList("sextouuu"));
    List<FBPost> lps = Arrays.asList(p1,p2,p3,p4,p5);

    private FBFeed f1, f2, f3;

    @BeforeEach
    void setUp() {
        f1 = new FBFeed();
        f2 = new FBFeed(lps);
        f3 = new FBFeed(f2);
    }

    @Test
    void nrPosts() {
        assertEquals(2, f2.nrPosts("afonso"));
        assertEquals(1, f2.nrPosts("diogo"));
        assertEquals(2, f2.nrPosts("carla"));
    }

    @Test
    void postsOf() {
        List<FBPost> l = f2.postsOf("carla");
        assertTrue(l.equals(Arrays.asList(p2, p3)));
    }

    @Test
    void testPostsOf() {
        List<FBPost> l = f2.postsOf("afonso", LocalDateTime.of(2024, 1, 1, 0, 0), LocalDateTime.of(2025, 5, 1, 0, 0));
        l.forEach(p -> System.out.println(p.toString()));
        assertTrue(l.equals(Arrays.asList(p5)));
    }

    @Test
    void getPost() {
        assertTrue(f2.getPost(2).equals(p3));
        assertTrue(f2.getPost(4).equals(p5));
        assertNull(f2.getPost(10));
    }

    @Test
    void comment() {
        f2.comment(p3, "fantastico");
        assertEquals(p3.getNrComentarios() + 1, f2.getPost(2).getNrComentarios());
    }

    @Test
    void testComment() {
        f2.comment(1, "fantastico");
        assertEquals(p2.getNrComentarios() + 1, f2.getPost(1).getNrComentarios());
    }

    @Test
    void like() {
        f2.like(p4);
        assertEquals(p4.getLikes() + 1, f2.getPost(3).getLikes());
    }

    @Test
    void testLike() {
        f2.like(4);
        assertEquals(p5.getLikes() + 1, f2.getPost(4).getLikes());
    }

    @Test
    void testEquals() {
        assertTrue(f2.equals(f3));
        assertTrue(f3.equals(f2));
        assertFalse(f1.equals(f3));
        assertFalse(f2.equals(null));
    }

}