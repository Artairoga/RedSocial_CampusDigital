package Modelos.Notificacion;
import org.artairg.Modelos.Comentario.Comentario;
import org.artairg.Modelos.Comentario.Comentarios;
import org.artairg.Modelos.Posts.Texto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TextoTest {
    private Texto texto;

    @BeforeEach
    public void setUp() {
        Comentarios comentarios = new Comentarios();
        comentarios.agregarComentario(new Comentario("Este es un comentario."));
        comentarios.agregarComentario(new Comentario("Este es un comentario."));
        texto = new Texto("Este es el título del texto",comentarios,"Este es el contenido del texto");
    }

    @Test
    public void testGetTitulo() {
        assertEquals("Este es el título del texto", texto.getTitulo());
    }

    @Test
    public void testGetContenido() {
        assertEquals("Este es el contenido del texto", texto.getContenido());
    }

    @Test
    public void testGetId() {
        assertEquals(2, texto.getId());
    }

    @Test
    public void testSetId() {
        texto.setId(10);
        assertEquals(10, texto.getId());
    }

    @Test
    public void testGetComentarios() {
        assertEquals(2, texto.getComentarios().getListaComentarios().size());
    }
}
