package Giorno7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Giorno7 {
//RICORDATI DI FIXARE STA COSA: POSSONO ESSERCI CARTELLE CHE ENTRANO DENTRO CARTELLE CON LO STESSO NOME DEL PADRE
  public static int primaParte(BufferedReader br) throws IOException {
    HashMap<String, Integer> directories = CreaDirectories(br);
    directories.toString();
    int somma = 0;
    for (Integer i : directories.values()) {
      if (i.intValue() <= 100000) {
        somma += i.intValue();
      }
    }
    return somma;
  }

  public static HashMap<String, Integer> CreaDirectories(BufferedReader br)
    throws IOException {
    HashMap<String, HashSet<String>> files = new HashMap<String, HashSet<String>>();
    HashMap<String, Integer> directories = new HashMap<String, Integer>(); //una mappa che contiene le directory con le relative dimensioni
    Stack<String> oldDirectories = new Stack<String>(); //una coda che contiene tutte le directory in cui sono stato
    String directoryAttuale = "/";
    String directoryDir;
    String file;
    String temp;
    String linea;
    int dimensioneFile;
    while (br.ready()) {
      linea = br.readLine(); //leggo una linea del file
      if (linea.startsWith("$ cd")) {
        directoryAttuale = linea.substring(5);
        if (!directoryAttuale.equals("..") && directoryAttuale != null) {
          oldDirectories.push(directoryAttuale); //aggiungo le directory che diventeranno le precedenti
        }
        if (directoryAttuale.equals("..")) { //caso in cui '$cd ..'
          files.put(directoryAttuale, null);
          directoryAttuale = oldDirectories.pop();
        } else if (directoryAttuale.equals("/")) { //caso in cui '$cd /'
          oldDirectories.clear();
          if (directories.get(directoryAttuale) == null) { //aggiungo "/" a directories solo se non c'è già
            directories.put(directoryAttuale, 0);
          }
          if (files.get(directoryAttuale) == null) {
            files.put(directoryAttuale, new HashSet<String>());
          } else {
            files.put(directoryAttuale, files.get(directoryAttuale));
          }
        } else if (!directories.containsKey(directoryAttuale)) { //aggiungo la directory se non c'è già
          directories.put(directoryAttuale, 0);
          files.put(directoryAttuale, new HashSet<String>());
        }
      } else if (linea.startsWith("dir")) { //caso in cui c'è una directory ESEMPIO: dir fajfaj
        directoryDir = linea.substring(4);
        if (!directories.containsKey(directoryDir)) { //se la directory non esiste ancora la creo
          directories.put(directoryDir, 0);
        }
      } else if (!linea.startsWith("$ ls")) { //caso in cui c'è un file ESEMPIO: 152491 pisello
        dimensioneFile =
          Integer.parseInt(linea.substring(0, linea.indexOf(" "))); //ottengo dimensione del file
        file = linea.substring(linea.indexOf(" ") + 1, linea.length()); //ottengo nome del file
        if (
          files.get(directoryAttuale) != null &&
          !(files.get(directoryAttuale).contains(file))
        ) { //se non ho già trovato questo file in questa directory allora lo aggiungo
          //NB: LO STESSO FILE PUÒ TROVARSI IN + DIRECTORY CON DIMENSIONI DIVERSE!!!!!
          files.get(directoryAttuale).add(file);
          int somma;
          Stack<String> appoggio = new Stack<String>();
          while (!oldDirectories.isEmpty()) { //aggiungo la dimensione del file a tutte le cartelle padri della cartella attuale
            somma = 0;
            temp = oldDirectories.pop();
            somma = directories.get(temp);
            somma += dimensioneFile;
            directories.replace(temp, somma);
            appoggio.push(temp);
          }
          oldDirectories.addAll(appoggio);
          appoggio.clear();
        }
      }
      linea = br.readLine();
    }
    return directories;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("Giorno7/file.txt"));
    System.out.println(primaParte(br));
    // HashMap<String, Integer> directories = CreaDirectories(br);
    // if (directories.get("/") != null) {
    //   System.out.println("pise");
    // }
  }
}
