package cineflex;

import java.util.Scanner;

public class Cadastro extends Pessoa {
    Scanner input = new Scanner(System.in);
    
    private String password;
    private String email;
    private final int CPF;
    private String login;

    public Cadastro() {
        super();
        System.out.print("Email: ");
        this.email = input.next();
        System.out.print("Senha: ");
        this.password = input.next();
        System.out.print("Nome: ");
        this.login = input.next();
        System.out.print("CPF: ");
        this.CPF = input.nextInt();
        
        System.out.println("\n === Cadastro efetuado! === \n");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public int getCPF() {
        return CPF;
    }
}
