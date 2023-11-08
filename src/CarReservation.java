public class CarReservation extends Reservation {
    public enum serviceType {
        Everyday,
        Executive,
        Luxury
    }
    private serviceType carType;
    private final int linkedFlightBookingId;

    public CarReservation(int bookingId, String bookingName, int linkedFlightBookingId) {
        super(bookingId, bookingName);
        this.linkedFlightBookingId = linkedFlightBookingId;
    }

    public void getCarTypeOptions() {
        System.out.println("Available car types:");
        System.out.println("1) Everyday");
        System.out.println("2) Executive");
        System.out.println("3) Luxury");
    }

    public serviceType getCarType() {
        return carType;
    }

    public int getLinkedFlightBookingId() {
        return linkedFlightBookingId;
    }
    
    public void getReservationDetails() {
        System.out.println("\n");
        System.out.println("******************************************");
        System.out.println("Airport Transfer Booking Details");
        System.out.println("Airport Transfer Booking ID: "+this.getBookingId());
        System.out.println("Linked to Flight Booking ID: "+this.getLinkedFlightBookingId());
        System.out.println("Booking Name: "+this.getBookingName());
        System.out.println("Car Type: "+this.getCarType());
        System.out.println("Pickup Date: "+this.getReservationDate());
        System.out.println("Pickup time: "+this.getReservationTime());
    }

    public void setCarType(serviceType carType) {
        this.carType = carType;
    }
}
