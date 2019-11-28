package cineflex;

import java.util.Scanner;

public class Filmes implements InterfaceFilme {
    Scanner input = new Scanner(System.in);
    private Filme[] filme;

    public void exibirFilmes(int i) {
        String[] horarios = {this.filme[i].getHorarios(0), this.filme[i].getHorarios(1)};
        System.out.print(Mensagens.filmes(this.filme[i].getNome(), this.filme[i].getSalas(), horarios, i+1));
    }

    @Override
    public void escolherAssento(int i, String aux, int[] values) {
        if (aux.equals(this.filme[i].getHorarios(0)))
            values = Mensagens.assentos_1(this.filme[i]);
        else
            values = Mensagens.assentos_2(this.filme[i]);
    }

    @Override
    public void comprarComida(Pessoa tipo, int i) {
        Comida c = new Comida();
        System.out.print(Mensagens.comidas(c));
        
        int escolha = input.nextInt();
        switch(escolha) {
            case 1:
                item(tipo, c.getPipoca());
                break;
            case 2:
                item(tipo, c.getBebida());
                break;
            case 3:
                item(tipo, c.getDoce());
                break;
            default:
                break;
        }
    }
    
    @Override
    public void comprarIngresso(int i, Pessoa tipo) {
        this.exibirFilmes(i);
        String aux = horarioFilme(i);
        
        int[] valores = new int[2];
        this.escolherAssento(i, aux, valores);

        pagamento(aux, valores, tipo, i);
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
        int salas[] = {1, 2, 3, 4, 5};
        
        this.filme = new Filme[5];
        for (int i = 0; i < 5; i++) {
            this.filme[i] = new Filme(new boolean[5][5], new boolean[5][5]);
            this.filme[i].setNome(nomes[i]);
            this.filme[i].setSalas(salas[i]);
            this.filme[i].setHorarios(horarios[i]);
            this.filme[i].setPrice(25.99f);
            this.filme[i].setMoedas(5);
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

    @Override
    public void pagamento(String horario, int[] valores, Pessoa tipo, int i) {
        Mensagens.pagamentos(this.filme[i]);
        System.out.print(Mensagens.complete(this.filme[i], tipo, horario));
        
        int n = input.nextInt();      
        switch (n) {
            case 1:
                pagamentoDinheiro(tipo, i, valores);
                break;
            case 2:
                pagamentoMoedas(tipo, i, valores);
                break;
            default:
                System.out.println("Opção inválida!");
                pagamento(horario, valores, tipo, i);
        }
        
        tipo.setMoedas(tipo.getMoedas() + 1);
        
        System.out.println(" Deseja comprar algo para comer/beber (S/N)? ");
        String escolha = input.next();
        if ("s".equals(escolha.toLowerCase()) || "sim".equals(escolha.toLowerCase())) {
            comprarComida(tipo, i);
        }
        System.out.println("Compra Finalizada com Sucesso!");
    }

    @Override
    public void pagamentoDinheiro(Pessoa tipo, int i, int[] valores) {
        if (tipo.getDinheiro() < this.filme[i].getPrice() - tipo.getDesconto()) {
                System.out.println("Você não possui dinheiro suficiente!");
        } else {
                comfirmar(valores, i);
                
                float dif = this.filme[i].getPrice() - tipo.getDesconto();
                tipo.setDinheiro(tipo.getDinheiro() - dif);
        }
    }

    @Override
    public void pagamentoMoedas(Pessoa tipo, int i, int[] valores) {
        if (tipo.getMoedas() < this.filme[i].getMoedas()) {
                System.out.println("Você não possui moedas suficientes!");
        } else {
            comfirmar(valores, i);
            
            tipo.setMoedas(tipo.getMoedas() - this.filme[i].getMoedas());
        }
        
    }
    
    public void item(Pessoa tipo, float item_p) {
        if (tipo.getDinheiro() < item_p) {
            System.out.println("Você não possui dinheiro suficiente!");
        } else {
            tipo.setDinheiro(tipo.getDinheiro() - item_p);
        }
    }
    
    public void comfirmar(int[] valores, int i) {
        this.filme[i].setAssentos_2(valores[0], valores[1], true);
    }
}
