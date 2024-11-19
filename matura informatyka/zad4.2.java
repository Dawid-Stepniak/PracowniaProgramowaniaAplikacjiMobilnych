import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int obliczSilnie(int n) {
        if (n == 0 || n == 1) return 1;
        int wynik = 1;
        for (int i = 2; i <= n; i++) {
            wynik *= i;
        }
        return wynik;
    }
    private static int sumaSilniCyfr(int liczba) {
        int suma = 0;
        while (liczba > 0) {
            int cyfra = liczba % 10;
            suma += obliczSilnie(cyfra);
            liczba /= 10;
        }
        return suma;
    }

    public static void main(String[] args) {
        try {
            File plik = new File("C:\\Users\\student\\Desktop\\Dane_PR2\\Dane_PR2\\liczby.txt");
            Scanner czytnik = new Scanner(plik);
            while (czytnik.hasNextLine()) {
                String linia = czytnik.nextLine();
                int liczba = Integer.parseInt(linia.trim());

                if (liczba == sumaSilniCyfr(liczba)) {
                    System.out.println(liczba);
                }
            }
            czytnik.close();
        } catch (FileNotFoundException e) {
            System.out.println("Wystąpił błąd: plik nie został znaleziony.");
            e.printStackTrace();
        }
    }
}