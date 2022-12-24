package Giorno5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

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

    public static List<Stack<String>> arrayToList(String[][] array) {
        String[][] arrayT = new String[9][8];
        List<Stack<String>> lista = new ArrayList<Stack<String>>();

        // trasposta
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                arrayT[j][i] = array[i][j];
            }
        }
        // gaming
        for (String[] linea : arrayT) {
            Stack<String> stk = new Stack<>();
            for (int counter = linea.length -1; counter>=0; counter--) {
                String c = linea[counter]; 
                if (c != "") {
                    stk.push(c);
                }
            }
            lista.add(stk);
        }
        return lista;
    }

    public static List<Stack<String>> moveStrings(List<Stack<String>> lista, File file, Scanner input) {
        int nds; // numero di lettere da spostare
        int np; // numero di provenienza dei crate
        int na; // numero di arrivo dei crate
        String[] array1;
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
        System.out.println("\n\n\n");
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line.startsWith("m")) {
                array1 = line.split(" ");
                nds = Integer.parseInt(array1[1]);
                np = Integer.parseInt(array1[3]);
                na = Integer.parseInt(array1[5]);

                Stack<String> startStack = lista.get(np - 1);
                Stack<String> endStack = lista.get(na - 1);
                for (int i = 0; i < nds; i++) {
                    if (!startStack.empty()) {
                        endStack.push(startStack.pop());
                    }
                }
            }
        }
        for (int i = 0; i < lista.size(); i++) {
            if (!lista.get(i).empty()) {
                System.out.println(lista.get(i).toString());
            }
           
        }
        return lista;
    }

    public static void porcodio(String[] array) {
        for (String line : array) {
            System.out.print(line + " ");
        }
    }

    public static String getResults(List<Stack<String>> lista) {
        String risultato = "";
        for (int i = 0; i < lista.size(); i++) {
            if (!lista.get(i).empty()) {
                risultato += lista.get(i).pop();
            }
        }
        return risultato;
    }

    public static void primaParte() throws FileNotFoundException {
        List<Stack<String>> lista = new ArrayList<Stack<String>>();
        File file = new File("C:/Users/Samuele/Advent-of-Code-2022/Giorno5/file.txt");
        Scanner input = new Scanner(file);
        lista = moveStrings(arrayToList(cleanArrayStrings(getCratesArray(file, input))), file, input);
        // for(int i=0;i<lista.size();i++){
        // System.out.println(lista.get(i).toString());
        // }
        System.out.println(getResults(lista));
        input.close();
    }

    public static int secondaParte() throws FileNotFoundException {
        File file = new File("C:/Users/Samuele/Advent-of-Code-2022/Giorno5/file.txt");
        Scanner input = new Scanner(file);
        input.close();
        return 0;
    }

    public static void main(String[] args) throws FileNotFoundException {
        primaParte();
    }
}
