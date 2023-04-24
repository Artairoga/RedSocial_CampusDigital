package org.artairg.Modelos.Posts;

import com.google.gson.*;
import org.artairg.Modelos.Comentario.Comentarios;

import java.lang.reflect.Type;

public class Texto extends Post implements JsonSerializer<Texto>, JsonDeserializer<Texto> {
    private String contenido;

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
        //Comentarios comentarios = (Comentarios) jsonObject.get("comentarios");
        String texto = jsonObject.get("texto").getAsString();
        return new Texto(titulo, new Comentarios(), texto);
    }

    @Override
    public JsonElement serialize(Texto texto, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("titulo", texto.getTitulo());
        jsonObject.addProperty("comentarios", "");
        jsonObject.addProperty("texto", texto.getContenido());
        return jsonObject;
    }
}
