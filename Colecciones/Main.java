package Colecciones;

public class Main {
    public static void main(String[] args) {

        LoteriaMexicana loteria = new LoteriaMexicana();

        // Paso 1: Agregar cartas de la lotería mexicana
        loteria.agregarCartas();

        // Paso 2: Imprimir todas las cartas agregadas
        loteria.imprimirCartas();

        // Paso 3: Imprimir cartas en orden aleatorio
        loteria.imprimirCartasAleatorias();
    }
}
