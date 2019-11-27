package cineflex;

import java.util.Scanner;

public final class Perfil extends Cadastro {
    Scanner enter = new Scanner(System.in);
    private String gender, city;
    private int age;
    
    public Perfil() {
        super();
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void gerenciarPerfil() {
        System.out.print(Mensagens.gerenciar(this.getLogin(), this.getAge(), this.getGender(), 
                this.getCity(), this.getEmail(), this.getCPF(), this.getPassword()));
        
        String item = enter.next();
        switch(item.toLowerCase()) {
            case "nome": 
                this.setLogin(enter.next());
                break;
            case "age":
                this.setAge(enter.nextInt());
                break;
            case "gender":
                this.setGender(enter.next());
                break;
            case "city":
                this.setCity(enter.next());
                break;
            default:
                System.out.println("Este campo não pode ser alterado!");
                break;
        }
    }
    
    public void gerenciarFilmes(Filmes p, float price) {
        for (int i = 0; i < 5; i++)
            p.exibirFilmes(i);
        
        System.out.println("Qual filme deseja assitir? ");
        int num = enter.nextInt();
        p.comprarIngresso(num-1, price);
    }
    
    public void painel(Filmes p, float price) {
        System.out.print(Mensagens.painel());
        
        int num = enter.nextInt();
        switch(num) {
            case 1: 
                gerenciarPerfil();
                break;
            case 2:
                gerenciarFilmes(p, price);
                break;
            default:
                return;
        }
        painel(p, price);
    }
}