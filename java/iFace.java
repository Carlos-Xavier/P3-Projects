package iface;

import java.util.Scanner;

public class Iface {
    static String user, name, password, aux;
    static String[][] profiles, profiles_data, friends, friend_message;
    static String[][] profiles_guard, profiles_data_guard, friends_guard, friend_message_guard;
    static String[][][] community, community_friends, community_message;
    static boolean[][] friend_notification, message_notification;
    static boolean[][][] community_notification_member, community_notification_message;

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        profiles = new String[20][3];
        profiles_guard = new String[20][3];
        community = new String[20][20][2];
        profiles_data = new String[20][6];
        profiles_data_guard = new String[20][6];
        friends_guard = new String[20][20];
        friend_message_guard = new String[20][20];
        friends = new String[20][20];
        friend_message = new String[20][20];
        friend_notification = new boolean[20][20];
        message_notification = new boolean[20][20];
        community_notification_member = new boolean[20][20][20];
        community_notification_message = new boolean[20][20][20];
        community_friends = new String[20][20][20];
        community_message = new String[20][20][1];

        String[] choices = {"Create Account", "Login", "Delete Account", "Recover Data", "exit"};
        
        System.out.print(" Welcome to Iface ");
        while (true) {
            boolean pause = false;

            print(choices);

            int num = input.nextInt();

            switch(num) {
                case 1:
                    Create_Accont();
                    break;
                case 2:
                    clearScreen();
                    Login();
                    break;
                case 3:
                    Delete_Account();
                    break;
                case 4:
                    Recover_Data();
                    break;
                case 5:
                    pause = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            if (pause) break;
        }
    }

    public static void print(String[] choices) {
        System.out.println();
        for (int i = 0; i < choices.length; i++) {
            System.out.println(i + 1 + " - " + choices[i]);
        }
        System.out.println();
    }

    public static void clearScreen()
    {
        char esc = 27;
        String clear = esc + "[2J"; //codigo ansi para limpar a tela

        for (int i = 0; i < 2; i++)
            System.out.print(clear);
    }

    static boolean check_user(String value, int i) {
        boolean bool = true;
        for (int j = 0; profiles[j][i] != null; j++) {
            if (profiles[j][i].intern() == value.intern()) {
                bool = false;
            }
        }
        return bool;
    }
    
    static boolean check_user_guard(String value, int i) {
        boolean bool = true;
        for (int j = 0; profiles_guard[j][i] != null; j++) {
            if (profiles_guard[j][i].intern() == value.intern()) {
                bool = false;
            }
        }
        return bool;
    }
    
