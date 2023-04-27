package Modelos.Posts;

import org.artairg.Modelos.Comentario.Comentario;
import org.artairg.Modelos.Comentario.Comentarios;
import org.artairg.Modelos.Posts.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTest {
    private Post post;

    @BeforeEach
    public void setUp() {
        Comentarios comentarios = new Comentarios();
        comentarios.agregarComentario(new Comentario("Este es un comentario."));
        comentarios.agregarComentario(new Comentario("Este es un comentario."));
        post = new Post("Este es el título del post", comentarios);
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Este es el título del post", post.getTitulo());
    }

    @Test
    public void testGetId() {
        assertEquals(2, post.getId());
    }

    @Test
    public void testSetId() {
        post.setId(10);
        assertEquals(10, post.getId());
    }

    @Test
    public void testGetComentarios() {
        assertEquals(2, post.getComentarios().getListaComentarios().size());
    }
}
