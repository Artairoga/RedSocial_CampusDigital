package org.artairg.Modelos.Posts;

import com.google.gson.*;
import org.artairg.Modelos.Comentario.Comentarios;

import java.lang.reflect.Type;

public class Imagen extends Post implements JsonSerializer<Texto>, JsonDeserializer<Texto> {
    private String url;
    private int ancho;
    private int alto;

    public Imagen(String titulo, Comentarios comentarios, String url, int ancho, int alto) {
        super(titulo, comentarios);
        this.url = url;
        this.ancho = ancho;
        this.alto = alto;
    }

    public String getUrl() {
        return url;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle();
        System.out.println("URL: " + url);
        System.out.println("Ancho: " + ancho);
        System.out.println("Alto: " + alto);
    }

    @Override
    public Texto deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }

    @Override
    public JsonElement serialize(Texto texto, Type type, JsonSerializationContext jsonSerializationContext) {
        return null;
    }
}
