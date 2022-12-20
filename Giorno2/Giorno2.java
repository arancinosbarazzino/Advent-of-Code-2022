package Giorno2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * A=roccia = 1 punto
 * B=carta = 2 punti
 * C=forbici = 3 punti
 * 
 * X=roccia
 * Y=carta
 * Z=forbici
 * 
 * 3 punti se pareggio
 * 6 se vinci
 */
public class Giorno2 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] scelte = new String[1];
        File file = new File("C:/Users/Samuele/Advent-of-Code-2022/Giorno2/file.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            scelte=line.split(" ");
            System.out.println(scelte);
        }
    }
}
