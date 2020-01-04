
package cineflex.exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exceptions {
    static Scanner input = new Scanner(System.in);
    private static int num;
    
    public static int intNum() {
        boolean flag = false;
        while (!flag) {
            try {
                Exceptions.num = Integer.parseInt(input.next());
                flag = true;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Opção Inválida!");
            }
        }
        return Exceptions.num;
    }
}