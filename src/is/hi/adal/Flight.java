package is.hi.adal;

/**
 * Created by Alexander on 20.4.2017.
 */
public class Flight {
    private String date;
    private String destinasion;
    private String from;
    private int cost;
    private int seats;
    private String time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestinasion() {
        return destinasion;
    }

    public void setDestinasion(String destinasion) {
        this.destinasion = destinasion;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }
    public Flight(String dagur, String afangastadur, String fra, int kostnaður, int Seats, String time){
        this.date = dagur;
        this.destinasion = afangastadur;
        this.from = fra;
        this.cost = kostnaður;
        this.seats = Seats;
        this.time = time;
    }

    public String getTime() {
        return time;
    }
}
