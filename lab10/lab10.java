import java.io.*;
import java.util.*;
import java.nio.*;
import java.nio.file.*;
@SuppressWarnings("unchecked")

public class lab10{
  public static void main(String[] args){
    if(args.length == 0){
        Map<String, String> map = Deserializuj();
        System.out.println("Zawartosc slownika:");
        for(Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " - " + value);
        }
        System.out.println("");
        System.out.println("By dodac tlumaczenie wywolaj: java lab10 add wyraz tlumaczenie");
        System.out.println("By usunac wyraz wywolaj: java lab10 del wyraz");
        System.out.println("By znalezc tlumaczenie wywolaj: java lab10 wyraz");
    }
    else if(args.length == 1){
        Map<String, String> map = Deserializuj();
        for(Map.Entry<String,String> entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            if(key.equals(args[0])){
                System.out.println("Tlumaczenie: " + value);
                return;
            }
            else if(value.equals(args[0])){
                System.out.println("Tlumaczenie: " + key);
                return;
            }
        } 
        System.out.println("Nie znaleziono poszukiwanego wyrazu.");
    }

    else if(args.length == 2 && args[0].compareTo("del") == 0){
        System.out.println("Usunieto wyraz " + args[1] + " ze slownika.");
        String toDelete = new String();
        toDelete.equals(args[1]);
        Map<String, String> map = Deserializuj();
        for(Map.Entry<String, String> entry : map.entrySet()){
            if(entry.getValue().equals(args[1])){
                toDelete = entry.getKey();
                map.remove(toDelete);
            }
        }
        
    }

    else if(args.length == 3 && args[0].compareTo("add") == 0){
        Map<String, String> map = Deserializuj();
        map.put(args[1], args[2]);
        Serializuj(map);
    }
    else{
        System.out.println("Nieprawidlowe wywolanie!");
        System.out.println("");
        System.out.println("By wyswietlic zawartosc slownika wywolaj: java lab10");
        System.out.println("By dodac tlumaczenie wywolaj: java lab10 add wyraz tlumaczenie");
        System.out.println("By usunac wyraz wywolaj: java lab10 del wyraz");
        System.out.println("By znalezc tlumaczenie wywolaj: java lab10 wyraz");
    }
  }

  private static Map<String, String> Deserializuj(){
      Path path = Paths.get("slownik.ser");
      if(Files.exists(path)){
          try{
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("slownik.ser"));
            HashMap<String, String> newHashMap = (HashMap<String, String>)input.readObject();
            input.close();
            return newHashMap;
          }
          catch(Exception e){
              System.err.println("Blad deserializacji!");
          }
      }
      return new HashMap<String, String>();
  }

  private static void Serializuj(Map<String, String> map){
      try{
          ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("slownik.ser"));
          output.writeObject(map);
          output.close();
      }
      catch(IOException e){
          System.err.println("Blad serializacji!");
      }
  }
   
} 
      
