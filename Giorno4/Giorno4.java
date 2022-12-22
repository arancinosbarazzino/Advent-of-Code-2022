package Giorno4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Giorno4 {

    public static void StampaArray(String[] palle){
        for(int i=0;i<palle.length;i++){
            System.out.println(palle[i]);
        }
    }
    public static int PrimaParte() throws FileNotFoundException {
        int totale = 0;
        String[] primo, secondo, array;
        File file = new File("C:/Users/Samuele/Advent-of-Code-2022/Giorno4/file.txt");
        Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
            String line = input.nextLine();
            array = line.split(",");
            primo = array[0].split("-");
            secondo = array[1].split("-");
            if ((Integer.parseInt(primo[0])-Integer.parseInt(secondo[0]))*(Integer.parseInt(secondo[1])-Integer.parseInt(primo[1]))>=0) {
                    totale += 1;
            }else if ((Integer.parseInt(secondo[0])-Integer.parseInt(primo[0]))*(Integer.parseInt(primo[1])-Integer.parseInt(secondo[1]))>=0) {
                    totale += 1;
            }
        }
        input.close();
        return totale;
    }

    public static int SecondaParte() throws FileNotFoundException {
        int totale = 0;
        String[] primo, secondo, array;
        File file = new File("C:/Users/Samuele/Advent-of-Code-2022/Giorno4/file.txt");
        Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
            String line = input.nextLine();
            array = line.split(",");
            primo = array[0].split("-");
            secondo = array[1].split("-");   
            }
        input.close();
        return totale;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // System.out.println(PrimaParte());
        System.out.println(SecondaParte());
    }
}
