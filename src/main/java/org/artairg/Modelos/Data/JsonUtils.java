package org.artairg.Modelos.Data;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;

public class JsonUtils {
    private static final Gson gson = new Gson();

    public static void guardar(Object objeto, String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
        } catch (Exception ex) {
            System.out.println("Error al guardar archivo JSON: " + ex.getMessage());
        }
    }

    public static <T> T cargar(String rutaArchivo, Class<T> tipo) {
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, tipo);
        } catch (Exception ex) {
            System.out.println("Error al cargar archivo JSON: " + ex.getMessage());
            return null;
        }
    }
}
