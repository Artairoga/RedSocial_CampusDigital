package org.artairg.Modelos.Notificacion;

import java.time.LocalDateTime;

public class Notificacion {
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

    public Notificacion() {
    }

    public String getUsuarioNotificado() {
        return usuarioNotificado;
    }

    public void setUsuarioNotificado(String usuarioNotificado) {
        this.usuarioNotificado = usuarioNotificado;
    }

    public int getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(int idContenido) {
        this.idContenido = idContenido;
    }

    public String getTipoContenido() {
        return tipoContenido;
    }

    public void setTipoContenido(String tipoContenido) {
        this.tipoContenido = tipoContenido;
    }

    public String getUsuarioAccion() {
        return usuarioAccion;
    }

    public void setUsuarioAccion(String usuarioAccion) {
        this.usuarioAccion = usuarioAccion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
