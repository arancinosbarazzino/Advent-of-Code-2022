package Giorno1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Giorno1 {
    public static void main(String[] args) throws FileNotFoundException {
        int somma = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        File file = new File("C:/Users/Samuele/Advent-of-Code-2022/Giorno1/file.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if(line.isBlank()){
                numbers.add(somma);
                somma=0;
            }else{
                somma+=Integer.parseInt(line);
            }
        }
        Collections.sort(numbers, Collections.reverseOrder());
        int totale=0;
        for (int i = 0; i < 3; i++) {
            totale += numbers.get(i);
        }
            System.out.println(totale);
            input.close();
        }
}
