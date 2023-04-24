package org.artairg.Modelos;


import org.artairg.Modelos.Comentario.Comentarios;
import org.artairg.Modelos.Input.Input;
import org.artairg.Modelos.Posts.Imagen;
import org.artairg.Modelos.Posts.Post;
import org.artairg.Modelos.Posts.Texto;
import org.artairg.Modelos.Posts.Video;
import org.artairg.Modelos.Usuario.Usuarios;

import java.util.HashMap;
import java.util.Map;

public class RedSocial {
    private Map<Integer, Usuarios> usuariosList;

    public RedSocial() {
        this.usuariosList = new HashMap<Integer, Usuarios>();
    }

    /**
     * Muestra la lista de usuarios registrados en la red social.
     */
    public void mostrarUsuarios() {
        if (usuariosList == null || usuariosList.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Usuarios:");
            for (Usuarios usuario : usuariosList.values()) {
                System.out.println(usuario.getId() + ".- " + usuario.getNombre() + " (" + usuario.getUsuariosSiguiendo().length + " sigue)" + " (" + usuario.getPosts().length + " tiene publicaciones)");
            }
        }
    }

    /**
     * Crea una red social de prueba.
     */
    public void crearRedSocialTest() {
        usuariosList = new HashMap<Integer, Usuarios>();

        // Creamos algunos usuarios
        Usuarios juan = new Usuarios("Juan", new int[]{}, new Post[]{}, 1);
        Usuarios pedro = new Usuarios("Pedro", new int[]{1}, new Post[]{}, 2);
        Usuarios isa = new Usuarios("Isa", new int[]{1, 2}, new Post[]{}, 3);

        // Agregamos algunas publicaciones
        juan.addPost(new Texto("Mi primera publicación", new Comentarios(), "¡Hola a todos!"),usuariosList);
        pedro.addPost(new Imagen("Vacaciones en la playa", new Comentarios(), "https://example.com/vacaciones.jpg", 800, 600),usuariosList);
        isa.addPost(new Video("Mi concierto en vivo", new Comentarios(), "https://example.com/concierto.mp4", 1080, 3600),usuariosList);

        // Agregamos los usuarios al mapa
        usuariosList.put(juan.getId(), juan);
        usuariosList.put(pedro.getId(), pedro);
        usuariosList.put(isa.getId(), isa);
    }

    /**
     * Muestra la red social.
     */
    private void mostrarRedSocial() {
        System.out.println("Red social:");
        mostrarUsuarios();
    }

    /**
     * Da de alta un usuario.
     */
    private void altaUsuario() {
        System.out.println("Ingrese el nombre del usuario:");
        String nombre = Input.string();
        Usuarios nuevoUsuario = new Usuarios(nombre, new int[]{}, new Post[]{}, usuariosList.size() + 1);
        usuariosList.put(nuevoUsuario.getId(), nuevoUsuario);
        System.out.println("Usuario " + nombre + " dado de alta exitosamente.");
    }

