package cineflex;

public class Filme {
    private String nome;
    private String[] horarios;
    private int salas;
    private boolean assentos_1[][], assentos_2[][];
    private float price;
    private int moedas;
    
    public Filme(boolean[][] assentos_1, boolean[][] assentos_2) {
        this.assentos_1 = assentos_1;
        this.assentos_2 = assentos_2;
    }

    public int getMoedas() {
        return moedas;
    }

    public void setMoedas(int moedas) {
        this.moedas = moedas;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getHorarios(int i) {
        return horarios[i];
    }

    public void setHorarios(String[] horarios) {
        this.horarios = horarios;
    }

    public int getSalas() {
        return salas;
    }

    public void setSalas(int salas) {
        this.salas = salas;
    }
    
    public boolean getAssentos_1(int i, int j) {
        return assentos_1[i][j];
    }

    public void setAssentos_1(int i, int j, boolean assentos) {
        this.assentos_1[i][j] = assentos;
    }

    public boolean getAssentos_2(int i, int j) {
        return assentos_2[i][j];
    }

    public void setAssentos_2(int i, int j, boolean assentos) {
        this.assentos_2[i][j] = assentos;
    }
}
