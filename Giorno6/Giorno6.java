package Giorno6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Giorno6 {

  public static int primaParte(BufferedReader br) throws IOException {
    char[] caratteri = new char[4];
    int i = 0;
    int conta = 0;
    char carattere;
    while (br.ready()) {
      conta++;
      if (i == 4) {
        i = 0;
      }
      carattere = (char) br.read();
      caratteri[i++] = carattere;
      if (conta > 3 && controlloDuplicati(caratteri)) {
        br.close();
        return conta;
      }
    }
    System.out.println("finito file");
    br.close();
    return -1;
  }

  public static boolean controlloDuplicati(char[] array) {
    Set<Character> temp = new HashSet<Character>();
    for (int i = 0; i < array.length; i++) {
      temp.add(array[i]);
    }
    if (temp.size() == array.length) {
      return true;
    }
    return false;
  }

  public static int secondaParte(BufferedReader br) throws IOException {
    char[] caratteri = new char[14];
    int i = 0;
    int conta = 0;
    char carattere;
    while (br.ready()) {
      conta++;
      if (i == 14) {
        i = 0;
      }
      carattere = (char) br.read();
      caratteri[i++] = carattere;
      if (conta > 13 && controlloDuplicati(caratteri)) {
        br.close();
        return conta;
      }
    }
    System.out.println("finito file");
    br.close();
    return -1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("Giorno6/file.txt"));
    System.out.println(primaParte(br));
    System.out.println(secondaParte(br));
    br.close();
  }
}
