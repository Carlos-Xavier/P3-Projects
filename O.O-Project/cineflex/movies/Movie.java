package cineflex.movies;

public class Movie {
    private String name;
    private String[] schedules;
    private int rooms;
    private boolean seats_1[][], seats_2[][];
    private float price;
    private int coins;
    
    public Movie(boolean[][] seats_1, boolean[][] seats_2) {
        this.seats_1 = seats_1;
        this.seats_2 = seats_2;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getSchedules(int i) {
        return schedules[i];
    }

    public void setSchedules(String[] schedules) {
        this.schedules = schedules;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int room) {
        this.rooms = room;
    }
    
    public boolean getSeats_1(int i, int j) {
        return seats_1[i][j];
    }

    public void setSeats_1(int i, int j, boolean seats) {
        this.seats_1[i][j] = seats;
    }

    public boolean getSeats_2(int i, int j) {
        return seats_2[i][j];
    }

    public void setSeats_2(int i, int j, boolean seats) {
        this.seats_2[i][j] = seats;
    }
}
