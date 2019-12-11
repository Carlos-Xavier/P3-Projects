package cineflex.movies;

import cineflex.food.Food;
import cineflex.manager.Messages;
import cineflex.person.Person;
import java.util.Scanner;

public class Movies extends Movie implements InterfaceMovie {
    Scanner input = new Scanner(System.in);
    private Movie[] movie;

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
        values = this.chooseSeat(i, aux, values);

        boolean flag = payment(aux, values, type, i);
        float priceFood = foodCheck(type, i);
        
        float value_3D = 0.0f;
        if (this.movie[i].getSchedules(2).equals(aux)) {
            value_3D = type.getDiscount_3D();
        }
        
        if (flag) {
            System.out.print(Messages.completeMovie(this.movie[i], type, aux, priceFood, value_3D));
        } else {
            System.out.print(Messages.completeFood(type, priceFood, value_3D));
        }
       
        System.out.println(" O CineFlex agradece sua compra! ");
    }

    @Override
    public String movieTime(int i) {
        System.out.println("Qual seção você quer assitir?");
        String value = input.next();
        
        String[] schedules = {this.movie[i].getSchedules(0), this.movie[i].getSchedules(1), this.movie[i].getSchedules(2)};
        if (schedules[0].equals(value) || schedules[1].equals(value) || schedules[2].equals(value))
            return value;
        else {
            System.out.println("Horário inválido");
            return null;
        }
    }

    @Override
    public boolean payment(String schedule, int[] values, Person type, int i) {
        System.out.print(Messages.payment(this.movie[i]));
        
        int n = input.nextInt();      
        switch (n) {
            case 1:
                return cashPayment(type, schedule, i, values);
            case 2:
                return coinPayment(type, schedule, i, values);
            default:
                System.out.println("Opção inválida!");
                return payment(schedule, values, type, i);
        }
    }

    @Override
    public boolean cashPayment(Person type, String schedule, int i, int[] values) {
        if (type.getMoney() < this.movie[i].getPrice() - type.getDiscount()) {
            System.out.println("Você não possui dinheiro suficiente!");
            return false;
        } else {
            if (this.movie[i].getSchedules(2).equals(schedule)) {
                if (type.getMoney() < this.movie[i].getPrice() - type.getDiscount() - type.getDiscount_3D()) {
                    System.out.println("Você não possui dinheiro suficiente!");
                    return false;
                } else {
                    type.setMoney(type.getMoney() - type.getDiscount_3D());
                }
            }
            confirm(values, i, schedule);
                
            float dif = (this.movie[i].getPrice() - type.getDiscount());
            type.setMoney(type.getMoney() - dif);
            type.setCoins(type.getCoins() + 1);
            return true;
        }
    }

    @Override
    public boolean coinPayment(Person type, String schedule, int i, int[] values) {
        if (type.getCoins() < this.movie[i].getCoins()) {
                System.out.println("Você não possui moedas suficientes!");
                return false;
        } else {
            confirm(values, i, schedule);
            
            type.setCoins(type.getCoins() - this.movie[i].getCoins());
            type.setCoins(type.getCoins() + 1);
            return true;
        }
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
    
    public void confirm(int[] values, int i, String aux) {
        if (this.movie[i].getSchedules(0).equals(aux)) {
            this.movie[i].setSeats_1(values[0], values[1], true);
        } else if (this.movie[i].getSchedules(1).equals(aux)){
            this.movie[i].setSeats_2(values[0], values[1], true);
        } else {
            this.movie[i].setSeats_3D(values[0], values[1], true);
        }
    }
}
