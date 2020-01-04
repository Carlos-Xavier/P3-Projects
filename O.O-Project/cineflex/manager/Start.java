package cineflex.manager;

import cineflex.movies.Movies;
import cineflex.exceptions.Exceptions;
import java.util.Scanner;

public final class Start {
    static Scanner input = new Scanner(System.in);
    
    public static void start(Movies[] movies, Profile p[], int i) {
        System.out.print(Messages.welcome());
        
        int num = Exceptions.intNum();
        switch (num) {
            case 1:
                p[i] = new Profile(p);
                ++i;
                break;
            case 2:
                login(i, p, movies);
                break;
            case 3:
                return;
        }
        start(movies, p, i);
    }
    
    public static void login(int i, Profile p[], Movies[] movies) {
        System.out.print("Informe seu email: ");
        String email = input.next();
        
        System.out.print("Informe sua senha: ");
        String password = input.next();
        
        boolean flag = true;
        for (int j = 0; j < i; j++)
        {
            if (p[j] != null && (email.equals(p[j].getEmail()) && password.equals(p[j].getPassword())))
            {
                p[j].panel(movies, p[j]);
                flag = false;
            }
        }
        if (flag) System.out.println("Login ou Senha inválido!");
    }
    
    public static boolean check(Profile p[], String email) {
        boolean flag = true;
        
        for (int j = 0; j < 20; j++)
        {
            if (p[j] != null && email.equals(p[j].getEmail()) )
            {
                flag = false;
            }
        }
        return flag;
    }
}
