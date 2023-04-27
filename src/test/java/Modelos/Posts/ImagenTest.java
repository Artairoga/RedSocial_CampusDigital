package Modelos.Posts;

import org.artairg.Modelos.Comentario.Comentario;
import org.artairg.Modelos.Comentario.Comentarios;
import org.artairg.Modelos.Posts.Imagen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ImagenTest {

    @Test
    public void testCrearImagen() {
        Comentarios comentarios = new Comentarios();
        Imagen imagen = new Imagen("Título de la imagen",comentarios,"", 800, 600);

        assertEquals("Título de la imagen", imagen.getTitulo());
        assertEquals(800, imagen.getAncho());
        assertEquals(600, imagen.getAlto());
        assertEquals(comentarios, imagen.getComentarios());
    }
}