    static boolean check_community(String value) {
        boolean bool = true;
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < 20; i++) {
                if ((community[j][i][0] != null) && (community[j][i][0].intern() == value.intern())) {
                    bool = false;
                }
            }
        }
        return bool;
    }
    
    static boolean check_your_community(String value, int id) {
        boolean bool = true;
        for (int j = 0; community[id][j][0] != null; j++) {
            if (community[id][j][0].intern() == value.intern()) {
                bool = false;
            }
        }
        return bool;
    }
    
    static void fill_notifications_d2(boolean[][] notification) {
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 20; j++)
                notification[i][j] = false;
    }
    
    static void fill_notifications_d3(boolean[][][] notification) {
        for (int i = 0; i < 20; i++)
            for (int j = 0; j < 20; j++)
                for (int k = 0; k < 20; k++)
                    notification[i][j][k] = false;
    }

    static int getIndex(String index) {
        int i;
        for (i = 0; profiles[i][0] != null; i++) {
            if (profiles[i][0].intern() == index.intern()) break;
        }
        return i;
    }

    static void Create_Accont() {
        int i;
        for (i = 0; profiles[i][0] != null; i++);

        Scanner value = new Scanner(System.in);
        while (true) {
            System.out.print("User: ");
            user = value.nextLine();
            
            if (check_user(user, 0)) break;

            System.out.println("User already exists!");
        }

        System.out.print("Password: ");
        password = value.nextLine();

        System.out.print("Name: ");
        name = value.nextLine();

        profiles_guard[i][0] = profiles[i][0] = user;
        profiles_data_guard[i][1] = profiles_data[i][1] = profiles_guard[i][1] = profiles[i][1] = password;
        profiles_data_guard[i][0] = profiles_data[i][0] = profiles_guard[i][2] = profiles[i][2] = name;

        System.out.println("\nWelcome " + user);
    }

    static void Login() {
        System.out.print("Login: ");
        user = input.next();

        System.out.print("Password: ");
        password = input.next();
            
        if (!check_user(user, 0)) {
            int i = getIndex(user);

            if (profiles[i][1].intern() == password.intern()) {
                clearScreen();
                Profile_Data(user);
            }
            else
               System.out.println("User does not exist, incorrect login or password!"); 
        }
        else
            System.out.println("User does not exist, incorrect login or password!");
    }

    static void Profile_Data(String name_aux) {
        String[] choices = {"Profile", "Friends", "Message", "Community", "Notifications", "exit"};

        while(true) {
            boolean pause = false;

            print(choices);
            
            int id = getIndex(name_aux);
            int num = input.nextInt();
            switch(num) {
                case 1:
                    Profile_Edit(name_aux);
                    break;
                case 2:
                    Friends(name_aux);
                    break;
                case 3:
                    Check_Message(name_aux);
                    break;
                case 4:
                    Community_Edit(name_aux);
                    break;
                case 5:
                    Notification(id);
                    break;
                case 6:
                    pause = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            if (pause) break;
            clearScreen();
        }
    }
    
    static void Delete_Account() {
        Scanner value = new Scanner(System.in);
        
        System.out.print("Enter the username you want to delete: ");
        name = value.next();
        
        if (!check_user(name, 0)) {
            int id = getIndex(name);
            profiles[id][0] = profiles[id][1] = profiles[id][2] = null;

            for (int i = 0; i < 5; i++)
                profiles_data[id][i] = null;

            for (int i = 0; friends[id][i] != null; i++)
                friends[id][i] = null;
            
            for (int i = 0; community[id][i][0] != null; i++)
                community[id][i][0] = null;

            System.out.println("Account successfully deleted!");
        }
        else {
            System.out.println("User does not exist!");
        } 
    }
    
    static void Recover_Data() {
        Scanner value = new Scanner(System.in);
        
        System.out.print("Enter the username you want to retrieve the data: ");
        name = value.next();
        
        if (!check_user_guard(name, 0)) {
            int id = getIndex(name);
            
            System.out.println("\nUsername: " + name);
            System.out.println("Password: " + profiles_data_guard[id][0]);
            System.out.println("Name: " + profiles_data_guard[id][1]);
            System.out.println("Age: " + profiles_data_guard[id][2]);
            System.out.println("City: " + profiles_data_guard[id][3]);
            System.out.println("Civil Status: " + profiles_data_guard[id][4]);
            System.out.println("Sex: " + profiles_data_guard[id][5]);

            System.out.println("\nFriends: ");
            for (int i = 0; i < 20; i++)
                if (friends_guard[id][i] != null)
                    System.out.println(i+1 + " - " + friends_guard[id][i]);
            
            System.out.println("\nPosts: ");
            for (int i = 0; i < 20; i++)
                if (friend_message_guard[id][i] != null)
                    System.out.println(friend_message_guard[id][i]);
            
            System.out.println("\nData successfully recovered!");
        }
        else {
            System.out.println("User does not exist!");
        }
    }

    static void Profile_Edit(String name_aux) {
        String[] choices = {"Name", "Password", "Age", "City", "Civil Status", "Sex", "Exit"};
        
        Scanner value = new Scanner(System.in);
        while (true) {
            boolean pause = false;
            
            System.out.println("\n What do you want to change? \n");

            int n = getIndex(name_aux);
            for (int i = 0; i < 6; i++) {
                System.out.println(i+1 + " - " + choices[i] + ": " + profiles_data[n][i]);
            }
            System.out.println(7 + " - " + choices[6]);
            
            int num = value.nextInt();
            switch(num) {
                case 1:
                    System.out.print("Name: ");
                    aux = value.next();

                    profiles_guard[n][2] = profiles_data_guard[n][0] = profiles_data[n][0] = aux;
                    break;
                case 2:
                    System.out.print("Password: ");
                    aux = value.next();
                    
                    profiles_guard[n][1] = profiles[n][1] = profiles_data_guard[n][1] = profiles_data[n][1] = aux;
                    break;
                case 3:
                    System.out.print("Age: ");
                    aux = value.next();
                    
                    profiles_data_guard[n][2] = profiles_data[n][2] = aux;
                    break;
                case 4:
                    System.out.print("City: ");
                    aux = value.next();
                    
                    profiles_data_guard[n][3] = profiles_data[n][3] = aux;
                    break;
                case 5:
                    System.out.print("Civil Status: ");
                    aux = value.next();
                    
                    profiles_data_guard[n][4] = profiles_data[n][4] = aux;
                    break;
                case 6:
                    System.out.print("Sex: ");
                    aux = value.next();
                    
                    profiles_data_guard[n][5] = profiles_data[n][5] = aux;
                    break;
                case 7:
                    pause = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            if (pause) break;
            clearScreen();
        }
    }
    
    static void Friends(String name_aux) {
        String[] choices = {"Add Friends", "List Friends", "Exit"};
        
        while(true) {
            boolean pause = false;
            print(choices);
            
            int id = getIndex(name_aux);
            int num = input.nextInt();
            switch(num) {
                case 1:
                    clearScreen();
                    Add_Friends(id);
                    break;
                case 2:
                    List_Friends(id);
                    break;
                case 3:
                    pause = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            if (pause) break;
        }
    }
    
    static void List_Friends(int id) {
        boolean flag = true;
        for (int i = 0; i < 20; i++) {
            if (friends[id][i] != null) {
                flag = false;
                System.out.println(friends[id][i]);
            }
        }
        if (flag)
            System.out.println("You do not have friends.");
    }
    
    static void Add_Friends(int id) {
        Scanner value = new Scanner(System.in);
        
        System.out.print("Enter the username you want to add: ");
        
        name = value.next();
        if (!check_user(name, 0)) {
            int n = getIndex(name);
            friend_notification[n][id] = true;
            System.out.println("A notification has been sent to " + name);
        }
        else {
            System.out.println("User does not exist!");
        }
    }
    
    static void Friends_Notifications(int id) {
        boolean flag = true;
        for (int i = 0; i < 20; i++) {
            if (friend_notification[id][i]) {
                flag = false;
                System.out.print("User " + profiles[i][0] + " wants to be your friend, do you accept (Y/N)? ");
                
                aux = input.next();
                if (aux.intern() == "y" || aux.intern() == "Y") {
                    friends_guard[id][i] = friends[id][i] = profiles[i][0];
                    friends_guard[i][id] = friends[i][id] = profiles[id][0];
                    friend_notification[id][i] = false;
                }
                else if (aux.intern() == "n" || aux.intern() == "N");
                    
                else System.out.println("Invalid option!");  
            }
        }
        if (flag) 
            System.out.println("You have no notifications.");
    }
    
    static void Check_Message(String name_aux) {
        String[] choices = {"Friends Messages", "Community Messages", "Exit"};
        
        while(true) {
            boolean pause = false;

            print(choices);
            
            int id = getIndex(name_aux);
            int num = input.nextInt();
            switch(num) {
                case 1:
                    Friends_Messages(id);
                    break;
                case 2:
                    Community_Message(id);
                    break;
                case 3:
                    pause = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            if (pause) break;
            clearScreen();
        }
    }
    
    static void Notification(int id) {
        System.out.println("To check for messages, type 1.");
        System.out.println("To check for community notifications type 2.");
        System.out.println("To check for friendship notifications type 3.");
        
        int num = input.nextInt();
        if (num == 1)
            Message_Notification(id);
        else if (num == 2)
            Community_Notification(id);
        else if (num == 3)
            Friends_Notifications(id);
        else
            System.out.println("Invalid option!");
    }
    
    static void Community_Notification(int id) {
        boolean flag = true;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (community_notification_member[id][i][j] == true) {
                    flag = false;
                    System.out.print("User " + profiles[i][0] + " wants you to join his community. (Y/N)? ");
                    
                    aux = input.next();
                    if (aux.intern() == "y" || aux.intern() == "Y") {
                        community_friends[i][j][id] = profiles[id][0];
                        community_notification_member[id][i][j] = false;
                    }
                    else if(aux.intern() == "n" || aux.intern() == "N");
                
                    else System.out.println("Invalid option!");
                }     
            }
        }
        if (flag) 
            System.out.println("You have no notifications.");
    }
    
    static void Friends_Messages(int id) {
        System.out.print("Which user do you want to send a message to? ");
        
        Scanner value = new Scanner(System.in);
        name = value.next();
        
        if (!check_user(name, 0)) {
            int n = getIndex(name);
            message_notification[n][id] = true;
            
            System.out.print("Enter the message: ");
            value = new Scanner(System.in);
            aux = value.nextLine();
            
            friend_message[n][id] = aux;
            
            int i;
            for (i = 0; friend_message_guard[id][i] != null; i++);
            friend_message_guard[id][i] = aux;
            
            System.out.println("A message has been sent to " + name);
        }
        else {
            System.out.println("User does not exist!");
        }
    }
    
    static void Message_Notification(int id) {
        boolean flag = true;
        for (int i = 0; i < 20; i++) {
            if (message_notification[id][i]) {
                flag = false;
                System.out.print("User " + profiles[i][0] + " sent you a message, do you want to read? (Y/N)? ");
                
                aux = input.next();
                if (aux.intern() == "y" || aux.intern() == "Y") {
                    System.out.println(friend_message[id][i]);
                    friend_notification[id][i] = false;
                }
                else if(aux.intern() == "n" || aux.intern() == "N");
                
                else System.out.println("Invalid option!");
            }
            
        }
        if (flag) 
            System.out.println("You have no notifications.");
    }
    
    static void Community_Edit(String name_aux) {
        String[] choices = {"Create Community", "Your Communities", "Exit"};
        
        while(true) {
            boolean pause = false;

            print(choices);
            
            int id = getIndex(name_aux);
            int num = input.nextInt();
            switch(num) {
                case 1:
                    Create_Community(id);
                    break;
                case 2:
                    Your_Communities(id);
                    break;
                case 3:
                    pause = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            if (pause) break;
            clearScreen();
        }
    }
    
    static void Create_Community(int id) {
        int i;
        for (i = 0; community[id][i][0] != null; i++);
        
        Scanner value = new Scanner(System.in);
        while (true) {
            System.out.print("Community Name: ");
            name = value.nextLine();
            
            if (check_community(user)) break;

            System.out.println("Community already exists!");
        }
        community[id][i][0] = name;
        
        System.out.print("Enter a description for your community: ");
        community[id][i][1] = value.nextLine();     
    }
    
    static void Your_Communities(int id) {
        if (community[id][0][0] == null) {
            System.out.println("You have no communities.");
        }
        else {
            for (int i = 0; community[id][i][0] != null; i++) {
                System.out.println(i+1 + " - " + community[id][i][0]);
            }
            System.out.print("Enter the name of the community you want to manage: ");
            
            Scanner value = new Scanner(System.in);
            name = value.nextLine();
            
            if (!check_your_community(name, id)) {
                Community_Profile(name, id);
            }
            else {
                System.out.println("Community does not exist!");
            }    
        }
    }
    
    static void Community_Profile(String name, int user_id) {
        String[] choices = {"Edit Description", "Members", "Notifications", "Exit"};
        
        while(true) {
            boolean pause = false;

            print(choices);
            
            int i;
            for (i = 0; community[user_id][i][0].intern() != name.intern(); i++);
            
            int num = input.nextInt();
            switch(num) {
                case 1:
                    Description(user_id, i);
                    break;
                case 2:
                    Members(name, user_id, i);
                    break;
                case 3:
                    Community_Notifications(user_id, i);
                    break;
                case 4:
                    pause = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            if (pause) break;
            clearScreen();
        }
    }
    
    static void Description(int id_user, int id_community) {
        Scanner value = new Scanner(System.in);

        System.out.println("Current description: ");
        System.out.println(community[id_user][id_community][1]); 
                
        System.out.println("New description: ");
        community[id_user][id_community][1] = value.nextLine();
    }
    
    static void Members(String name, int id, int i) {
        String[] choices = {"Add Members", "List Members", "Exit"};
        while(true) {
            boolean pause = false;

            print(choices);
            
            int num = input.nextInt();
            switch(num) {
                case 1:
                    Add_Members(id, i);
                    break;
                case 2:
                    List_Members(id, i);
                    break;
                case 3:
                    pause = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
            if (pause) break;
        }
    }
    
    static void Add_Members(int id_user, int id_community) {
        Scanner value = new Scanner(System.in);
        
        System.out.print("Enter the username you want to add: ");
        
        aux = value.next();
        if (!check_user(aux, 0)) {
            int n = getIndex(aux);
            community_notification_member[n][id_user][id_community] = true;
            
            System.out.println("A notification has been sent to " + aux);
        }
        else {
            System.out.println("User does not exist!");
        }
    }
    
    static void List_Members(int id_user, int id_community) {
        boolean flag = true;
        for (int i = 0; i < 20; i++) {
            if (community_friends[id_user][id_community][i] != null) {
                flag = false;
                System.out.println(community_friends[id_user][id_community][i]);
            }
        }
        if (flag)
            System.out.println("Your community has no followers.");
    }
    
    static void Community_Notifications(int id_user, int id_community) {
        boolean flag = true;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (community_notification_message[id_user][i][j] == true) {
                    flag = false;
                    System.out.print("User " + profiles[i][0] + " sent you a message, do you want to read? (Y/N)? ");
                    
                    aux = input.next();
                    if (aux.intern() == "y" || aux.intern() == "Y") {
                        System.out.println(community_message[id_user][i][0]);
                        community_notification_message[id_user][i][j] = false;
                    }
                    else if(aux.intern() == "n" || aux.intern() == "N");

                    else System.out.println("Invalid option!");
                }
            }
        }
        if (flag)
            System.out.println("You have no notifications.");
    }
    
    static void Community_Message(int id_user) {
        System.out.print("Which community do you want to send a message to? ");
        
        Scanner value = new Scanner(System.in);
        name = value.next();
        
        if (!check_community(name)) {
            Send_Message(name, id_user);
        }
        else {
            System.out.println("Community does not exist!");
        }
    }
    
    static void Send_Message(String name, int id_user) {
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < 20; i++) {
                if ((community[j][i][0] != null) && (community[j][i][0].intern() == name.intern())) {
                    community_notification_message[j][id_user][i] = true;
                    
                    System.out.print("Enter the message: ");
                    
                    Scanner value = new Scanner(System.in);
                    
                    aux = value.nextLine();
                    community_message[j][id_user][0] = aux;
                    
                    int k;
                    for (k = 0; friend_message_guard[id_user][k] != null; k++);
                    friend_message_guard[id_user][k] = aux;
                }
            }
        }
    }
}

