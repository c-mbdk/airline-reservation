public class AirlineReservation extends Reservation {
    public enum cabinClass {
        ECONOMY, BUSINESS, FIRSTCLASS
    }

    private String destination;
    private String departingLocation;
    private cabinClass flightCabin;

    public AirlineReservation(int bookingId, String bookingName) {
        super(bookingId, bookingName);
        this.destination = "temp destination";
        this.departingLocation = "temp startLocation";
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartingLocation() {
        return departingLocation;
    }

    public cabinClass getFlightCabin() {
        return flightCabin;
    }

    public void getFlightCabinOptions() {
        System.out.println("Available cabin classes:");
        System.out.println("a) " +cabinClass.ECONOMY);
        System.out.println("b) " +cabinClass.BUSINESS);
        System.out.println("c) " +cabinClass.FIRSTCLASS);
    }

    public void getReservationDetails() {
        System.out.println("\n");
        System.out.println("******************************************");
        System.out.println("Flight Booking Details");
        System.out.println("Booking ID: " + this.getBookingId());
        System.out.println("Booking Name: " + this.getBookingName());
        System.out.println("Reservation Date: "+this.getReservationDate());
        System.out.println("Departing location: " + this.getDepartingLocation());
        System.out.println("Desired departure time: "+ this.getReservationTime());
        System.out.println("Destination: " + this.getDestination());
        System.out.println("Flight cabin: " + this.getFlightCabin());
        System.out.println("Number of passengers: " + this.getNumberOfPassengers());
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightCabin(cabinClass flightCabin) {
        this.flightCabin = flightCabin;
    }

    public void setDepartingLocation(String departingLocation) {
        this.departingLocation = departingLocation;
    }
}

