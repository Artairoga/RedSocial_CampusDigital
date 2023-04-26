package Modelos.Data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.artairg.Modelos.Comentario.Comentario;
import org.artairg.Modelos.Comentario.Comentarios;
import org.artairg.Modelos.Data.JsonUtils;
import org.artairg.Modelos.Posts.Imagen;
import org.artairg.Modelos.Posts.Post;
import org.artairg.Modelos.Posts.Texto;
import org.artairg.Modelos.Posts.Video;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JsonUtilsTest {

    private static final String RUTA_ARCHIVO = "test.json";

    private Texto texto;
    private Imagen imagen;
    private Video video;

    @Before
    public void setUp() throws Exception {
        // Creamos objetos para serializar
        Comentarios comentarios = new Comentarios();
        comentarios.agregarComentario(new Comentario("Este es un comentario"));
        comentarios.agregarComentario(new Comentario("Este es otro comentario"));

        texto = new Texto("Titulo texto",comentarios, "Contenido texto");
        imagen = new Imagen("Titulo imagen",comentarios,"url imagen", 500, 300);
        video = new Video("Titulo video", comentarios,"url video", 720, 120);
    }

    @After
    public void tearDown() throws Exception {
        // Eliminamos el archivo de prueba creado
        File file = new File(RUTA_ARCHIVO);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testGuardarYRecuperar() throws IOException {
        // Serializamos los objetos
        List<Post> posts = new ArrayList<>();
        posts.add(texto);
        posts.add(imagen);
        posts.add(video);
        JsonUtils.guardar(posts, RUTA_ARCHIVO);

        // Recuperamos los objetos
        List<Post> postsRecuperados = JsonUtils.cargar(RUTA_ARCHIVO, ArrayList.class);

        // Comprobamos que los objetos se hayan recuperado correctamente
        assertNotNull(postsRecuperados);
        assertEquals(posts.size(), postsRecuperados.size());
        assertEquals(texto.getClass(), postsRecuperados.get(0).getClass());
        assertEquals(imagen.getClass(), postsRecuperados.get(1).getClass());
        assertEquals(video.getClass(), postsRecuperados.get(2).getClass());
    }

    @Test
    public void testCargarArchivoInexistente() throws IOException {
        // Intentamos cargar un archivo inexistente
        List<Post> postsRecuperados = JsonUtils.cargar("ruta/archivo/inexistente.json", ArrayList.class);

        // Comprobamos que la carga haya fallado
        assertNull(postsRecuperados);
    }

    @Test
    public void testCargarArchivoMalFormado() throws IOException {
        // Creamos un archivo mal formado
        File file = new File(RUTA_ARCHIVO);
        file.createNewFile();
        file.setReadable(false);

        // Intentamos cargar el archivo mal formado
        List<Post> postsRecuperados = JsonUtils.cargar(RUTA_ARCHIVO, ArrayList.class);

        // Comprobamos que la carga haya fallado
        assertNull(postsRecuperados);
    }
}
