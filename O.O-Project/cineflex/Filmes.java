package cineflex;

import java.util.Scanner;

public class Filmes implements InterfaceFilme {
    Scanner input = new Scanner(System.in);
    private Filme[] filme;

    public void exibirFilmes(int i) {
        String[] horarios = {this.filme[i].getHorarios(0), this.filme[i].getHorarios(1)};
        System.out.print(Mensagens.filmes(this.filme[i].getNome(), this.filme[i].getSalas()[0], horarios, i+1));
    }

    @Override
    public void escolherAssento(int i, String aux) {
        if (aux.equals(this.filme[i].getHorarios(0)))
            Mensagens.assentos_1(this.filme[i]);
        else
            Mensagens.assentos_2(this.filme[i]);
    }

    @Override
    public void comprarComida() {
        Comida c = new Comida();
        System.out.print(Mensagens.comidas(c));
        
        int escolha = input.nextInt();
        switch(escolha) {
            case 1:
            case 2:
            case 3:
                System.out.println("Obrigado pela compra, aproveite o filme!");
            default:
                break;
        }
    }
    
    @Override
    public void comprarIngresso(int i, float desconto) {
        this.exibirFilmes(i);
        String aux = horarioFilme(i);
        this.escolherAssento(i, aux);
        
        System.out.print(Mensagens.complete(this.filme[i].getNome(), this.filme[i].getPrice(), aux, desconto));
        
        System.out.println(" Deseja comprar algo para comer/beber (S/N)? ");
        String escolha = input.next();
        if ("s".equals(escolha.toLowerCase()) || "sim".equals(escolha.toLowerCase())) {
            comprarComida();
        } else
            System.out.println(" O CineFlex agradece sua compra! ");
    }

    @Override
    public void gerarFilmes() {
        String[] nomes = {"Invocação do mal", "Coringa", "O Rei Leão", "Hellboy", "Vingadores: Ultimato"};
        String[][] horarios = {{"8:15", "10:45"},
                               {"9:15", "11:30",},
                               {"10:40", "13:45"},
                               {"13:20", "18:45"},
                               {"19:15", "21:50"}};
        int salas[][] = {{1, 2},{2, 4}, {3, 5}, {1, 5}, {3, 4}};
        
        this.filme = new Filme[5];
        for (int i = 0; i < 5; i++) {
            this.filme[i] = new Filme(new boolean[5][5], new boolean[5][5]);
            this.filme[i].setNome(nomes[i]);
            this.filme[i].setSalas(salas[i]);
            this.filme[i].setHorarios(horarios[i]);
            this.filme[i].setPrice(25.99f);
        }
        System.out.println("ok");
    }

    @Override
    public String horarioFilme(int i) {
        System.out.println("Qual seção você quer assitir?");
        String valor = input.next();
        
        String[] horarios = {this.filme[i].getHorarios(0), this.filme[i].getHorarios(1)};
        if (horarios[0].equals(valor) || horarios[1].equals(valor))
            return valor;
        else {
            System.out.println("Horário inválido");
            return null;
        }
    }
}
