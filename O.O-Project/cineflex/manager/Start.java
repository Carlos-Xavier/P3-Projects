package cineflex.manager;

import cineflex.movies.Movies;
import java.util.Scanner;

public final class Start {
    static Scanner input = new Scanner(System.in);
    
    public static void start(Movies movie, Profile p[], int i) {
        System.out.print(Messages.welcome());
        
        int num = input.nextInt();
        switch (num) {
            case 1:
                p[i] = new Profile();
                ++i;
                break;
            case 2:
                login(i, p, movie);
                break;
            case 3:
                return;
        }
        start(movie, p, i);
    }
    
    public static void login(int i, Profile p[], Movies movie) {
        System.out.print("Informe seu email: ");
        String login = input.next();
        
        System.out.print("Informe sua senha: ");
        String password = input.next();
        
        boolean flag = true;
        for (int j = 0; j < i; j++)
        {
            if (p[j] != null && (login.equals(p[j].getLogin()) && password.equals(p[j].getPassword())))
            {
                p[j].panel(movie, p[j].getType());
                flag = false;
            }
        }
        if (flag) System.out.println("Login ou Senha inválido!");
    }
}
