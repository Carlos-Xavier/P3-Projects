package cineflex.manager;

import cineflex.person.Retired;
import cineflex.person.Student;
import cineflex.person.Other;
import cineflex.person.Person;
import cineflex.manager.validate.Email;
import cineflex.movies.Generate;
import java.util.Scanner;

public class Register {
    Scanner input = new Scanner(System.in);
    
    private String password;
    private String email;
    private String name;
    private Person type;
    private String[][] historic;

    public Register(Profile[] p) {
        super();
        
        System.out.print("Email: ");
        this.email = Email.email(p);
 
        System.out.print("Senha: ");
        this.password = input.next();
        
        System.out.print("Nome: ");
        this.name = input.next();
        
        System.out.print("Ocupação: ");
        String aux_type = input.next();
        
        this.historic = new String[10][6];
        
        if ("estudante".equals(aux_type.toLowerCase())) {
            this.type = new Student(Generate.getPrice(), aux_type);
        } else if ("aposentado".equals(aux_type.toLowerCase())) {
            this.type = new Retired(Generate.getPrice(), aux_type);
        } else {
            this.type = new Other(Generate.getPrice(), aux_type);
        }
        
        System.out.println("\n === Cadastro efetuado! === \n");
    }

    public String getHistoric(int i, int j) {
        return historic[i][j];
    }

    public void setHistoric(int i, int j, String historic) {
        this.historic[i][j] = historic;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
