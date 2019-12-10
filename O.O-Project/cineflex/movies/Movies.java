package cineflex.movies;

import cineflex.food.Food;
import cineflex.manager.Messages;
import cineflex.person.Person;
import java.util.Scanner;

public class Movies implements InterfaceFilme {
    Scanner input = new Scanner(System.in);
    private Movie[] movie;

    public void showMovies(int i) {
        String[] schedules = {this.movie[i].getSchedules(0), this.movie[i].getSchedules(1)};
        System.out.print(Messages.movies(this.movie[i].getName(), this.movie[i].getRooms(), schedules, i+1));
    }

    @Override
    public void chooseSeat(int i, String aux, int[] values) {
        if (aux.equals(this.movie[i].getSchedules(0)))
            values = Messages.seats_1(this.movie[i]);
        else
            values = Messages.seats_2(this.movie[i]);
    }

    @Override
    public void buyFood(Person type, int i) {
        Food c = new Food();
        System.out.print(Messages.food(c));
        
        int choice = input.nextInt();
        switch(choice) {
            case 1:
                item(type, c.getPopcorn());
                break;
            case 2:
                item(type, c.getBeverage());
                break;
            case 3:
                item(type, c.getSweet());
                break;
            default:
                break;
        }
    }
    
    @Override
    public void buyTicket(int i, Person type) {
        this.showMovies(i);
        String aux = movieTime(i);
        
        int[] values = new int[2];
        this.chooseSeat(i, aux, values);

        payment(aux, values, type, i);
        System.out.println(" O CineFlex agradece sua compra! ");
    }

    @Override
    public void generateMovies() {
        String[] names = {"Invocação do mal", "Coringa", "O Rei Leão", "Hellboy", "Vingadores: Ultimato"};
        String[][] schedules = {{"8:15", "10:45"},
                               {"9:15", "11:30",},
                               {"10:40", "13:45"},
                               {"13:20", "18:45"},
                               {"19:15", "21:50"}};
        int rooms[] = {1, 2, 3, 4, 5};
        
        this.movie = new Movie[5];
        for (int i = 0; i < 5; i++) {
            this.movie[i] = new Movie(new boolean[5][5], new boolean[5][5]);
            this.movie[i].setName(names[i]);
            this.movie[i].setRooms(rooms[i]);
            this.movie[i].setSchedules(schedules[i]);
            this.movie[i].setPrice(25.99f);
            this.movie[i].setCoins(5);
        }
        System.out.println("ok");
    }

    @Override
    public String movieTime(int i) {
        System.out.println("Qual seção você quer assitir?");
        String value = input.next();
        
        String[] horarios = {this.movie[i].getSchedules(0), this.movie[i].getSchedules(1)};
        if (horarios[0].equals(value) || horarios[1].equals(value))
            return value;
        else {
            System.out.println("Horário inválido");
            return null;
        }
    }

    @Override
    public void payment(String schedule, int[] values, Person type, int i) {
        Messages.payment(this.movie[i]);
        System.out.print(Messages.complete(this.movie[i], type, schedule));
        
        int n = input.nextInt();      
        switch (n) {
            case 1:
                cashPayment(type, i, values);
                break;
            case 2:
                coinPayment(type, i, values);
                break;
            default:
                System.out.println("Opção inválida!");
                payment(schedule, values, type, i);
        }
        
        type.setCoins(type.getCoins() + 1);
        
        System.out.println(" Deseja comprar algo para comer/beber (S/N)? ");
        String choice = input.next();
        if ("s".equals(choice.toLowerCase()) || "sim".equals(choice.toLowerCase())) {
            buyFood(type, i);
        }
        System.out.println("Compra Finalizada com Sucesso!");
    }

    @Override
    public void cashPayment(Person type, int i, int[] values) {
        if (type.getMoney() < this.movie[i].getPrice() - type.getDiscount()) {
                System.out.println("Você não possui dinheiro suficiente!");
        } else {
                confirm(values, i);
                
                float dif = this.movie[i].getPrice() - type.getDiscount();
                type.setMoney(type.getMoney() - dif);
        }
    }

    @Override
    public void coinPayment(Person type, int i, int[] values) {
        if (type.getCoins() < this.movie[i].getCoins()) {
                System.out.println("Você não possui moedas suficientes!");
        } else {
            confirm(values, i);
            
            type.setCoins(type.getCoins() - this.movie[i].getCoins());
        }
        
    }
    
    public void item(Person type, float item_p) {
        if (type.getMoney() < item_p) {
            System.out.println("Você não possui dinheiro suficiente!");
        } else {
            type.setMoney(type.getMoney() - item_p);
        }
    }
    
    public void confirm(int[] values, int i) {
        this.movie[i].setSeats_2(values[0], values[1], true);
    }
}
