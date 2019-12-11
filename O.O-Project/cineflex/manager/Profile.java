package cineflex.manager;

import cineflex.person.Person;
import cineflex.movies.Movies;
import java.util.Scanner;

public final class Profile extends Register {
    Scanner enter = new Scanner(System.in);
    private String gender, city;
    private int age;
    
    public Profile(Profile[] p) {
        super(p);
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
                this.getCity(), this.getEmail(), this.getPassword(), this.getType()));
        
        int item = enter.nextInt();
        switch(item) {
            case 1: 
                this.setName(enter.next());
                break;
            case 2:
                this.setAge(enter.nextInt());
                break;
            case 3:
                this.setGender(enter.next());
                break;
            case 4:
                this.setCity(enter.next());
                break;
            case 5:
                this.setPassword(enter.next());
                break;
            default:
                System.out.println("Este campo não pode ser alterado!");
                break;
        }
    }
    
    public void manageMovies(Movies[] movies, Person type) {
        for (int i = 0; i < 5; i++)
            movies[i].showMovies(i);
        
        System.out.println("Qual filme deseja assitir? ");
        int num = enter.nextInt();
        movies[num-1].buyTicket(num-1, type);
    }
    
    public void panel(Movies[] movies, Person type) {
        System.out.print(Messages.panel());
        
        int num = enter.nextInt();
        switch(num) {
            case 1: 
                manageProfile();
                break;
            case 2:
                manageMovies(movies, type);
                break;
            default:
                return;
        }
        panel(movies, type);
    }
}