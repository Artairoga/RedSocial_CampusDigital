package org.artairg.Modelos.Notificacion;

import java.time.LocalDateTime;

class Notificacion {
    private String usuarioNotificado;
    private int idContenido;
    private String tipoContenido;
    private String usuarioAccion;
    private LocalDateTime fecha;

    public Notificacion(String usuarioNotificado, int idContenido, String tipoContenido, String usuarioAccion) {
        this.usuarioNotificado = usuarioNotificado;
        this.idContenido = idContenido;
        this.tipoContenido = tipoContenido;
        this.usuarioAccion = usuarioAccion;
        this.fecha = LocalDateTime.now();
    }

    public String getUsuarioNotificado() {
        return usuarioNotificado;
    }

    public int getIdContenido() {
        return idContenido;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public String getUsuarioAccion() {
        return usuarioAccion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}