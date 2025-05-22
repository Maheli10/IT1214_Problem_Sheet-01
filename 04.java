public class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    public Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

     public String getCustomerName() {
        return customerName;
    }

   public int getSeatNumber() {
        return seatNumber;
    }
}

class BookingSystem {
    private Ticket[] bookedTickets;
    private boolean[] seats;
    private int numberOfBookedTickets;

    public BookingSystem() {
        bookedTickets = new Ticket[10];
        seats = new boolean[10];
        numberOfBookedTickets = 0;
    }

    public void bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (seatNumber < 1 || seatNumber > seats.length) {
            System.out.println("Booking failed! Please choose a seat between 1 and " + seats.length + ".");
            return;
        }

        if (seats[seatNumber - 1]) {
            System.out.println("Booking failed: Seat " + seatNumber + " is already booked.");
            return;
        }

        if (numberOfBookedTickets >= bookedTickets.length) {
            System.out.println("Booking failed: All seats are booked.");
            return;
        }

        for (int i = 0; i < numberOfBookedTickets; i++) {
            if (bookedTickets[i].getTicketNumber() == ticketNumber) {
                System.out.println("Booking failed: Ticket number " + ticketNumber + " already exists.");
                return;
            }
        }

        Ticket newTicket = new Ticket(ticketNumber, customerName, seatNumber);
        bookedTickets[numberOfBookedTickets] = newTicket;
        seats[seatNumber - 1] = true;
        numberOfBookedTickets++;
        System.out.println("Ticket " + ticketNumber + " booked for " + customerName + " at seat " + seatNumber + ".");
    }

    public void cancelTicket(int ticketNumber) {
        boolean found = false;
        for (int i = 0; i < numberOfBookedTickets; i++) {
            if (bookedTickets[i].getTicketNumber() == ticketNumber) {
                int freedSeat = bookedTickets[i].getSeatNumber();
                seats[freedSeat - 1] = false;

                for (int j = i; j < numberOfBookedTickets - 1; j++) {
                    bookedTickets[j] = bookedTickets[j + 1];
                }
                bookedTickets[numberOfBookedTickets - 1] = null;
                numberOfBookedTickets--;
                found = true;
                System.out.println("Ticket " + ticketNumber + " cancelled successfully. Seat " + freedSeat + " is now free.");
                break;
            }
        }
        if (!found) {
            System.out.println("Cancellation failed: Ticket with number " + ticketNumber + " not found.");
        }
    }

    public void displayAllBookedTickets() {
        if (numberOfBookedTickets == 0) {
            System.out.println("No tickets currently booked.");
            return;
        }
		
        for (int i = 0; i < numberOfBookedTickets; i++) {
            System.out.println("Ticket Number: "+bookedTickets[i].getTicketNumber()+"Customer name: "+bookedTickets[i].getCustomerName()+"Seat Number: "+bookedTickets[i].getSeatNumber());
        }
    }

    public static void main(String[] args) {
        BookingSystem cinemaBooking = new BookingSystem();

        cinemaBooking.bookTicket(1, "Customer A", 1); 
        cinemaBooking.bookTicket(2, "Customer B", 2); 
        cinemaBooking.bookTicket(3, "Customer C", 3); 

        cinemaBooking.cancelTicket(2); 

        cinemaBooking.bookTicket(4, "Customer D", 2); 

        cinemaBooking.displayAllBookedTickets();

        cinemaBooking.bookTicket(5, "Customer E", 1); 
        cinemaBooking.bookTicket(6, "Customer F", 11);
    }
}
