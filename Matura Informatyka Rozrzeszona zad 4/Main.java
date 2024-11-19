import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args){
        Path filePath = Path.of("przyklad.txt");
        
        //ZAD 4.1
        try{
            List<String> content = Files.readAllLines(filePath);
            List<String> numbers = new ArrayList<>();
            int howManyNumbers = 0;
            for (String line : content){
                if(line.charAt(0) == line.charAt(line.length()-1)){
                    numbers.add(line);
                    howManyNumbers++;
                }
                
            }
            System.out.println("v-v-v-ZAD 4.1-v-v-v");
            System.out.println(howManyNumbers);
            System.out.println(numbers.get(0));
            System.out.println("-^-^-^-^-^-^-^-^-^-");
            System.out.println();
            
        }
        catch(IOException e){
            System.out.println("Błąd podczas czytania pliku: " + e.getMessage());
        }
        //KONIEC ZAD 4.1

        //ZAD 4.2
        try{
            List<String> content = Files.readAllLines(filePath);
            int numWithMostFactors = 0;
            int numberOfFactors = 0;

            int numWithMostDifferentFactors = 0;
            int differentFactorsFinally = 0;
            for (String line : content){
                int i= 2;
                int factors = 0;
                int factor=0;
                int differentFactors=0;
                int intLine = Integer.parseInt(line);
                while(i<=intLine/2){
                    if(intLine%i==0){
                        factors++;
                        if(i!=factor)
                        {
                            differentFactors++;
                            factor=i;
                        }
                        intLine = intLine/i;

                    }
                    else{
                        i++;
                    }
                }
                if(factors>numberOfFactors){
                    numberOfFactors = factors;
                    numWithMostFactors = Integer.parseInt(line);
                }
                if(differentFactors>differentFactorsFinally){
                    differentFactorsFinally = differentFactors;
                    numWithMostDifferentFactors = Integer.parseInt(line);
                }
                
            }
            numberOfFactors++;
            differentFactorsFinally++;
            System.out.println("v-v-v-ZAD 4.2-v-v-v");
            System.out.println("Liczba z największą ilością czynników ("+numberOfFactors+"): "+numWithMostFactors);
            System.out.println("Liczba z największą ilością różnych czynników ("+differentFactorsFinally+"): "+numWithMostDifferentFactors);
            System.out.println("-^-^-^-^-^-^-^-^-^-");
        }
        catch(NumberFormatException e){
            System.out.println("Błąd: " + e.getMessage());
        }
        catch(IOException e){
            System.out.println("Błąd podczas czytania pliku: " + e.getMessage());
        }

        
    }
}
