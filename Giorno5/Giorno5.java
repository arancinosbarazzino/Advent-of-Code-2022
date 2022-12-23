package Giorno5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Giorno5 {

    public static String[][] getCratesArray(File file, Scanner input) {
        String[][] array = new String[8][9];
        for (int i = 0; i < 8; i++) {
            // prendo le prime 8 linee perché è dove sono contenute le crates
            String line = input.nextLine().concat(" ");
            // i caratteri sono 35, ma ne aggiungo uno a mano per ottenere un numero
            // divisibile
            ArrayList<String> temp = new ArrayList<String>();
            // arraylist temporaneo dove salvo ogni riga che poi verrà salvata nella matrice
            for (int j = 0; j < 36; j += 4) {
                if (j == 0) {
                    temp.add(line.substring(j, j + 4));
                } else {
                    temp.add(line.substring(j, j + 4));
                }
                // prendo ogni singolo crate (è grande 4 caratteri)
            }
            System.out.println(temp.toString());
            for (int k = 0; k < temp.size(); k++) {
                // qui salvo una riga dell'array nella i-esima riga della matrice
                array[i][k] = temp.get(k);
            }
        }
        return array;
    }

    public static String[][] cleanArrayStrings(String[][] array) {

        String temp = "";
        for (int i = 0; i < array.length; i++) {
            for (int y = 0; y < array[0].length; y++) {
                temp = array[i][y];
                temp = temp.replaceAll("[^A-Za-z0-9]", "");
                // qui pulisco l'array da tutti i caratteri che non sono le lettere che mi
                // servono
                array[i][y] = temp;
            }
        }

        return array;
    }

    public static String[][] moveStrings(String[][] array, File file, Scanner input){
        int nds=0; //numero di lettere da spostare
        int np=0;  //numero di provenienza dei crate
        int na=0;  //numero di arrivo dei crate
        while(input.hasNextLine()){
            String line=input.nextLine();
            if(input.nextLine().startsWith("m")){
                
            }
            for(int i=0;i<nds;i++){

            }
        }
        return array;
    }
    public static String PrimaParte() throws FileNotFoundException {
        String[][] array;
        String risultato = "";
        File file = new File("C:/Users/Samuele/Advent-of-Code-2022/Giorno5/file.txt");
        Scanner input = new Scanner(file);
        array=(moveStrings(cleanArrayStrings(getCratesArray(file, input)),file, input));
        input.close();
        return risultato;
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
