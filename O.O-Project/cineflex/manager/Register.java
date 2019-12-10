package cineflex.manager;

import cineflex.person.Retired;
import cineflex.person.Student;
import cineflex.person.Other;
import cineflex.person.Person;
import java.util.Scanner;

public class Register {
    Scanner input = new Scanner(System.in);
    
    private String password;
    private String login;
    private String name;
    private Person type;

    public Register() {
        super();
        System.out.print("Login: ");
        this.login = input.next();
 
        System.out.print("Senha: ");
        this.password = input.next();
        
        System.out.print("Nome: ");
        this.name = input.next();
        
        System.out.print("Ocupação: ");
        String aux_type = input.next();
        
        if ("estudante".equals(aux_type.toLowerCase())) {
            this.type = new Student();
        } else if ("aposentado".equals(aux_type.toLowerCase())) {
            this.type = new Retired();
        } else {
            this.type = new Other();
        }
        
        System.out.println("\n === Cadastro efetuado! === \n");
    }

    public Person getType() {
        return type;
    }

    public void setType(Person type) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
