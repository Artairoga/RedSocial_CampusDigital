package org.artairg.Modelos.Posts;

import com.google.gson.*;
import org.artairg.Modelos.Comentario.Comentarios;

import java.lang.reflect.Type;

public class Texto extends Post implements JsonSerializer<Texto>, JsonDeserializer<Texto> {
    private String contenido;

    public Texto() {
        super(null, null);
    }

    public Texto(String titulo, Comentarios comentarios) {
        super(titulo, comentarios);
    }

    public Texto(String titulo, Comentarios comentarios, String contenido) {
        super(titulo, comentarios);
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    public void mostrarDetalle() {
        super.mostrarDetalle();
        System.out.println("Contenido: " + contenido);
    }


    @Override
    public Texto deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String titulo = jsonObject.get("titulo").getAsString();
        Comentarios comentarios = jsonDeserializationContext.deserialize(jsonObject.get("comentarios"), Comentarios.class);
        String contenido = jsonObject.get("contenido").getAsString();
        return new Texto(titulo, comentarios, contenido);
    }

    @Override
    public JsonElement serialize(Texto texto, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("titulo", texto.getTitulo());
        jsonObject.add("comentarios", jsonSerializationContext.serialize(texto.getComentarios()));
        jsonObject.addProperty("contenido", texto.getContenido());
        return jsonObject;
    }
}

