import java.util.ArrayList;

public class Biblioteca {
    ArrayList<Libro> infoLibri = new ArrayList<>();

    public void inserimentoLibro(Libro libro) {
        infoLibri.add(libro);
    }

    public void visualizzazioneLibri() {
        for (Libro libro : infoLibri) {
            System.out.println(libro);
        }
    }

    public void prestitoLibro(String titolo) {
        for (Libro libro : infoLibri) {
            if (libro.getTitolo().equals(titolo)) {
                int numeroCopie = libro.getNumeroCopie();
                if (numeroCopie > 0) {
                    libro.setNumeroCopie(numeroCopie - 1);
                    System.out.println("Prestito effettuato con successo. Copie disponibili: " + (numeroCopie - 1));
                } else {
                    System.out.println("Il libro non è disponibile per il prestito. Copie esaurite.");
                }
                return;
            }
        }
        System.out.println("Libro non trovato nella biblioteca.");
    }
}
