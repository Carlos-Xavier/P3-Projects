package cineflex.movies;

import cineflex.exceptions.Exceptions;
import cineflex.food.Beverage;
import cineflex.food.Food;
import cineflex.food.Popcorn;
import cineflex.food.Sweet;
import cineflex.manager.Messages;
import cineflex.manager.Profile;
import cineflex.person.Person;
import java.util.Scanner;

public class Movies extends Movie implements InterfaceMovie {
    Scanner input = new Scanner(System.in);
    private Movie[] movie;
    private float price_3D;

    public Movies(Movie[] movie, String name, String[] schedules, int rooms, boolean[][] seats_1, boolean[][] seats_2, boolean[][] seats_3D, float price, float coins) {
        super(name, schedules, rooms, seats_1, seats_2, seats_3D, price, coins);
        this.movie = movie;
    }

    public void showMovies(int i) {
        String[] schedules = {this.movie[i].getSchedules(0), this.movie[i].getSchedules(1), this.movie[i].getSchedules(2)};
        System.out.print(Messages.movies(this.movie[i].getName(), this.movie[i].getRooms(), schedules, i+1));
    }

    @Override
    public int[] chooseSeat(int i, String aux, int[] values) {
        if (aux.equals(this.movie[i].getSchedules(0)))
            values = Messages.seats_1(this.movie[i]);
        else if (aux.equals(this.movie[i].getSchedules(1)))
            values = Messages.seats_2(this.movie[i]);
        else
            values = Messages.seats3D(this.movie[i]);
        return values;
    }

    @Override
    public void buyFood(Person type, int i) {
        Popcorn p = new Popcorn();
        Beverage b = new Beverage();
        Sweet s = new Sweet();
        System.out.print(Messages.food(p, b, s));
        
        int choice = Exceptions.intNum();
        switch(choice) {
            case 1:
                item(type, p.getPrice());
                break;
            case 2:
                item(type, b.getPrice());
                break;
            case 3:
                item(type, s.getPrice());
                break;
            default:
                return;
        }
        buyFood(type, i);
    }
    
    @Override
    public void buyTicket(int i, Profile user) {
        this.showMovies(i);
        String aux = movieTime(i);
        
        if (aux != null) {
            int[] chosenSeat = new int[2];
            chosenSeat = this.chooseSeat(i, aux, chosenSeat);

            this.price_3D = 0.0f;
            if (this.movie[i].getSchedules(2).equals(aux)) {
                this.price_3D = user.getType().getDiscount_3D();
            }
            
            int[] priceChoice = new int[1];
            String flag = payment(aux, chosenSeat, user, i, priceChoice);
            float priceFood = foodCheck(user.getType(), i);

            if ("coin".equals(flag)) {
                historic(user, this.movie[i], aux, this.price_3D, priceChoice, chosenSeat);
                System.out.print(Messages.completeMovieCoin(this.movie[i], user.getType(), aux, priceFood));
            } else if ("money".equals(flag)) {
                historic(user, this.movie[i], aux, this.price_3D, priceChoice, chosenSeat);
                System.out.print(Messages.completeMovieMoney(this.movie[i], user.getType(), aux, priceFood, this.price_3D));
            } else {
                System.out.print(Messages.completeFood(user.getType(), priceFood, this.price_3D));
            }

            System.out.println(" O CineFlex agradece sua compra! ");
        }
    }

    @Override
    public String movieTime(int i) {
        System.out.println("Qual seção você quer assitir?");
        String value = input.nextLine();
        
        String[] schedules = {this.movie[i].getSchedules(0), this.movie[i].getSchedules(1), this.movie[i].getSchedules(2)};
        if (schedules[0].equals(value) || schedules[1].equals(value) || schedules[2].equals(value))
            return value;
        else {
            System.out.println("Horário inválido");
            return null;
        }
    }

    @Override
    public String payment(String schedule, int[] chosenSeat, Profile user, int i, int[] priceChoice) {
        System.out.print(Messages.payment(this.movie[i]));
        
       int n = Exceptions.intNum();      
        priceChoice[0] = n;
        switch (n) {
            case 1:
                return cashPayment(user.getType(), schedule, i, chosenSeat);
            case 2:
                return coinPayment(user.getType(), schedule, i, chosenSeat);
            default:
                System.out.println("Opção inválida!");
                return payment(schedule, chosenSeat, user, i, priceChoice);
        }
    }

    @Override
    public String cashPayment(Person type, String schedule, int i, int[] chosenSeat) {
        if (type.getMoney() < this.movie[i].getPrice() - type.getDiscount()) {
            System.out.println("Você não possui dinheiro suficiente!");
            return "money";
        } else {
            if (this.movie[i].getSchedules(2).equals(schedule)) {
                if (type.getMoney() < this.movie[i].getPrice() - type.getDiscount() - type.getDiscount_3D()) {
                    System.out.println("Você não possui dinheiro suficiente!");
                    return "money";
                } else {
                    type.setMoney(type.getMoney() - type.getDiscount_3D());
                }
            }
            confirm(chosenSeat, i, schedule);
            
            float dif = (this.movie[i].getPrice() - type.getDiscount());
            type.setMoney(type.getMoney() - dif);
            type.setCoins(type.getCoins() + 1);
            return "money";
        }
    }

    @Override
    public String coinPayment(Person type, String schedule, int i, int[] chosenSeat) {
        if (type.getCoins() < this.movie[i].getCoins()) {
                System.out.println("Você não possui moedas suficientes!");
                return "coin";
        } else {
            confirm(chosenSeat, i, schedule);
            
            type.setCoins(type.getCoins() - this.movie[i].getCoins());
            type.setCoins(type.getCoins() + 1);
            return "coin";
        }
    }
    
    public void historic(Profile user, Movie aux, String schedule, float price_3D, int[] priceChoice, int[] seats) {
        int i = 0;
        while (user.getHistoric(i, 0) != null) {
            ++i;
        }
        
        float value = aux.getPrice() - user.getType().getDiscount() + price_3D;
        user.setHistoric(i, 0, aux.getName());
        user.setHistoric(i, 1, schedule);
        
        if (priceChoice[0] == 1) {
            user.setHistoric(i, 2, Float.toString(value));
        } else {
            user.setHistoric(i, 3, Float.toString(aux.getCoins()));
        }
        user.setHistoric(i, 4, Integer.toString(seats[0]));
        user.setHistoric(i, 5, Integer.toString(seats[1]));
    }
    
    public float foodCheck(Person type, int i) {
        float before = type.getMoney();
        
        System.out.println(" Deseja comprar algo para comer/beber (S/N)? ");
        String choice = input.next();
        if ("s".equals(choice.toLowerCase()) || "sim".equals(choice.toLowerCase())) {
            buyFood(type, i);
        }
        
        float after = type.getMoney();
        return before - after;
    }
    
    public void item(Person type, float item_p) {
        if (type.getMoney() < item_p) {
            System.out.println("Você não possui dinheiro suficiente!");
        } else {
            type.setMoney(type.getMoney() - item_p);
        }
    }
    
    public void confirm(int[] chosenSeat, int i, String aux) {
        if (this.movie[i].getSchedules(0).equals(aux)) {
            this.movie[i].setSeats_1(chosenSeat[0], chosenSeat[1], true);
        } else if (this.movie[i].getSchedules(1).equals(aux)){
            this.movie[i].setSeats_2(chosenSeat[0], chosenSeat[1], true);
        } else {
            this.movie[i].setSeats_3D(chosenSeat[0], chosenSeat[1], true);
        }
    } 
}
