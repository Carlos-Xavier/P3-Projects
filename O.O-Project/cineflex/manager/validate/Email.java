package cineflex.manager.validate;

import cineflex.manager.Profile;
import cineflex.manager.Start;
import java.util.Scanner;

public final class Email {
    static Scanner input = new Scanner(System.in);
    
    public static String email(Profile[] p) {
        String email = input.next();

        if (Check.validate(email) && Start.check(p, email)) {
          return email;
        } else {
          System.out.print("E-mail inválido.\nEmail: ");
          return email(p);
        }
    }
}