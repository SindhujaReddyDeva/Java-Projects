import java.util.Scanner;

class MovieTicket {

    String movieName;
    double ticketPrice;
    int numberOfTickets;

    MovieTicket(String movieName, double ticketPrice, int numberOfTickets) {
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
        this.numberOfTickets = numberOfTickets;
    }

    double calculateTotal() {
        return ticketPrice * numberOfTickets;
    }

    double calculateDiscount() {
        if (numberOfTickets >= 5) {
            return calculateTotal() * 0.10;
        } else {
            return 0;
        }
    }

    double calculateFinalAmount() {
        return calculateTotal() - calculateDiscount();
    }

    void displayBill() {
        System.out.println("\n----- CINEMA TICKET BOOKING BILL -----");
        System.out.println("Movie Name       : " + movieName);
        System.out.println("Ticket Price     : " + ticketPrice);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Total Amount     : " + calculateTotal());
        System.out.println("Discount         : " + calculateDiscount());
        System.out.println("Final Amount     : " + calculateFinalAmount());
    }
}

public class Ticket {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter movie name: ");
        String movieName = sc.nextLine();

        System.out.print("Enter ticket price: ");
        double ticketPrice = sc.nextDouble();

        System.out.print("Enter number of tickets: ");
        int numberOfTickets = sc.nextInt();

        MovieTicket ticket = new MovieTicket(
            movieName, ticketPrice, numberOfTickets
        );

        ticket.displayBill();

        sc.close();
    }
}