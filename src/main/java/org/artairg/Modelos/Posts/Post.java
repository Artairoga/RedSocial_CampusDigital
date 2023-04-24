package org.artairg.Modelos.Posts;

import org.artairg.Modelos.Comentario.Comentarios;

//Post. Contendrá fecha y lista de comentarios. Además, podrá ser un texto (que deberá tener un String con el contenido),
// una imagen (deberá tener un título y dimensiones) o un vídeo (que tendrá título, calidad y duración en segundos).
public class Post {
    private static int count = 0;
    private int id;
    private String titulo;
    private Comentarios comentarios;

    public Post(String titulo, Comentarios comentarios) {
        this.id = ++count;
        this.titulo = titulo;
        this.comentarios = comentarios;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Comentarios getComentarios() {
        return comentarios;
    }

    public void mostrarDetalle() {
        System.out.println("Título: " + titulo);
        comentarios.mostrarComentarios();
    }
}





