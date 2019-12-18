package cineflex.manager;

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
    
    public void manageMovies(Movies[] movies, Profile user) {
        for (int i = 0; i < 5; i++)
            movies[i].showMovies(i);
        
        System.out.println("Qual filme deseja assitir? ");
        int num = enter.nextInt();
        if (num > 0 && num < 6) {
            movies[num-1].buyTicket(num-1, user);
        } else {
            System.out.println("Opção inválida!");
        } 
    }
    
    public void purchasesHistoric(Profile user) {
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            if (this.getHistoric(i, 0) != null) {
                System.out.print(Messages.historic(i, user));
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Você não comprou nenhum ingresso!");
        }
    }
    
    public void cancelPurchase(Profile user, Movies[] movie) {
        System.out.println("Digite o nome do filme que quer cancelar: ");
        String name = enter.next();
        
        // Pegar índice do filme
        int id = 0;
        for (int i = 0; i < 5; i++) {
            if (movie[i].getName().equals(name)) {
                id = i;
            }
        }
        System.out.println("movie: " + id);
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            if (this.getHistoric(i, 0) != null) {
                if (this.getHistoric(i, 0).equals(movie[id].getName())) {
                    this.setHistoric(i, 0, null);
                    this.setHistoric(i, 1, null);
                    
                    if (this.getHistoric(i, 2) != null) {
                        float aux = Float.parseFloat(this.getHistoric(i, 2));
                        user.getType().setMoney(user.getType().getMoney() + aux);
                        this.setHistoric(i, 2, null);
                    } else {
                        float aux = Float.parseFloat(this.getHistoric(i, 3));
                        user.getType().setCoins(user.getType().getCoins() + aux);
                        this.setHistoric(i, 3, null);
                    }
                    
                    // Pegar índice da sala
                    int room = 0;
                    for (int j = 0; j < 3; j++) {
                        if (movie[id].getSchedules(j).equals(this.getHistoric(i, 1))) {
                            room = j;
                        }
                    }
                    System.out.println("sala: " + movie[id].getSchedules(room));
                    int m = Integer.parseInt(this.getHistoric(i, 4));
                    int n = Integer.parseInt(this.getHistoric(i, 5));
                    if (room == 0) {
                        movie[id].setSeats_1(m, n, false);
                    } else if (room == 1) {
                        movie[id].setSeats_2(m, n, false);
                    } else {
                        movie[id].setSeats_3D(m, n, false);
                    }
                    
                    flag = false;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("Você não comprou ingresso para esse filme!");
        } else {
            System.out.println("Compra Cancelada!");
        }
    }
    
    public void panel(Movies[] movies, Profile user) {
        System.out.print(Messages.panel());
        
        int num = enter.nextInt();
        switch(num) {
            case 1: 
                manageProfile();
                break;
            case 2:
                manageMovies(movies, user);
                break;
            case 3:
                purchasesHistoric(user);
                break;
            case 4:
                cancelPurchase(user, movies);
                break;
            default:
                return;
        }
        panel(movies, user);
    }
}