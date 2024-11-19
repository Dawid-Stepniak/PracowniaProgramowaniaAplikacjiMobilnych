import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        try{
            File myObj = new File("C:\\Users\\student\\Desktop\\Dane_PR2\\Dane_PR2\\liczby.txt");
            Scanner myReader = new Scanner(myObj);
            int zad1=0;
            //zrob liste
            int powerOf3=3;
            int counter=0;
            while(powerOf3<100000){
                
            }
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                int number = Integer.valueOf(data);

                System.out.println(zad1);

            }
            System.out.println(zad1++);
            myReader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Wystąpił błąd");
            e.printStackTrace();
        }
    }
}
