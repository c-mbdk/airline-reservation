import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public abstract class BaseReservation {
    public static final Scanner scanner = new Scanner(System.in);
    private int bookingId;
    private String bookingName;
    private String departureLocation;
    private String destination;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private String bookingEmail;
    private String serviceType;
    private int numberOfPassengers;

    public void makeReservation() {
        generateBookingId();
        setBookingName();
        chooseNumberOfPassengers();
        chooseDepartureLocation();
        chooseDestination();
        chooseServiceType();
        chooseReservationDate();
        chooseReservationTime();
        setBookingEmail();
        getReservationDetails();
    }

    abstract void chooseServiceType();
    abstract void getReservationDetails();

    protected void generateBookingId() {
        int randomNumber = (int)(Math.random() * 9999);
        if (randomNumber <= 1000)
            randomNumber += 1000;
        this.bookingId = randomNumber;
    }
    protected void setBookingName() {
        System.out.print("Please enter your name: ");
        bookingName = scanner.next();
    }
    protected void setBookingEmail() {
        do {
            System.out.print("Please enter your email address so that we can send you the reservation details: ");
            String bookingEmail = scanner.next();
            if (bookingEmail.contains("@"))
                this.bookingEmail = bookingEmail;
            else
                System.out.println("A valid email must be provided");
        }
        while (this.bookingEmail == null);
    }

    protected void chooseDepartureLocation() {
        System.out.print("Enter the departure location: ");
        this.departureLocation = scanner.next();
    }

    protected void chooseDestination() {
        System.out.print("Enter the desired destination: ");
        this.destination = scanner.next();
    }

    protected void chooseReservationTime() {
        do {
            System.out.print("Enter the desired departure time (HH:MM): ");
            String possibleReservationTime = scanner.next();
            DateTimeFormatter strictTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            try {
                this.reservationTime = LocalTime.parse(possibleReservationTime, strictTimeFormatter);
            } catch (Exception e) {
                System.out.println("Invalid time entered. Please enter a valid time.");
            }
        }
        while (this.reservationTime == null);
    }

    protected void chooseReservationDate() {
        do {
            System.out.print("Enter the desired departure date (YYYY-MM-DD): ");
            String possibleReservationDate = scanner.next();
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            LocalDate potentialReservationDate = LocalDate.parse(possibleReservationDate, formatter);
            if (potentialReservationDate.isBefore(LocalDate.now())) {
                System.out.println("Reservation date cannot be in the past");
            }
            else
                this.reservationDate = potentialReservationDate;
        }
        while (this.reservationDate == null);
    }

    protected void chooseNumberOfPassengers() {
        do {
            System.out.print("Enter the number of passengers for this journey: ");
            byte possibleNumberOfPassengers = scanner.nextByte();
            if (possibleNumberOfPassengers <= 0) {
                System.out.println("Please enter a valid number.");
            }
            this.numberOfPassengers = possibleNumberOfPassengers;
        }
        while (this.numberOfPassengers < 0);
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public int getBookingId() {
        return this.bookingId;
    }

    public String getBookingName() {
        return this.bookingName;
    }

    public String getDepartureLocation() {
        return this.departureLocation;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getBookingEmail() {
        return this.bookingEmail;
    }

    public LocalDate getReservationDate() {
        return this.reservationDate;
    }

    public LocalTime getReservationTime() {
        return this.reservationTime;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }
}
