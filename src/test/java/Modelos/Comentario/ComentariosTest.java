package org.artairg.Comentario;

import org.artairg.Modelos.Comentario.Comentario;
import org.artairg.Modelos.Comentario.Comentarios;
import org.junit.Test;
import static org.junit.Assert.*;

public class ComentariosTest {

    @Test
    public void testAgregarComentario() {
        Comentarios comentarios = new Comentarios();
        Comentario comentario = new Comentario("Este es un comentario");
        Comentario comentario2 = new Comentario("Este es el segundo comentario");
        comentarios.agregarComentario(comentario);
        comentarios.agregarComentario(comentario2);
        assertEquals(comentarios.getListaComentarios().size(), 2);
    }
}

