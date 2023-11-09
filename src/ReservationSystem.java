public class ReservationSystem {
    public static void main(String[] args) {
        System.out.println("Welcome to Reserve With Me - we help you book flights and airport transfers!");
        BaseReservation newFlightBooking = new FlightReservation();
        newFlightBooking.makeReservation();
        System.out.println("\n");
        System.out.println("****************************************");
        System.out.println("Airport Transfer Booking");
        BaseReservation newCarBooking = new AirportTransferReservation();
        newCarBooking.makeReservation();
        System.out.println("Confirmation of the reservations will be sent to the following email address: "
        +newFlightBooking.getBookingEmail());
        System.out.println("Thanks for booking with us!");
    }
}