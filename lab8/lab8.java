import java.util.*;
import java.io.*;
import java.lang.*;

public class lab8{
    public static void main(String[] args){
        String input;
        String output;
        float sumaWartosci = 0;
        int ileWartosci = 0;

        try{
            File inputFile = new File(args[0]);
            File outputFile = new File(args[1]);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            
            if(args.length != 2){
				throw new IllegalArgumentException();
			}

            while((input = reader.readLine()) != null){
                ileWartosci++;
                sumaWartosci += Float.parseFloat(input);
            }

            if(ileWartosci == 0){
                throw new ArithmeticException();
            }

            float avg = sumaWartosci / ileWartosci;
            output = String.valueOf(avg);
            writer.write(output);

            writer.close();
            reader.close();
       
        }

    catch(ArithmeticException e){
        System.err.println("Dzielenie przez zero - brak wartosci w pliku wejsciowym!");
    }
    catch(ArrayIndexOutOfBoundsException e){
        System.err.println("Brak podanego pliku wejsciowego i wyjsciowego!");
    }
    catch(IOException e){
        System.err.println("Blad wczytywania pliku!");
    }
    catch(NumberFormatException e){
        System.err.println("Podano nieprawidlowe wartosci w pliku - wymagane sa wartosci liczbowe (float)!");
    }
    catch(IllegalArgumentException e){
        System.err.println("Niewlasciwa liczba plikow - wymagane dwa (in i out)!");
    }
    catch (NullPointerException e) {
    System.out.println("Pusty plik wejsciowy!");
    }

    }
}

