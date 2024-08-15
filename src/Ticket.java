public class Ticket {
    private final String trainNumber;
    private final String departure;
    private final String destination;
    private final String date;
    private final User user;


    public Ticket(String trainNumber,String departure,String destination,String date, User user){
        this.trainNumber=trainNumber;
        this.departure=departure;
        this.destination=destination;
        this.date=date;
        this.user=user;
    }
    public User getUser() {
        return user;
    }
    @Override
    public String toString() {
        return "Ticket{ "+
                "trainNumber='"+trainNumber+'\''+
                ",departure='"+departure+'\''+
                ",destination='"+destination+'\''+
                ",date='"+date+'\''+
                ", user=" + user.getUsername() +
                '}';

    }
}
