package Giorno5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Giorno5 {

    public static void getCratesArray(File file, Scanner input) {
        String[][] array = new String[7][8];
        for (int i = 0; i < 8; i++) { 
            // prendo le prime 8 linee perché è dove sono contenute le crates
            String line = input.nextLine().concat(" "); 
            // i caratteri sono 35, ma ne aggiungo uno a mano per ottenere un numero divisibile
            ArrayList<String> temp = new ArrayList<String>(); 
            // arraylist temporaneo dove salvo ogni riga che poi verrà salvata nella matrice
            for (int j = 0; j < 36; j += 4) {
                temp.add(line.substring(j, j + 4)); 
                // prendo ogni singolo crate (è grande 4 caratteri)
            }
        }
    }

    // return array;

    public static int PrimaParte() throws FileNotFoundException {
        File file = new File("C:/Users/Samuele/Advent-of-Code-2022/Giorno5/file.txt");
        Scanner input = new Scanner(file);
        getCratesArray(file, input);
        input.close();
        return 0;
    }

    public static int SecondaParte() throws FileNotFoundException {
        File file = new File("C:/Users/Samuele/Advent-of-Code-2022/Giorno5/file.txt");
        Scanner input = new Scanner(file);
        input.close();
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(PrimaParte());
    }
}
