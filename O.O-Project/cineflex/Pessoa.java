package cineflex;

import java.util.Scanner;

public abstract class Pessoa {
    Scanner input = new Scanner(System.in);
    private float discount;

    public Pessoa() {
        System.out.print("Ocupação: ");
        String type = input.next();
        System.out.print("Ex: [ estudante, médico, aposentado, ... ]: ");
        
        if ("estudante".equals(type) || "aposentado".equals(type)) {
            this.discount = 7.99f;
        } else {
            this.discount = 0f;
        }
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
