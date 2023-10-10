import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTest {
    @Test
    public void testCalcularSoma() {
        Calculadora calc = new Calculadora();
        assertEquals(4, calc.calcular("2 + 2"), 0.0001);
    }

    @Test
    public void testCalcularSubtracao() {
        Calculadora calc = new Calculadora();
        assertEquals(0, calc.calcular("2 - 2"), 0.0001);
    }

    @Test
    public void testCalcularMultiplicacao() {
        Calculadora calc = new Calculadora();
        assertEquals(4, calc.calcular("2 * 2"), 0.0001);
    }

    @Test
    public void testCalcularDivisao() {
        Calculadora calc = new Calculadora();
        assertEquals(1, calc.calcular("2 / 2"), 0.0001);
    }

    @Test
    public void testCalcularModulo() {
        Calculadora calc = new Calculadora();
        assertEquals(0, calc.calcular("2 % 2"), 0.0001);
    }

    @Test
    public void testCalcularRaizQuadrada() {
        Calculadora calc = new Calculadora();
        assertEquals(2, calc.calcular("sqrt 4"), 0.0001);
    }

    @Test
    public void testCalcularExpressaoComplexa() {
        Calculadora calc = new Calculadora();
        assertEquals(7, calc.calcular("2 + 2 + 3"), 0.0001);
    }

    @Test
    public void testCalcularDivisaoPorZero() {
        Calculadora calc = new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> calc.calcular("2 / 0"));
    }

    @Test
    public void testCalcularOperacaoInvalida() {
        Calculadora calc = new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> calc.calcular("2 ? 2"));
    }
    @Test
    public void testCalcularVoids(){
        Calculadora calc =  new Calculadora();
        assertThrows(IllegalArgumentException.class, () -> calc.calcular(""));
    }
}