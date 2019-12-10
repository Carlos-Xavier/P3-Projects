package cineflex.manager;

import cineflex.food.Food;
import cineflex.person.Person;
import cineflex.movies.Movie;
import java.util.Scanner;

public final class Messages {

    static Scanner input = new Scanner(System.in);
    public static String message;
    
    public static String welcome() {
        message = "### Bem vindo ao CineFlex ### \n"
                + " 1 - Cadastrar \n"
                + " 2 - Entrar \n"
                + " 3 - Exit \n";
        return message;
    }
    
    public static String panel() {
        message = "=== Painel Inicial === \n"
                + " 1 - Gerenciar Perfil \n"
                + " 2 - Filmes \n"
                + " 3 - Exit";
        return message;
    }
    
    public static String manage(String nome, int age, String gender, String city, String Login, String password) {
        message = "=== Gerenciar pefil === \n"
                + " Nome: " + nome + "\n"
                + " Age: " + age + "\n"
                + " Gender: " + gender + "\n"
                + " City: " + city + "\n"
                + " Login " + Login + "\n"
                + " Password " + password + "\n"
                + " =====================  \n"
                + " Qual campo deseja alterar? ";
        return message;
    }
    
    public static String movies(String filme, int sala, String[] schedules, int i) {
        message = "============= " + i + " ============= \n"
                + " Nome: " + filme + "   \n"
                + " Sala: " + sala + "    \n"
                + " Horário: " + schedules[0] + " | " + schedules[1] + "\n"
                + ""; 
        return message;
    }
    
    public static int[] seats_1(Movie aux) {
        char[] choices = {'A', 'B', 'C', 'D', 'E'};
        
        System.out.println("Escolha seu assento: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(choices[i] + " : ");
            for (int j = 0; j < 5; j++) {
                if (aux.getSeats_1(i, j))
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
        } while (!aux.getSeats_2(values[0], values[1]));
        
        return values;
    }
    
    public static int[] seats_2(Movie aux) {
        char[] choices = {'A', 'B', 'C', 'D', 'E'};
        
        System.out.println("Escolha seu assento: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(choices[i] + " : ");
            for (int j = 0; j < 5; j++) {
                if (aux.getSeats_2(i, j))
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
        } while (!aux.getSeats_2(values[0], values[1]) && check(values[0]) && 
                check(values[1]));
        
        return values;
    }
    
    public static boolean check(int values) {
        if (values > 4 || values < 0) 
            return false;
        else
            return true;
    }
    
    public static String complete(Movie aux, Person tipo, String schedule) {
        message = " =================== \n"
                + " Filme: " + aux.getName() + "\n"
                + " Horário: " + schedule + "\n"
                + " Preço: " + aux.getPrice() + "\n"
                + " Desconto: " + tipo.getDiscount() + "\n"
                + " Total: " + (aux.getPrice() - tipo.getDiscount()) + "\n"
                + " Saldo atual: " + tipo.getMoney() + "\n"
                + " =================== \n";
        return message;
    }
    
    public static String food(Food c) {
        message = " =================== \n"
                + "1 - Pipoca: R$ " + c.getPopcorn() + "\n"
                + "2 - Bebida: R$ " + c.getBeverage() + "\n"
                + "3 - Doce: R$ " + c.getSweet() + "\n"
                + "x - Não comprar nada \n" 
                + " =================== \n"
                + " O que você deseja comprar ? ";        
        return message;
    }
    
    public static String payment(Movie aux) {
        message = " ### Formas de Pagamentos ### \n"
                + "1 - Dinheiro ( R$ " + aux.getPrice() + " ) \n"
                + "2 - Moedas ( R$ " + aux.getCoins() + " ) \n"
                + " ========================== ";
        return message;
    }
}
