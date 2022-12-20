package Giorno2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * A=roccia 
 * B=carta
 * C=forbici
 * 
 * X=roccia = 1 punto
 * Y=carta = 2 punti
 * Z=forbici = 3 punti
 * 
 * 3 punti se pareggio
 * 6 se vinci
 */
public class Giorno2 {
    public static void main(String[] args) throws FileNotFoundException {
        int punteggio=0;
        String[] scelte = new String[1];
        File file = new File("C:/Users/Samuele/Advent-of-Code-2022/Giorno2/file.txt");
        Scanner input = new Scanner(file);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            scelte=line.split(" ");
            for(int i=1;i<scelte.length;i++){
                if(scelte[i].equals("X")){
                    punteggio+=1;   //IO ho scelto ROCCIA = 1 PUNTO
                    if(scelte[i-1].equals("A")){
                        punteggio+=3; //ROCCIA pareggio con ROCCIA = 3 PUNTI
                    }else if(scelte[i-1].equals("C")){
                        punteggio+=6; //ROCCIA vince con FORBICI = 6 PUNTI
                    }
                }else if(scelte[i].equals("Y")){
                    punteggio+=2;   //IO ho scelto CARTA = 2 PUNTI
                    if(scelte[i-1].equals("A")){
                        punteggio+=6; //CARTA vince con ROCCIA = 6 PUNTI
                    }else if(scelte[i-1].equals("B")){
                        punteggio+=3; //CARTA pareggio con CARTA = 3 punti
                    }
                }else if(scelte[i].equals("Z")){
                    punteggio+=3;   //IO ho scelto FORBICI = 3 PUNTI
                    if(scelte[i-1].equals("B")){
                        punteggio+=6; //FORBICI vince con CARTA = 6 PUNTI
                    }else if(scelte[i-1].equals("C")){
                        punteggio+=3; //FORBICI pareggio con FORBICI = 3 punti
                    }
                }

            }
        }
        System.out.println(punteggio);
        input.close();
    }
}
