import java.util.InputMismatchException;
import java.util.Scanner;

public class Principale {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        boolean logout = false;

        while(!logout) {
            System.out.println("\nMENU' \n1) Inserimento libro \n2) Visualizzazione libri \n3) Prendere in prestito un libro \n4) Logout \nScegliere l'operazione da effettuare ");
            int scelta = input.nextInt();
            input.nextLine();

            switch (scelta) {
                case 1:
                    try {

                        System.out.println("Inserire il titolo del libro: ");
                        String titolo = input.nextLine();
                        System.out.println("Inserire l'autore del libro: ");
                        String autore = input.nextLine();
                        System.out.println("Inserire l'anno di pubblicazione del libro: ");
                        int annoPubblicazione = input.nextInt();
                        System.out.println("Inserire il numero di copie disponibili del libro: ");
                        int numeroCopie = input.nextInt();

                        Libro libro = new Libro(titolo, autore, annoPubblicazione, numeroCopie);
                        biblioteca.inserimentoLibro(libro);
                        System.out.println("Libro inserito con successo!");
                    } catch (InputMismatchException e) {
                        System.out.println("Errore");
                        input.nextLine();
                    }
                    break;

                case 2:
                    System.out.println("Lista di tutti i libri: ");
                    biblioteca.visualizzazioneLibri();
                    break;

                case 3:
                    System.out.println("Inserire il titolo del libro da prendere in prestito: ");
                    String titoloPrestito = input.nextLine();
                    biblioteca.prestitoLibro(titoloPrestito);
                    break;

                case 4:
                    logout = true;
                    System.out.println("Logout effettuato");
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        input.close();
    }
}
