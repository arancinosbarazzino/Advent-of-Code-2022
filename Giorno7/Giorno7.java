package Giorno7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Giorno7 {

  public static int primaParte(BufferedReader br) throws IOException {
    HashMap<String, Integer> directories=CreaDirectories(br);
    int somma=0;
    for(Integer i : directories.values()){
        if((int)i < 100000){
            somma+=(int)i;
        }
    }
    return somma;
  }

  public static HashMap<String, Integer> CreaDirectories(BufferedReader br) throws IOException {
    HashMap<String, Integer> directories = new HashMap<String, Integer>(); //una mappa che contiene le directory con le relative dimensioni
    String directory;
    Queue<String> oldDirectories = new LinkedList<String>(); //una coda che contiene tutte le directory in cui sono stato
    while (br.ready()) {
      String linea = br.readLine();
      if (linea.startsWith("$ cd")) {
        directory = linea.substring(5);
        oldDirectories.add(directory); //aggiungo sempre le directory in cui entro alla queue in modo da poter tornare indietro se serve
        if (directory == "..") { //caso in cui '$cd ..'
          directory = oldDirectories.poll();
          if (directory == null) { //se la directory è null non c'è niente più sopra quindi sono per forza a "/"
            directory = "/";
          }
        } else if (directory == "/") { //caso in cui '$cd /'
          oldDirectories.clear();
          directory = "/";
        } else if (!directories.containsKey(directory)) { //aggiungo la directory se non c'è già
          directories.put(directory, 0);
        }
      } else if (linea.startsWith("dir")) {
        directory = linea.substring(4);
        if (!directories.containsKey(directory)) { //aggiungo la directory se non c'è già
          directories.put(directory, 0);
        }
      }
    }
    return directories;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("Giorno7/file.txt"));
    System.out.println(primaParte(br));
  }
}
