package cineflex.manager;

import cineflex.manager.Messages;
import cineflex.person.Person;
import cineflex.movies.Movies;
import java.util.Scanner;

public final class Profile extends Register {
    Scanner enter = new Scanner(System.in);
    private String gender, city;
    private int age;
    
    public Profile() {
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

    public void manageProfile() {
        System.out.print(Messages.manage(this.getName(), this.getAge(), this.getGender(), 
                this.getCity(), this.getLogin(), this.getPassword()));
        
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
    
    public void manageMovies(Movies p, Person type) {
        for (int i = 0; i < 5; i++)
            p.showMovies(i);
        
        System.out.println("Qual filme deseja assitir? ");
        int num = enter.nextInt();
        p.buyTicket(num-1, type);
    }
    
    public void panel(Movies p, Person type) {
        System.out.print(Messages.panel());
        
        int num = enter.nextInt();
        switch(num) {
            case 1: 
                manageProfile();
                break;
            case 2:
                manageMovies(p, type);
                break;
            default:
                return;
        }
        panel(p, type);
    }
}