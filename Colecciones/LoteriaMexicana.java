package Colecciones;

public class LoteriaMexicana {

    private final ArraySet<String> cartas;

    public LoteriaMexicana() {
        this.cartas = new ArraySet<>();
    }

    public void agregarCartas() {
        String[] cartasMexicanas = {
                "El Gallo", "El Diablo", "La Dama", "El Catrín", "El Paraguas", 
                "La Sirena", "La Escalera", "La Botella", "El Barril", "El Árbol", 
                "El Melón", "El Valiente", "El Gorrito", "La Muerte", "La Pera",
                "La Bandera", "El Bandolón", "El Violoncello", "La Garza", "El Sol",
                "La Luna", "La Estrella", "El Cazo", "El Mundo", "El Apache",
                "El Nopal", "El Alacrán", "La Rosa", "La Calavera", "La Campana",
                "El Cantarito", "El Venado", "El Jarocho", "La Mano", "La Rana"
        };

        for (String carta : cartasMexicanas) {
            cartas.add(carta);
        }
    }

    public void imprimirCartas() {
        System.out.println("Cartas agregadas:");
        System.out.println(cartas);
    }

    public void imprimirCartasAleatorias() {
        ArraySet<String> copiaCartas = new ArraySet<>();
        for (String carta : cartas) { // Se utiliza `Iterable` correctamente.
            copiaCartas.add(carta);
        }

        System.out.println("\nCartas en orden aleatorio:");
        while (!copiaCartas.isEmpty()) {
            System.out.println(copiaCartas.removeRandom());
        }
    }
}