    /**
     * Da de baja un usuario.
     */
    private void bajaUsuario() {
        System.out.print("Ingrese el nombre del usuario a dar de baja: ");
        String nombreUsuario = Input.string();
        boolean usuarioEncontrado = false;

        for (Usuarios usuario : usuariosList.values()) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                usuariosList.remove(usuario);
                usuarioEncontrado = true;
                System.out.println("El usuario '" + nombreUsuario + "' ha sido dado de baja.");
                break;
            }
        }

        if (!usuarioEncontrado) {
            System.out.println("No se encontró al usuario '" + nombreUsuario + "' en la red social.");
        }
    }

    /**
     * Busca un usuario por su nombre.
     *
     * @return El usuario seleccionado.
     */
    private Usuarios buscarUsuario() {
        String nombreUsuario = Input.string("Ingrese el nombre del usuario: ");
        for (Usuarios usuario : usuariosList.values()) {
            if (usuario.getNombre().equalsIgnoreCase(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    /**
     * Agrega un post a un usuario.
     *
     * @param usuario El usuario al que se le agregará el post.
     */
    private void agregarPost(Usuarios usuario) {
        boolean salir = false;
        Post post;
        String contenido;
        String titulo;
        String url;
        int ancho;
        int alto;
        Comentarios comentarios = new Comentarios();
        while (!salir) {
            System.out.println("MENÚ AGREGAR POST");
            System.out.println("1.- Agregar post de texto");
            System.out.println("2.- Agregar post de imagen");
            System.out.println("3.- Agregar post de video");
            System.out.println("4.- Volver al menú anterior");

            int opcion = Input.integer("Seleccione una opción: ");
            try {
                switch (opcion) {
                    case 1:
                        titulo = Input.string("Introduce el título del post: ");
                        contenido = Input.string("Introduce el contenido del post: ");
                        post = new Texto(titulo, new Comentarios(), contenido);
                        usuario.addPost(post,usuariosList);
                        break;
                    case 2:
                        titulo = Input.string("Introduce el título del post: ");
                        url = Input.string("Introduce la url de la imagen : ");
                        ancho = Integer.parseInt(Input.string("Introduce el ancho de la foto: "));
                        alto = Integer.parseInt(Input.string("Introduce el alto de la foto: "));
                        post = new Imagen(titulo, new Comentarios(), url, ancho, alto);
                        usuario.addPost(post,usuariosList);
                        break;
                    case 3:
                        titulo = Input.string("Introduce el título del post: ");
                        url = Input.string("Introduce la url del post: ");
                        ancho = Integer.parseInt(Input.string("Introduce el ancho del video: "));
                        alto = Integer.parseInt(Input.string("Introduce el alto del video: "));
                        post = new Video(titulo, new Comentarios(), url, ancho, alto);
                        usuario.addPost(post,usuariosList);
                        break;
                    case 4:
                        salir = true;
                        return;
                    default:
                        System.out.println("Opción inválida.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Opción inválida.");
            }
        }
        System.out.println("El post se ha agregado con éxito.");
    }

    /**
     * Añadir un usuario a la lista de seguidos
     *
     * @param usuario El usuario que tiene que seguir a otro
     */
    private void seguirUsuario(Usuarios usuario) {
        Usuarios usuarioASeguir = buscarUsuario();
        if (usuarioASeguir != null) {
            usuario.addUsuarioSiguiendo(usuarioASeguir);
            System.out.println("Ahora estás siguiendo a " + usuarioASeguir.getNombre());
        } else {
            System.out.println("El usuario no existe.");
        }
    }

    /**
     * Muestra el menú principal de la red social.
     *
     * @param usuarioSeleccionado El usuario que estas controlando
     */
    private void listarPosts(Usuarios usuarioSeleccionado) {
        System.out.println("POSTS DE " + usuarioSeleccionado.getNombre());
        Post[] posts = usuarioSeleccionado.getPosts();
        for (int i = 0; i < posts.length; i++) {
            Post post = posts[i];
            System.out.println("Título: " + post.getTitulo());
            System.out.println("Contenido: " + post.getClass());
            System.out.println("-----------------------------");
        }
    }

    /**
     * Muestra los usuarios seguidos por el usuario seleccionado
     *
     * @param usuarioSeleccionado El usuario que estas controlando
     */
    private void listarUsuariosSeguidos(Usuarios usuarioSeleccionado) {
        int[] usuariosSeguidos = usuarioSeleccionado.getUsuariosSiguiendo();
        System.out.println("Usuarios seguidos por " + usuarioSeleccionado.getNombre() + ":");
        if (usuariosSeguidos.length == 0) {
            System.out.println("No sigue a ningún usuario.");
        } else {
            for (int usuario : usuariosSeguidos) {
                System.out.println("- " + usuariosList.get(usuario).getNombre());
            }
        }
    }


    /**
     * Menu para el control de usuarios
     *
     * @param usuarioSeleccionado El usuario que estas controlando
     */
    private void menuControlUsuario(Usuarios usuarioSeleccionado) {
        boolean salir = false;
        while (!salir) {
            System.out.println("MENÚ CONTROL USUARIO");
            System.out.println("1.- Añadir post");
            System.out.println("2.- Seguir a otro usuario");
            System.out.println("3.- Listar posts");
            System.out.println("4.- Listar usuarios seguidos");
            System.out.println("5.- Volver al menú principal");

            int opcion = Input.integer("Seleccione una opción: ");
            switch (opcion) {
                case 1:
                    agregarPost(usuarioSeleccionado);
                    break;
                case 2:
                    seguirUsuario(usuarioSeleccionado);
                    break;
                case 3:
                    listarPosts(usuarioSeleccionado);
                    break;
                case 4:
                    listarUsuariosSeguidos(usuarioSeleccionado);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }


    /**
     * Menu principal
     */
    public void menuPrincipal() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1.- Alta usuarios");
            System.out.println("2.- Baja usuarios");
            System.out.println("3.- Control usuario");
            System.out.println("4.- Mostrar red social");
            System.out.println("0.- Salir");
            opcion = Input.integer("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    // Lógica para dar de alta usuarios
                    altaUsuario();
                    break;
                case 2:
                    // Lógica para dar de baja usuarios
                    bajaUsuario();
                    break;
                case 3:
                    // Lógica para el control de usuario
                    Usuarios usuarioSeleccionado = buscarUsuario();
                    if (usuarioSeleccionado != null) {
                        menuControlUsuario(usuarioSeleccionado);
                    } else {
                        System.out.println("El usuario no existe.");
                    }
                    break;
                case 4:
                    mostrarRedSocial();
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 0);
    }
}

