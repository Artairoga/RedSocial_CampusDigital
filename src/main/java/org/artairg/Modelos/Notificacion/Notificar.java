package org.artairg.Modelos.Notificacion;

import org.artairg.Modelos.Usuario.Usuarios;

import java.util.Map;


public class Notificar implements Runnable {
    Map<Integer, Usuarios> listaUsuariosRedSocial;
    Usuarios UsuarioActual;

    public Notificar(Map<Integer, Usuarios> listaUsuariosRedSocial, Usuarios usuarioActual) {
        this.listaUsuariosRedSocial = listaUsuariosRedSocial;
        UsuarioActual = usuarioActual;
    }

    @Override
    public void run() {
        String mensaje = "Se ha creado un nuevo post por " + UsuarioActual.getNombre();
        for (Usuarios usuario : listaUsuariosRedSocial.values()) {
            for (int usuarioSigue : usuario.getUsuariosSiguiendo()) {
                if (usuarioSigue == UsuarioActual.getId()) {
                    System.out.println("El usuario " + usuario.getNombre() + " ha recibido una notificación: " + mensaje +
                            " de parte de " + UsuarioActual.getNombre());
                }
            }
        }
    }

}
