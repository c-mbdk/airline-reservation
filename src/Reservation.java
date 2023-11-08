import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private final int bookingId;
    private final String bookingName;
    private int numberOfPassengers;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private String bookingEmail;

    public Reservation(int bookingId, String bookingName) {
        this.bookingId = bookingId;
        this.bookingName = bookingName;
    }

    public int getBookingId() {
        return bookingId;
    }

    public String getBookingName() {
        return bookingName;
    }

    public String getBookingEmail() {
        return bookingEmail;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public LocalTime getReservationTime() {
        return reservationTime;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }
    public void setReservationDate(String reservationDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate possibleReservationDate = LocalDate.parse(reservationDate, formatter);
        if (possibleReservationDate.isBefore(LocalDate.now())) {
            System.out.println("Reservation date cannot be in the past");
        }
        else
            this.reservationDate = possibleReservationDate;
    }

    public void setBookingEmail(String bookingEmail) {
        if (bookingEmail.contains("@")) {
            this.bookingEmail = bookingEmail;
        }
        else
            System.out.println("A valid email must be provided.");
    }

    public void setReservationTime(String reservationTime) {
        try {
            DateTimeFormatter strictTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            this.reservationTime = LocalTime.parse(reservationTime, strictTimeFormatter);
        } catch (Exception e) {
            System.out.println("Invalid time entered: " + reservationTime);
        }
    }

    public static int generateBookingId() {
        int randomNumber = (int)(Math.random() * 9999);
        if (randomNumber <= 1000)
            randomNumber += 1000;
        return randomNumber;
    }

}
