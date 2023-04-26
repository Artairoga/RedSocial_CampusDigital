package org.artairg.Modelos.Posts;

import com.google.gson.*;
import org.artairg.Modelos.Comentario.Comentarios;

import java.lang.reflect.Type;

public class Video extends Post implements JsonSerializer<Video>, JsonDeserializer<Video> {
    private String url;
    private int calidad;
    private int duracion;

    public Video() {
        super(null,null);
    }

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
    public Video deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        System.out.println("deserialize");
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String titulo = jsonObject.get("titulo").getAsString();
        Comentarios comentarios = jsonDeserializationContext.deserialize(jsonObject.get("comentarios"), Comentarios.class);
        String url = jsonObject.get("url").getAsString();
        int calidad = jsonObject.get("calidad").getAsInt();
        int duracion = jsonObject.get("duracion").getAsInt();
        return new Video(titulo, comentarios, url, calidad, duracion);
    }

    @Override
    public JsonElement serialize(Video video, Type type, JsonSerializationContext jsonSerializationContext) {
        System.out.println("serialize");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("titulo", video.getTitulo());
        jsonObject.add("comentarios", jsonSerializationContext.serialize(video.getComentarios(), Comentarios.class));
        jsonObject.addProperty("url", video.getUrl());
        jsonObject.addProperty("calidad", video.getCalidad());
        jsonObject.addProperty("duracion", video.getDuracion());
        return jsonObject;
    }
}
