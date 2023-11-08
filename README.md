# airline-reservation

## About this project
This project was created to continue consolidation of Java fundamentals, specifically looking at inheritance and trying to minimise code duplication as much as possible. The application is a command-line reservation tool for booking flights and airport transfers. The user provides their name, the destination, departure location, date, departure time and email address during the process and all confirmation details are (in theory) sent to the specified email address. The application incorporates more checks to ensure that valid values are provided before updating the fields on the objects e.g., reservationDate.

The application uses:
- A custom Reservation superclass
- A custom AirlineReservation subclass
- A custom CarReservation subclass
- switch case
- multiple do/while loops
- if/else
- Enums

## Future enhancements
Over the course of building this project, I did some research into Design Patterns. The main method is arguably too big and clunky at present: there are multiple do-while loops and making an airport transfer booking is encased in an else block. The same project can be implemented using a Design Pattern, so this will be explored in a separate branch on this repo.

## How to Run
1. Clone the repository/download the files.
2. Run ReservationSystem.java in the application of your choice e.g., Command Prompt, IntelliJ etc.
