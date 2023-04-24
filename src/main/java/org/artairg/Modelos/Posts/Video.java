package org.artairg.Modelos.Posts;

import com.google.gson.*;
import org.artairg.Modelos.Comentario.Comentarios;

import java.lang.reflect.Type;

public class Video extends Post implements JsonSerializer<Texto>, JsonDeserializer<Texto> {
    private String url;
    private int calidad;
    private int duracion;

    public Video(String titulo, Comentarios comentarios, String url, int calidad, int duracion) {
        super(titulo, comentarios);
        this.url = url;
        this.calidad = calidad;
        this.duracion = duracion;
    }

    public String getUrl() {
        return url;
    }

    public int getCalidad() {
        return calidad;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle();
        System.out.println("URL: " + url);
        System.out.println("Calidad: " + calidad);
        System.out.println("Duración: " + duracion);
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
