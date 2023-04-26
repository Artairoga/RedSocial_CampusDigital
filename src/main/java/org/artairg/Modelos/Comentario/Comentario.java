package org.artairg.Modelos.Comentario;

import java.time.LocalDateTime;

public class Comentario {
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
