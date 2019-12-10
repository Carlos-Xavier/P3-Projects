package cineflex.person;

import java.util.Scanner;

public class Person {
    Scanner input = new Scanner(System.in);
    private float discount;
    private int coins;
    private float money;

    public Person() {
        this.coins = 0;
        this.money = 50.0f;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
