import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testy {//tu testuje kod zanim wkleje do maina
    public static void main(String[] args) {
        try
        {
            File myObj = new File("C:\\Users\\student\\Downloads\\Dane_2205\\Dane_2205\\przyklad.txt");
            Scanner myReader = new Scanner(myObj);
            int i=0;
            boolean pierwsza=false;
            while(myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                int liczba = Integer.parseInt(data);
                int PierwszaCyfra;
                int DrugaCyfra = liczba%10;
                while(liczba>=10){
                    liczba/=10;
                }

                PierwszaCyfra = liczba;

                if(PierwszaCyfra==DrugaCyfra) {
                    if(!pierwsza) {
                        pierwsza=true;
                        System.out.println("Pierwszą taką liczbą jest: " + Integer.parseInt(data));
                    }
                    i++;

                }


            }
            myReader.close();
            System.out.println("Takich liczb jest: "+i);
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Nie znaleziono pliku");
            e.printStackTrace();
        }
    }

}
