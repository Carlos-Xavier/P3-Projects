package cineflex;

import java.util.Scanner;

public final class Mensagens {

    static Scanner input = new Scanner(System.in);
    public static String mensagem;
    
    public static String welcome() {
        mensagem = "### Bem vindo ao CineFlex ### \n"
                + " 1 - Cadastrar \n"
                + " 2 - Entrar \n"
                + " 3 - Exit";
        return mensagem;
    }
    
    public static String painel() {
        mensagem = "=== Painel Inicial === \n"
                + " 1 - Gerenciar Perfil \n"
                + " 2 - Filmes \n"
                + " 3 - Exit";
        return mensagem;
    }
    
    public static String gerenciar(String nome, int age, String gender, String city, String Login, String password) {
        mensagem = "=== Gerenciar pefil === \n"
                + " Nome: " + nome + "\n"
                + " Age: " + age + "\n"
                + " Gender: " + gender + "\n"
                + " City: " + city + "\n"
                + " Login " + Login + "\n"
                + " Password " + password + "\n"
                + " =====================  \n"
                + " Qual campo deseja alterar? ";
        return mensagem;
    }
    
    public static String filmes(String filme, int sala, String[] horario, int i) {
        mensagem = "============= " + i + " ============= \n"
                + " Nome: " + filme + "   \n"
                + " Sala: " + sala + "    \n"
                + " Horário: " + horario[0] + " | " + horario[1] + "\n"
                + ""; 
        return mensagem;
    }
    
    public static int[] assentos_1(Filme aux) {
        char[] choices = {'A', 'B', 'C', 'D', 'E'};
        
        System.out.println("Escolha seu assento: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(choices[i] + " : ");
            for (int j = 0; j < 5; j++) {
                if (aux.getAssentos_1(i, j))
                    System.out.print("X ");
                else
                    System.out.print("O ");
            }
            System.out.println();
        }  
        for (int i = 1; i <= 5; i++)
            System.out.print("  " + i);
        System.out.println();
        
        int[] values = new int[2]; 
        do {
            System.out.print("Letra da fileira: ");
            values[0] = input.nextInt();
            System.out.print("Número da fileira: ");
            values[1] = input.nextInt();
        } while (!aux.getAssentos_2(values[0], values[1]));
        
        return values;
    }
    
    public static int[] assentos_2(Filme aux) {
        char[] choices = {'A', 'B', 'C', 'D', 'E'};
        
        System.out.println("Escolha seu assento: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(choices[i] + " : ");
            for (int j = 0; j < 5; j++) {
                if (aux.getAssentos_2(i, j))
                    System.out.print("X ");
                else
                    System.out.print("O ");
            }
            System.out.println();
        }  
        for (int i = 1; i <= 5; i++)
            System.out.print("  " + i);
        System.out.println();
        
        int[] values = new int[2]; 
        do {
            System.out.print("Letra da fileira: ");
            values[0] = input.nextInt();
            System.out.print("Número da fileira: ");
            values[1] = input.nextInt();
        } while (!aux.getAssentos_2(values[0], values[1]) && check(values[0]) && 
                check(values[1]));
        
        return values;
    }
    
    public static boolean check(int values) {
        if (values > 4 || values < 0) 
            return false;
        else
            return true;
    }
    
    public static String complete(Filme aux, Pessoa tipo, String horario) {
        mensagem = " =================== \n"
                + " Filme: " + aux.getNome() + "\n"
                + " Horário: " + horario + "\n"
                + " Preço: " + aux.getPrice() + "\n"
                + " Desconto: " + tipo.getDesconto() + "\n"
                + " Total: " + (aux.getPrice() - tipo.getDesconto()) + "\n"
                + " Saldo atual: " + tipo.getDinheiro() + "\n"
                + " =================== \n";
        return mensagem;
    }
    
    public static String comidas(Comida c) {
        mensagem = " =================== \n"
                + "1 - Pipoca: R$ " + c.getPipoca() + "\n"
                + "2 - Bebida: R$ " + c.getBebida() + "\n"
                + "3 - Doce: R$ " + c.getDoce() + "\n"
                + "x - Não comprar nada \n" 
                + " =================== \n"
                + " O que você deseja comprar ? ";        
        return mensagem;
    }
    
    public static String pagamentos(Filme aux) {
        mensagem = " ### Formas de Pagamentos ### \n"
                + "1 - Dinheiro ( R$ " + aux.getPrice() + " ) \n"
                + "2 - Moedas ( R$ " + aux.getMoedas() + " ) \n"
                + " ========================== ";
        return mensagem;
    }
}
