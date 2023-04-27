package Modelos.Notificacion;

import org.artairg.Modelos.Notificacion.Notificacion;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class NotificacionTest {

    @Test
    public void crearNotificacion() {
        Notificacion notificacion = new Notificacion("usuario1", 123, "texto", "usuario2");
        notificacion.setFecha(LocalDateTime.of(2022, 5, 1, 10, 30, 0));

        Assertions.assertEquals("usuario1", notificacion.getUsuarioNotificado());
        Assertions.assertEquals(123, notificacion.getIdContenido());
        Assertions.assertEquals("texto", notificacion.getTipoContenido());
        Assertions.assertEquals("usuario2", notificacion.getUsuarioAccion());
        Assertions.assertEquals(LocalDateTime.of(2022, 5, 1, 10, 30, 0), notificacion.getFecha());
    }
}
