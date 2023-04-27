package org.artairg.Modelos.Comentario;

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

    public List<Comentario> getListaComentarios() {
        return listaComentarios;
    }

    public void setListaComentarios(List<Comentario> listaComentarios) {
        this.listaComentarios = listaComentarios;
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

