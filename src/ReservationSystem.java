import java.util.*;
public class ReservationSystem {
    private final List<User> users;
    private final List<Ticket> tickets;
    private User loggedIdUser;

    public  ReservationSystem(){
        this.users=new ArrayList<>();
        this.tickets=new ArrayList<>();
        this.users.add(new User("admin","admin"));
    }
    public void start(){
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("1.Login");
            System.out.println("2.Register");
            System.out.println("3.Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    login(sc);
                    break;
                case 2:
                    register(sc);
                    break;
                case 3:
                    System.out.println("You are Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
    private void login(Scanner sc){
        System.out.println("Enter User Name: ");
        String username=sc.nextLine();
        System.out.println("Enter Password: ");
        String password=sc.nextLine();
        for(User user:users){
            if(user.getUsername().equals(username) && user.checkPassword(password)){
                loggedIdUser=user;
                System.out.println("LogIn Successful!..");
                userMenu(sc);
                return;
            }
        }
        System.out.println("Invalid Username or Password");
    }
    private void register(Scanner sc){
        System.out.println("Enter new UserName: ");
        String username=sc.nextLine();
        System.out.println("Enter new password: ");
        String password=sc.nextLine();
        users.add(new User(username, password));
        System.out.println("Registered Successfully.You can now login..");
    }
    private void userMenu(Scanner sc){
        System.out.println("1.Book Tickets");
        System.out.println("2.View Tickets");
        System.out.println("3.Exit");
        System.out.println("Enter your choice: ");
        int choice=sc.nextInt();
        sc.nextLine();

        switch (choice){
            case 1:
                bookTicket(sc);
                break;
            case 2:
                viewTickets();
                break;
            case 3:
                loggedIdUser=null;
                System.out.println("Logged Out");
                return;
            default:
                System.out.print("Invalid choice.Try again");

        }
    }
    private void bookTicket(Scanner sc){
        System.out.println("Enter train number: ");
        String trainNumber=sc.nextLine();
        System.out.println("Enter departure location: ");
        String departure=sc.nextLine();
        System.out.println("Enter your destination: ");
        String destination=sc.nextLine();
        System.out.println("Enter date (YYYY-MM-DD): ");
        String date=sc.nextLine();

        Ticket ticket=new Ticket(trainNumber, departure, destination, date, loggedIdUser);
        tickets.add(ticket);
        System.out.println("Ticket booked successfully");
    }
    private void viewTickets() {
        boolean hasTickets = false;
        System.out.println("Booked Tickets:");
        for (Ticket ticket : tickets) {
            if (ticket.getUser().equals(loggedIdUser)) {
                System.out.println(ticket);
                hasTickets = true;
            }
        }
        if (!hasTickets) {
            System.out.println("No tickets booked yet");
        }
    }
    public static void main(String[] args) {
        ReservationSystem system= new ReservationSystem();
        system.start();
    }
}