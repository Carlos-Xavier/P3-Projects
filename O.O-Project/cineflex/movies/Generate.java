package cineflex.movies;

import cineflex.days.Money;
import cineflex.days.Coin;
import cineflex.days.Days;
import cineflex.manager.Messages;

public final class Generate {
    private static Movies[] movie;
    private static float money;
    private static float coin;

    public static float getPrice() {
        return Generate.money;
    }

    public static Movies[] generateMovie() {
        String[] names = {"Invocação do mal", "Coringa", "O Rei Leão", "Hellboy", "Vingadores: Ultimato"};
        String[][] schedules = {{"8:15", "10:45", "14:15"},
                               {"9:15", "11:30", "22:30"},
                               {"10:40", "13:45", "16:30"},
                               {"13:20", "18:45", "21:00"},
                               {"19:15", "21:50", "17:15"}};
        int rooms[] = {1, 2, 3, 4, 5};
        
        Generate.movie = new Movies[5];
        
        int j = Days.random();
        System.out.print(Messages.day(Days.getDay(j)));
        
        Money money = new Money();
        Generate.money = money.getDayPrice(j);
        
        Coin coin = new Coin();
        Generate.coin = coin.getDayPrice(j);
        
        for (int i = 0; i < 5; i++) {
            Generate.movie[i] = new Movies(Generate.movie, names[i], schedules[i], rooms[i], new boolean[5][5], new boolean[5][5], new boolean[5][5], Generate.money, Generate.coin);
        }
        return Generate.movie;
    }
}