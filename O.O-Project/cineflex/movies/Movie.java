package cineflex.movies;

public class Movie {
    private String name;
    private String[] schedules;
    private int rooms;
    private boolean seats_1[][], seats_2[][], seats_3D[][];
    private float price;
    private float coins;
    private float price_3D;

    public Movie(String name, String[] schedules, int rooms, boolean[][] seats_1, boolean[][] seats_2, boolean[][] seats_3D, float price, float coins) {
        super();
        
        this.name = name;
        this.schedules = schedules;
        this.rooms = rooms;
        this.seats_1 = seats_1;
        this.seats_2 = seats_2;
        this.seats_3D = seats_3D;
        this.price = price;
        this.coins = coins;
        this.price_3D = 4.0f;
    }

    public float getCoins() {
        return coins;
    }

    public void setCoins(float coins) {
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

    public boolean getSeats_3D(int i, int j) {
        return seats_3D[i][j];
    }

    public void setSeats_3D(int i, int j, boolean seats) {
        this.seats_3D[i][j] = seats;
    }
}
