public class FlightReservation extends BaseReservation{
    public enum cabinClass {
        ECONOMY, BUSINESS, FIRSTCLASS
    }

    @Override
    void chooseServiceType() {
        do {
            System.out.println("Available cabin classes:");
            System.out.println("a) " + AirlineReservation.cabinClass.ECONOMY);
            System.out.println("b) " + AirlineReservation.cabinClass.BUSINESS);
            System.out.println("c) " + AirlineReservation.cabinClass.FIRSTCLASS);
            System.out.print("Enter your desired cabin class (a/b/c): ");
            char option = Character.toLowerCase(scanner.next().charAt(0));

            if (option == 'a' || option == 'b' || option == 'c') {
                switch (option) {
                    case 'a' -> this.setServiceType(String.valueOf(cabinClass.ECONOMY));
                    case 'b' -> this.setServiceType(String.valueOf(cabinClass.BUSINESS));
                    case 'c' -> this.setServiceType(String.valueOf(cabinClass.FIRSTCLASS));
                }
            }
            else
                System.out.println("Please enter either a or b or c");
        }
        while (this.getServiceType() == null);

    }

    @Override
    void getReservationDetails() {
        System.out.println("\n");
        System.out.println("******************************************");
        System.out.println("Flight Booking Details");
        System.out.println("Booking ID: " +this.getBookingId());
        System.out.println("Booking Name: " +this.getBookingName());
        System.out.println("Reservation Date: "+this.getReservationDate());
        System.out.println("Departing location: " +this.getDepartureLocation());
        System.out.println("Desired departure time: "+this.getReservationTime());
        System.out.println("Destination: " +this.getDestination());
        System.out.println("Flight cabin: " +this.getServiceType());
        System.out.println("Number of passengers: " +this.getNumberOfPassengers());
    }
}
