package Giorno2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/* PARTE 1
 * A=roccia
 * B=carta
 * C=forbici
 *
 * X=roccia = 1 punto
 * Y=carta = 2 punti
 * Z=forbici = 3 punti
 *
 * 3 punti se pareggio
 * 6 se vinco
 *
 * PARTE 2
 * X = perso
 * Y = pareggio
 * Z = vinto
 *
 */
public class Giorno2 {

  public static int Parte1(File file, Scanner input)
    throws FileNotFoundException {
    int punteggio = 0;
    String[] scelte = new String[1];
    while (input.hasNextLine()) {
      String line = input.nextLine();
      scelte = line.split(" ");
      for (int i = 1; i < scelte.length; i++) {
        if (scelte[i].equals("X")) {
          punteggio += 1; //IO ho scelto ROCCIA = 1 PUNTO
          if (scelte[i - 1].equals("A")) {
            punteggio += 3; //ROCCIA pareggio con ROCCIA = 3 PUNTI
          } else if (scelte[i - 1].equals("C")) {
            punteggio += 6; //ROCCIA vince con FORBICI = 6 PUNTI
          }
        } else if (scelte[i].equals("Y")) {
          punteggio += 2; //IO ho scelto CARTA = 2 PUNTI
          if (scelte[i - 1].equals("A")) {
            punteggio += 6; //CARTA vince con ROCCIA = 6 PUNTI
          } else if (scelte[i - 1].equals("B")) {
            punteggio += 3; //CARTA pareggio con CARTA = 3 punti
          }
        } else if (scelte[i].equals("Z")) {
          punteggio += 3; //IO ho scelto FORBICI = 3 PUNTI
          if (scelte[i - 1].equals("B")) {
            punteggio += 6; //FORBICI vince con CARTA = 6 PUNTI
          } else if (scelte[i - 1].equals("C")) {
            punteggio += 3; //FORBICI pareggio con FORBICI = 3 punti
          }
        }
      }
    }
    return punteggio;
  }

  public static int Parte2(File file, Scanner input) {
    int punteggio = 0;
    String[] scelte = new String[1];
    while (input.hasNextLine()) {
      String line = input.nextLine();
      scelte = line.split(" ");
      for (int i = 1; i < scelte.length; i++) {
        if (scelte[i].equals("X")) { //Qui devo perdere, quindi guardo la cosa che mi fa perdere e aggiungo i punti in base a quello
          if (scelte[i - 1].equals("A")) {
            punteggio += 3; //+3 perché ho scelto forbici
          } else if (scelte[i - 1].equals("B")) {
            punteggio += 1; //+1 perché ho scelto roccia
          } else {
            punteggio += 2; //il resto aggiunge 2
          }
        } else if (scelte[i].equals("Z")) {
          punteggio += 6; //Qui vincerò, quindi aggiungo i punti della vittoria
          if (scelte[i - 1].equals("A")) {
            punteggio += 2; //+2 perché ho scelto carta
          } else if (scelte[i - 1].equals("B")) {
            punteggio += 3; //+3 perché ho scelto forbici
          } else {
            punteggio += 1; //il resto aggiunge 1
          }
        } else if (scelte[i].equals("Y")) {
          punteggio += 3; //Qui pareggerò, quindi aggiungo già i punti del pareggio
          if (scelte[i - 1].equals("A")) {
            punteggio += 1; //+1 perché ho scelto roccia
          } else if (scelte[i - 1].equals("B")) {
            punteggio += 2; //+1 perché ho scelto carta
          } else {
            punteggio += 3; //il resto aggiunge 3
          }
        }
      }
    }
    return punteggio;
  }

  public static void main(String[] args) throws FileNotFoundException {
    File file = new File("Giorno2/file.txt");
    Scanner inputparte1 = new Scanner(file);
    Scanner inputparte2 = new Scanner(file);
    int parte1 = Parte1(file, inputparte1);
    System.out.println(parte1);
    int parte2 = Parte2(file, inputparte2);
    System.out.println(parte2);
    inputparte1.close();
    inputparte2.close();
  }
}
