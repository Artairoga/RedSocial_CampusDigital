package org.artairg.Modelos.Comentario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Comentarios {
    private List<Comentario> listaComentarios;

    public Comentarios() {
        this.listaComentarios = new ArrayList<>();
    }

    public void agregarComentario(Comentario comentario) {
        listaComentarios.add(comentario);
    }

    public void mostrarComentarios() {
        if (listaComentarios.isEmpty()) {
            System.out.println("No hay comentarios.");
        } else {
            System.out.println("Comentarios:");
            for (Comentario comentario : listaComentarios) {
                comentario.mostrarComentario();
                System.out.println();
            }
        }
    }
}

class Comentario {
    private String texto;
    private LocalDateTime fecha;

    public Comentario(String texto) {
        this.texto = texto;
        this.fecha = LocalDateTime.now();
    }

    public String getTexto() {
        return texto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void mostrarComentario() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Comentario: " + texto);
    }
}
