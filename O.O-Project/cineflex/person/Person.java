package cineflex.person;

import java.util.Scanner;

public class Person {
    Scanner input = new Scanner(System.in);
    private float discount;
    private float discount_3D;
    private float coins;
    private float money;
    private String type;

    public Person() {
        this.coins = 10f;
        this.money = 50.0f;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getCoins() {
        return coins;
    }

    public void setCoins(float coins) {
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

    public float getDiscount_3D() {
        return discount_3D;
    }

    public void setDiscount_3D(float discount_3D) {
        this.discount_3D = discount_3D;
    }
}
