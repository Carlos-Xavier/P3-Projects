package cineflex.manager;

import cineflex.food.Beverage;
import cineflex.food.Popcorn;
import cineflex.food.Sweet;
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
                + " 3 - Exit \n";
        return message;
    }
    
    public static String manage(String nome, int age, String gender, String city, String email, String password, Person type) {
        message = "=== Gerenciar pefil === \n"
                + "1 - Nome: " + nome + "\n"
                + "2 - Idade: " + age + "\n"
                + "3 - Sexo: " + gender + "\n"
                + "4 - Cidade: " + city + "\n"
                + "5 - Senha: " + password + "\n"
                + "6 * Email: " + email + "\n"
                + "7 * Ocupação: " + type.getType() + "\n"
                + "8 * Dinheiro: " + type.getMoney() + "\n"
                + "9 * Coins: " + type.getCoins() + "\n"
                + "10 - Exit \n"
                + " =====================  \n"
                + " Qual campo deseja alterar? ";
        return message;
    }
    
    public static String movies(String filme, int sala, String[] schedules, int i) {
        message = "===================== " + i + " ===================== \n"
                + " Nome: " + filme + "   \n"
                + " Sala: " + sala + "    \n"
                + " Horário: " + schedules[0] + " (2D) | " + schedules[1] + " (2D) | " + schedules[2] + "(3D) \n"
                + ""; 
        return message;
    }
    
    public static int[] seats_1(Movie aux) {
        System.out.println("Escolha seu assento: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " - ");
            for (int j = 0; j < 5; j++) {
                if (aux.getSeats_1(i, j))
                    System.out.print("X ");
                else
                    System.out.print("O ");
            }
            System.out.println();
        }  
        for (int i = 0; i < 5; i++)
            System.out.print("  " + i);
        System.out.println();
        
        int[] values = new int[2]; 
        do {
            System.out.print("Número da linha da fileira: ");
            values[0] = input.nextInt();
            System.out.print("Número da coluna da fileira: ");
            values[1] = input.nextInt();
        } while (aux.getSeats_1(values[0], values[1]) && check(values[0]) && 
                check(values[1]));
        
        return values;
    }
    
    public static int[] seats_2(Movie aux) {
        System.out.println("Escolha seu assento: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " - ");
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
            System.out.print("Número da linha da fileira: ");
            values[0] = input.nextInt();
            System.out.print("Número da coluna da fileira: ");
            values[1] = input.nextInt();
        } while (aux.getSeats_2(values[0], values[1]) && check(values[0]) && 
                check(values[1]));
        
        return values;
    }
    
    public static int[] seats3D(Movie aux) {
        System.out.println("Escolha seu assento: ");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " - ");
            for (int j = 0; j < 5; j++) {
                if (aux.getSeats_3D(i, j))
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
            System.out.print("Número da linha da fileira: ");
            values[0] = input.nextInt();
            System.out.print("Número da coluna da fileira: ");
            values[1] = input.nextInt();
        } while (aux.getSeats_3D(values[0], values[1]) && check(values[0]) && 
                check(values[1]));
        
        return values;
    }
    
    public static boolean check(int values) {
        if (values > 4 || values < 0) 
            return false;
        else
            return true;
    }
    
    public static String completeMovie(Movie aux, Person tipo, String schedule, float priceFood, float value_3D) {
        message = " =================== \n"
                + " Filme: " + aux.getName() + "\n"
                + " Horário: " + schedule + "\n"
                + " Preço do filme: " + aux.getPrice() + "\n"
                + " Preço do lanche: " + priceFood + "\n"
                + " Preço do 3D: " + value_3D + "\n"
                + " Desconto: " + tipo.getDiscount() + "\n"
                + " Total: " + (aux.getPrice() - tipo.getDiscount() + priceFood) + "\n"
                + " Saldo atual: " + tipo.getMoney() + "\n"
                + " =================== \n";
        return message;
    }
    
    public static String completeFood(Person tipo, float priceFood, float value_3D) {
        message = " =================== \n"
                + " Filme: Nenhum \n"
                + " Horário: Nenhum \n"
                + " Preço do filme: 0.00 \n"
                + " Preço do lanche: " + priceFood + "\n"
                + " Preço do 3D: 0.00 \n"
                + " Desconto: 0.00 \n"
                + " Total: " + priceFood + "\n"
                + " Saldo atual: " + tipo.getMoney() + "\n"
                + " =================== \n";
        return message;
    }
    
    public static String food(Popcorn p, Beverage b, Sweet s) {
        message = " =================== \n"
                + "1 - Pipoca: R$ " + p.getPrice() + "\n"
                + "2 - Bebida: R$ " + b.getPrice() + "\n"
                + "3 - Doce: R$ " + s.getPrice() + "\n"
                + "x - Não comprar nada \n" 
                + " =================== \n"
                + " O que você deseja comprar ? ";        
        return message;
    }
    
    public static String payment(Movie aux) {
        message = " ### Formas de Pagamentos ### \n"
                + "1 - Dinheiro ( R$ " + aux.getPrice() + " ) \n"
                + "2 - Moedas ( R$ " + aux.getCoins() + " ) \n"
                + " ========================== \n";
        return message;
    }
    
    public static String day(String day) {
        message = "================\n"
                + " Dia: " + day + " \n"
                + "================\n";
        
        return message;
    }
}
