package lt.assignment.flights;

import java.time.LocalDate;

public class App {

	public static void main(String[] args) {

		Passenger passenger1 = new Passenger(LocalDate.parse("2022-02-26"), "Paris", 7645, "25B", "Petras",
				"Petraitis");
		Passenger passenger2 = new Passenger(LocalDate.parse("2022-02-26"), "Paris", 7645, "13C", "Tomas", "Tomaitis");
		Passenger passenger3 = new Passenger(LocalDate.parse("2022-03-05"), "Rome", 7890, "05E", "Lina", "Linaite");
		Passenger passenger4 = new Passenger(LocalDate.parse("2022-03-05"), "Rome", 7890, "17A", "Rasa", "Rasaite");
		Passenger passenger5 = new Passenger(LocalDate.parse("2022-03-05"), "Rome", 7890, "18B", "Lukas", "Lukaitis");
		Passenger passenger6 = new Passenger(LocalDate.parse("2022-03-28"), "Barcelona", 3456, "19D", "Giedre",
				"Giedraite");
		Passenger passenger7 = new Passenger(LocalDate.parse("2022-05-08"), "London", 4567, "26A", "Asta", "Astaite");
		Passenger passenger8 = new Passenger(LocalDate.parse("2022-03-28"), "Barcelona", 3456, "18F", "Tadas",
				"Tadaitis");
		Passenger passenger9 = new Passenger(LocalDate.parse("2022-05-08"), "London", 4567, "14E", "Kostas",
				"Kostaitis");
		Passenger passenger10 = new Passenger(LocalDate.parse("2022-04-20"), "Istanbul", 1478, "19A", "Neringa",
				"Neringaite");
		Passenger passenger11 = new Passenger(LocalDate.parse("2022-04-20"), "Istanbul", 1478, "12B", "Migle",
				"Miglaite");
		Passenger passenger12 = new Passenger(LocalDate.parse("2022-02-25"), "Dublin", 9123, "16A", "Saule",
				"Saulaite");

		passenger1.addPassenger(passenger1);
		passenger1.addPassenger(passenger2);
		passenger1.addPassenger(passenger3);
		passenger1.addPassenger(passenger4);
		passenger1.addPassenger(passenger5);
		passenger1.addPassenger(passenger6);
		passenger1.addPassenger(passenger7);
		passenger1.addPassenger(passenger8);
		passenger1.addPassenger(passenger9);
		passenger1.addPassenger(passenger10);
		passenger1.addPassenger(passenger11);
		passenger1.addPassenger(passenger12);

		System.out.println("2.1. LIST OF ALL PASSENGERS.\n");
		System.out.println("The list of passengers is: \n" + passenger1.getPassengers());

		System.out.println("---");
		System.out.println("2.2. LIST OF ALL PASSENGERS SORTED BY DESTINATION AND SEAT NO.\n");

		passenger1.sortByDestination(passenger1.getPassengers());

		System.out.println("---");
		System.out.println("2.3. FIND THE PASSENGERS ON A SPECIFIC FLIGHT.\n");

		passenger1.findPassengersOnFlight();

		System.out.println("---");
		System.out.println("2.4. FIND THE PASSENGER WITH THE BIGGEST FLIGHT AND SEAT NO.\n");

		passenger1.findLargest();

		System.out.println("---");
		System.out.println("2.5. GROUP PASSENGERS BY DESTINATION.\n");

		// passenger1.groupPassengersByDestination();

		System.out.println("---");
		System.out.println("2.6. PASSENGERS WITH FLIGHT WITHIN 7 DAYS.\n");

		passenger1.passengersFlyingIn1Week();

		System.out.println("---");
		System.out.println("2.7. PASSENGERS WITH FLIGHT WITHIN THIS MONTH.\n");

		passenger1.passengersFlyingThisMonth();
	}

}
