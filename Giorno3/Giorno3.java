package Giorno3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Giorno3 {

  public static int PrimaParte() throws FileNotFoundException {
    int somma = 0;
    boolean trovato = true;
    char carattere;
    char[] destra, sinistra;
    File file = new File("Giorno3/file.txt");
    Scanner input = new Scanner(file);
    while (input.hasNextLine()) {
      trovato = true;
      String line = input.nextLine();
      String temp2;
      String temp1;
      temp1 = line.substring(0, line.length() / 2);
      temp2 = line.substring(line.length() / 2, line.length()); // divido le stringhe in 2 e le converto in array
      // di caratteri
      sinistra = temp1.toCharArray();
      destra = temp2.toCharArray();
      for (int i = 0; i < sinistra.length && trovato; i++) {
        for (int k = 0; k < destra.length && trovato; k++) {
          if (destra[k] == sinistra[i]) { // controllo se un carattere coincide e appena coincide faccio
            // finire entrambi i for per passare alla stringa successiva
            carattere = sinistra[i];
            trovato = false;
            if (Character.isUpperCase(carattere)) { // se il carattere è maiuscolo allora la somma va fatta
              // così
              somma += ((carattere - 'A') + 27);
            } else if (Character.isLowerCase(carattere)) {
              somma += carattere - 'a' + 1;
            }
          }
        }
      }
    }
    input.close();
    return somma;
  }

  public static int SecondaParte() throws FileNotFoundException {
    int somma = 0;
    boolean trovato = true;
    char carattere;
    char[] array1, array2, array3;
    File file = new File("Giorno3/file.txt");
    Scanner input = new Scanner(file);
    while (input.hasNextLine()) {
      trovato = true;
      String linea1 = input.nextLine();
      String linea2 = input.nextLine();
      String linea3 = input.nextLine();
      array1 = linea1.toCharArray();
      array2 = linea2.toCharArray();
      array3 = linea3.toCharArray();
      for (int i = 0; i < linea1.length() && trovato; i++) {
        for (int k = 0; k < linea2.length() && trovato; k++) {
          for (int j = 0; j < linea3.length() && trovato; j++) {
            if (array1[i] == array2[k] && array1[i] == array3[j]) {
              carattere = array1[i];
              trovato = false;
              if (Character.isUpperCase(carattere)) {
                somma += ((carattere - 'A') + 27);
              } else if (Character.isLowerCase(carattere)) {
                somma += carattere - 'a' + 1;
              }
            }
          }
        }
      }
    }
    input.close();
    return somma;
  }

  public static void main(String[] args) throws FileNotFoundException {
    System.out.println("prima parte" + PrimaParte());
    System.out.println(SecondaParte());
  }
}
