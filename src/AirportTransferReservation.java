public class AirportTransferReservation extends BaseReservation {
    public enum carType {
        Everyday,
        Executive,
        Luxury
    }

    @Override
    void chooseServiceType() {
        do {
        System.out.println("Available car types:");
        System.out.println("1) " +carType.Everyday);
        System.out.println("2) " +carType.Executive);
        System.out.println("3) " +carType.Luxury);
        System.out.println("Enter your desired car type (1/2/3): ");
        byte carChoice = scanner.nextByte();
            switch (carChoice) {
                case 1 -> this.setServiceType(String.valueOf(carType.Everyday));
                case 2 -> this.setServiceType(String.valueOf(carType.Executive));
                case 3 -> this.setServiceType(String.valueOf(carType.Luxury));
            }
        }
        while (this.getServiceType() == null);
    }

    @Override
    void getReservationDetails() {
        System.out.println("\n");
        System.out.println("******************************************");
        System.out.println("Airport Transfer Booking Details");
        System.out.println("Airport Transfer Booking ID: "+this.getBookingId());
        System.out.println("Booking Name: "+this.getBookingName());
        System.out.println("Car Type: "+this.getServiceType());
        System.out.println("Pickup Date: "+this.getReservationDate());
        System.out.println("Pickup time: "+this.getReservationTime());
    }
}
