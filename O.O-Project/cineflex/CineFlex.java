package cineflex;

import java.util.Scanner;

public class CineFlex {
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        Filmes filme = new Filmes();
        filme.gerarFilmes();
        Perfil[] p = new Perfil[20];
        inicio(filme, p, 0);
    }
    
    public static void inicio(Filmes filme, Perfil p[], int i) {
        System.out.print(Mensagens.welcome());
        
        int num = input.nextInt();
        switch (num) {
            case 1:
                p[i] = new Perfil();
                ++i;
                break;
            case 2:
                login(i, p, filme);
                break;
            case 3:
                return;
        }
        inicio(filme, p, i);
    }
    
    public static void login(int i, Perfil p[], Filmes filme) {
        System.out.print("Informe seu email: ");
        String login = input.next();
        
        System.out.print("Informe sua senha: ");
        String password = input.next();
        
        boolean flag = true;
        for (int j = 0; j < i; j++)
        {
            if (p[j] != null && (login.equals(p[j].getLogin()) && password.equals(p[j].getPassword())))
            {
                p[j].painel(filme, p[j].getType());
                flag = false;
            }
        }
        if (flag) System.out.println("Login ou Senha inválido!");
    }
}
