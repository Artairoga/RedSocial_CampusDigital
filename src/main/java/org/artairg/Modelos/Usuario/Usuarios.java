package org.artairg.Modelos.Usuario;

import org.artairg.Modelos.Notificacion.Notificar;
import org.artairg.Modelos.Posts.Post;

import javax.management.Notification;
import java.util.Map;

//Usuario. Contendrá nombre, una lista de los usuarios a los que sigue, lista de posts.
public class Usuarios {
    int id;
    String nombre;
    int[] usuariosSiguiendo;
    Post[] posts;
    Notification[] notificaciones;

    public Usuarios(String nombre, int[] usuariosSiguiendo, Post[] posts, int id) {
        this.nombre = nombre;
        this.usuariosSiguiendo = usuariosSiguiendo;
        this.posts = posts;
        this.id = id;
        this.notificaciones = new Notification[0];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[] getUsuariosSiguiendo() {
        return usuariosSiguiendo;
    }

    public void setUsuariosSiguiendo(int[] usuariosSiguiendo) {
        this.usuariosSiguiendo = usuariosSiguiendo;
    }

    public Post[] getPosts() {
        return posts;
    }

    public void setPosts(Post[] posts) {
        this.posts = posts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Añade un usuario a la lista de usuarios a los que sigue
     *
     * @param usuarioSiguiendo Usuario a añadir
     */
    public void addUsuarioSiguiendo(Usuarios usuarioSiguiendo) {
        int[] usuariosSiguiendo = getUsuariosSiguiendo();
        int[] usuariosSiguiendoNuevo = new int[usuariosSiguiendo.length + 1];
        for (int i = 0; i < usuariosSiguiendo.length; i++) {
            usuariosSiguiendoNuevo[i] = usuariosSiguiendo[i];
        }
        usuariosSiguiendoNuevo[usuariosSiguiendoNuevo.length - 1] = usuarioSiguiendo.getId();
        setUsuariosSiguiendo(usuariosSiguiendoNuevo);
    }

    /**
     * Añade un post a la lista de posts
     *
     * @param post Post a añadir
     */
    public void addPost(Post post, Map<Integer, Usuarios> usuariosList) {
        Post[] posts = getPosts();
        Post[] postsNuevo = new Post[posts.length + 1];
        for (int i = 0; i < posts.length; i++) {
            postsNuevo[i] = posts[i];
        }
        postsNuevo[postsNuevo.length - 1] = post;
        Thread hiloNotificar = new Thread(new Notificar(usuariosList, this));
        hiloNotificar.start();
        setPosts(postsNuevo);
    }




}
