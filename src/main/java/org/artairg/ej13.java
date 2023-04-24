package org.artairg;


import org.artairg.Modelos.Data.JsonUtils;
import org.artairg.Modelos.RedSocial;

public class ej13 {
    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();
        redSocial=JsonUtils.cargar("redSocial.json",redSocial.getClass());
        redSocial.menuPrincipal();
        JsonUtils.guardar(redSocial, "redSocial.json");
    }
}
