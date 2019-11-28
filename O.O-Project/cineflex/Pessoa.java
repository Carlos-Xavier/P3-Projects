package cineflex;

import java.util.Scanner;

public class Pessoa {
    Scanner input = new Scanner(System.in);
    private float desconto;
    private int moedas;
    private float dinheiro;

    public Pessoa() {
        this.moedas = 0;
        this.dinheiro = 50.0f;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public float getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(float dinheiro) {
        this.dinheiro = dinheiro;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }
}
