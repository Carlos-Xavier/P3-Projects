package cineflex;

import java.util.Scanner;

public final class Mensagens {

    static Scanner input = new Scanner(System.in);
    public static String mensage;
    
    public static String welcome() {
        mensage = "### Bem vindo ao CineFlex ### \n"
                + " 1 - Cadastrar \n"
                + " 2 - Entrar \n"
                + " 3 - Exit";
        return mensage;
    }
    
    public static String painel() {
        mensage = "=== Painel Inicial === \n"
                + " 1 - Gerenciar Perfil \n"
                + " 2 - Filmes \n"
                + " 3 - Exit";
        return mensage;
    }
    
    public static String gerenciar(String nome, int age, String gender, String city, String email, int CPF, String password) {
        mensage = "=== Gerenciar pefil === \n"
                + " Nome: " + nome + "\n"
                + " Age: " + age + "\n"
                + " Gender: " + gender + "\n"
                + " City: " + city + "\n"
                + " Email " + email + "\n"
                + " CPF " + CPF + "\n"
                + " Password " + password + "\n"
                + " =====================  \n"
                + " Qual campo deseja alterar? ";
        return mensage;
    }
    
    public static String filmes(String filme, int sala, String[] horario, int i) {
        mensage = "============= " + i + " ============= \n"
                + " Nome: " + filme + "   \n"
                + " Sala: " + sala + "    \n"
                + " Horário: " + horario[0] + " | " + horario[1] + "\n"
                + ""; 
        return mensage;
    }
    
    public static void assentos_1(Filme aux) {
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
        
        System.out.print("Letra da fileira: ");
        int i = input.nextInt();
        System.out.print("Número da fileira: ");
        int j = input.nextInt();
        
        if (!aux.getAssentos_1(i, j))
            aux.setAssentos_1(i, j, true);
        else
            System.out.println("Assento indisponível!");
    }
    
    public static void assentos_2(Filme aux) {
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
        
        System.out.print("Letra da fileira: ");
        int i = input.nextInt();
        System.out.print("Número da fileira: ");
        int j = input.nextInt();
        
        if (!aux.getAssentos_2(i, j))
            aux.setAssentos_2(i, j, true);
        else
            System.out.println("Assento indisponível!");
    }
    
    public static String complete(String nome, float price, String horario, float desconto) {
        mensage = " =================== \n"
                + " Filme: " + nome + "\n"
                + " Horário: " + horario + "\n"
                + " Preço: " + price + "\n"
                + " Desconto: " + desconto + "\n"
                + " Total: " + (price - desconto) + "\n"
                + " =================== \n";
        return mensage;
    }
    
    public static String comidas(Comida c) {
        mensage = " =================== \n"
                + "1 - Pipoca: R$ " + c.getPipoca() + "\n"
                + "2 - Bebida: R$ " + c.getBebida() + "\n"
                + "3 - Doce: R$ " + c.getDoce() + "\n"
                + "x - Não comprar nada \n" 
                + " =================== \n"
                + " O que você deseja comprar ? ";        
        return mensage;
    }

    static boolean comidas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
