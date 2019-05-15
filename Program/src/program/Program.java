/*John Lambrecht
Program1
5/15/19
It does what the instructions say it should
 */

package program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args){
        Scanner sc;
        try {
            sc = new Scanner(new File("input.txt"));
            while (sc.hasNextLine()) {
                String string = sc.nextLine();
                String [] splitstring = string.split(",");
                int[] split= new int[splitstring.length];
                for (int i = 0; i < splitstring.length; i++) {
                    split[i] = Integer.parseInt(splitstring[i]);
                    System.out.println(split[i]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("error");
        }

    }
}