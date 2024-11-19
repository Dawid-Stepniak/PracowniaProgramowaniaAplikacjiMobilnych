import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    private static int nwd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        try {
            File plik = new File("liczby.txt");
            Scanner czytnik = new Scanner("C:\\Users\\student\\Desktop\\Dane_PR2\\Dane_PR2\\liczby.txt");
            
            int[] liczby = new int[1000];
            int licznik = 0;
            
            while (czytnik.hasNextInt()) {
                liczby[licznik++] = czytnik.nextInt();
            }
            czytnik.close();
        
            int najlepszyPoczatek = -1;
            int najlepszaDlugosc = 0;
            int najlepszyNwd = 1;

            for (int poczatek = 0; poczatek < licznik; poczatek++) {
                int obecnyNwd = liczby[poczatek];
                int dlugosc = 0;

                for (int i = poczatek; i < licznik; i++) {
                    obecnyNwd = nwd(obecnyNwd, liczby[i]);
                    if (obecnyNwd > 1) {
                        dlugosc++;
                        if (dlugosc > najlepszaDlugosc) {
                            najlepszyPoczatek = poczatek;
                            najlepszaDlugosc = dlugosc;
                            najlepszyNwd = obecnyNwd;
                        }
                    } else {
                        break;
                    }
                }
            }

            if (najlepszyPoczatek != -1) {
                System.out.println("Pierwsza liczba ciągu: " + liczby[najlepszyPoczatek]);
                System.out.println("Długość ciągu: " + najlepszaDlugosc);
                System.out.println("Największy wspólny dzielnik: " + najlepszyNwd);
            } else {
                System.out.println("Nie znaleziono ciągu spełniającego warunki.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Wystąpił błąd: plik nie został znaleziony.");
            e.printStackTrace();
        }
    }
}