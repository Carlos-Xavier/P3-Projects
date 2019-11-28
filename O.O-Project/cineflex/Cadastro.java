package cineflex;

import java.util.Scanner;

public class Cadastro {
    Scanner input = new Scanner(System.in);
    
    private String password;
    private String login;
    private String nome;
    private Pessoa type;

    public Cadastro() {
        super();
        System.out.println("Login: ");
        this.login = input.next();
 
        System.out.print("Senha: ");
        this.password = input.next();
        
        System.out.print("Nome: ");
        this.nome = input.next();
        
        System.out.print("Ocupação: ");
        String aux_type = input.next();
        
        if ("estudante".equals(aux_type.toLowerCase())) {
            this.type = new Estudante();
        } else if ("aposentado".equals(aux_type.toLowerCase())) {
            this.type = new Aposentado();
        } else {
            this.type = new Outro();
        }
        
        System.out.println("\n === Cadastro efetuado! === \n");
    }

    public Pessoa getType() {
        return type;
    }

    public void setType(Pessoa type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String email) {
        this.login = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
