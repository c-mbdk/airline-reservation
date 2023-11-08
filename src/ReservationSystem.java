import java.util.Scanner;

public class ReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Reserve For Me - we make booking flights and airport transfers a smooth experience.");
        System.out.print("Please enter your name: ");
        String name = scanner.nextLine();
        AirlineReservation newFlightBooking = new AirlineReservation(AirlineReservation.generateBookingId(), name);
        System.out.println("\n");
        System.out.println("******************************************");
        System.out.println("Booking ID: " + newFlightBooking.getBookingId());
        System.out.println("Booking Name: " + newFlightBooking.getBookingName());
        System.out.print("Enter your desired destination: ");
        newFlightBooking.setDestination(scanner.nextLine());
        System.out.print("Enter the departure location: ");
        newFlightBooking.setDepartingLocation(scanner.nextLine());
        do {
            System.out.print("Enter the date you would like to travel (YYYY-MM-DD): ");
            newFlightBooking.setReservationDate(scanner.nextLine());
        }
        while (newFlightBooking.getReservationDate() == null);

        do {
            System.out.print("Enter the desired time for the flight (HH:MM): ");
            newFlightBooking.setReservationTime(scanner.next());
        }
        while (newFlightBooking.getReservationTime() == null);

        newFlightBooking.getFlightCabinOptions();
        System.out.print("Enter your desired cabin class (a/b/c): ");
        char option = Character.toLowerCase(scanner.next().charAt(0));
        switch (option) {
            case 'a' -> newFlightBooking.setFlightCabin(AirlineReservation.cabinClass.ECONOMY);
            case 'b' -> newFlightBooking.setFlightCabin(AirlineReservation.cabinClass.BUSINESS);
            case 'c' -> newFlightBooking.setFlightCabin(AirlineReservation.cabinClass.FIRSTCLASS);
        }

        System.out.print("How many passengers will be travelling on this flight? Enter a number: ");
        newFlightBooking.setNumberOfPassengers(scanner.nextInt());
        newFlightBooking.getReservationDetails();
        System.out.print("Would you like to book an airport transfer? (yes/no) ");
        String toBookAirportTransfer = scanner.next().toLowerCase();
        if (toBookAirportTransfer.equals("no")) {
            System.out.println("Then it's our turn to get to work!");
        } else {
            System.out.println("\n");
            System.out.println("******************************************");
            CarReservation newCarBooking = new CarReservation(Reservation.generateBookingId(), name, newFlightBooking.getBookingId());
            System.out.println("Airport Transfer Booking ID: "+newCarBooking.getBookingId());
            System.out.println("Booking Name: "+newCarBooking.getBookingName());
            newCarBooking.setNumberOfPassengers(newFlightBooking.getNumberOfPassengers());

            do {
                newCarBooking.getCarTypeOptions();
                System.out.print("Enter your desired car type (1/2/3): ");
                byte carChoice = scanner.nextByte();
                switch (carChoice) {
                    case 1 -> newCarBooking.setCarType(CarReservation.serviceType.Everyday);
                    case 2 -> newCarBooking.setCarType(CarReservation.serviceType.Executive);
                    case 3 -> newCarBooking.setCarType(CarReservation.serviceType.Luxury);
                }
            }
            while (newCarBooking.getCarType() == null);

            do {
                System.out.println("Enter the desired date for pickup (YYYY-MM-DD): ");
                newCarBooking.setReservationDate(scanner.next());
            }
            while (newCarBooking.getReservationTime() == null);

            do {
                System.out.print("Enter the desired time for pickup (HH:MM): ");
                newCarBooking.setReservationTime(scanner.next());
            }
            while (newFlightBooking.getReservationTime() == null);

            newCarBooking.getReservationDetails();
        }

        do {
            System.out.print("Please enter the email address where we should send the reservation details: ");
            newFlightBooking.setBookingEmail(scanner.next());
        }
        while (newFlightBooking.getBookingEmail() == null);

        System.out.println("Your booking details will be sent to: " + newFlightBooking.getBookingEmail());
        System.out.println("Thanks for booking with us!");
        System.exit(0);
    }
}