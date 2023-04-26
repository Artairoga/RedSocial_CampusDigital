package org.artairg.Modelos.Posts;

import com.google.gson.*;
import org.artairg.Modelos.Comentario.Comentarios;

import java.lang.reflect.Type;

public class Imagen extends Post implements JsonSerializer<Imagen>, JsonDeserializer<Imagen> {
    private String url;
    private int ancho;
    private int alto;
    public Imagen() {
        super(null,null);
    }
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
    public Imagen deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String titulo = jsonObject.get("titulo").getAsString();
        Comentarios comentarios = context.deserialize(jsonObject.get("comentarios"), Comentarios.class);
        String url = jsonObject.get("url").getAsString();
        int ancho = jsonObject.get("ancho").getAsInt();
        int alto = jsonObject.get("alto").getAsInt();
        return new Imagen(titulo, comentarios, url, ancho, alto);
    }

    @Override
    public JsonElement serialize(Imagen imagen, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("titulo", imagen.getTitulo());
        jsonObject.add("comentarios", context.serialize(imagen.getComentarios()));
        jsonObject.addProperty("url", imagen.getUrl());
        jsonObject.addProperty("ancho", imagen.getAncho());
        jsonObject.addProperty("alto", imagen.getAlto());
        return jsonObject;
    }
}
