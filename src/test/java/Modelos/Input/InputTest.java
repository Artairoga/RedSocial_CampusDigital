package Modelos.Input;

import org.artairg.Modelos.Input.Input;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputTest {

    @Test
    public void testInteger() {
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int result = Input.integer("Ingrese un número: ");

        assertEquals(123, result);
    }

    @Test
    public void testReal() {
        String input = "3.14";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        double result = Input.real("Ingrese un número real: ");

        assertEquals(3.14, result, 0.01);
    }

    @Test
    public void testString() {
        String input = "Hola Mundo!";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        String result = Input.string("Ingrese un texto: ");

        assertEquals("Hola Mundo!", result);
    }

    @Test
    public void testCharacter() {
        String input = "a";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        char result = Input.character("Ingrese un carácter: ");

        assertEquals('a', result);
    }
}
