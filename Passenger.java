package lt.assignment.flights;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Passenger extends Flight {

	private String name, surname;
	private String seatNo;
	private Flight flight;
	private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

	public Passenger(LocalDate date, String destination, int flightNo, String seatNo, String name, String surname) {
		super(date, destination, flightNo);
		this.seatNo = seatNo;
		this.name = name;
		this.surname = surname;
		this.flight = new Flight(date, destination, flightNo);
	}

	public void addPassenger(Passenger passenger) {
		passengers.add(passenger);
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	@Override
	public String toString() {
		return name + " " + surname + ", seat no.:" + seatNo + ". " + flight;
	}

	public void sortByDestination(ArrayList<Passenger> passengers) {

		Comparator<Passenger> compareByDest = Comparator.comparing(Passenger::getDestination)
				.thenComparing(Passenger::getSeatNo);

		List<Passenger> sortedPassengers = getPassengers().stream().sorted(compareByDest).collect(Collectors.toList());

		System.out.println(sortedPassengers);

	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public Flight getFlight() {
		return flight;
	}

	public void findPassengersOnFlight() {
		List<Passenger> passengersOnFlight = new ArrayList<Passenger>();

		int chosenFlight = chooseFlight();

		System.out.println("Flight " + chosenFlight + " passengers:");

		for (Passenger passenger : passengers) {
			if (passenger.getFlightNo() == chosenFlight) {
				passengersOnFlight.add(passenger);
			}
		}
		if (passengersOnFlight.size() > 0) {
			for (Passenger passenger : passengersOnFlight) {
				System.out.println(passenger);
			}
		} else {
			System.out.println("There are no passengers.");
		}

	}

	public int chooseFlight() {

		Scanner scanner = new Scanner(System.in);
		int userEntry = 0;
		boolean userEntryValid;

		do {
			try {
				System.out.println("Please enter the flight number (4 digits) in order to see the passenger list:");
				userEntry = scanner.nextInt();
				userEntryValid = true;
			} catch (InputMismatchException e) {
				System.out.println("The entered data is not valid. Please enter 4 digits only.");
				userEntryValid = false;
				scanner.nextLine();
			}

		} while (!userEntryValid);

		scanner.close();
		System.out.println("You would like to check flight " + userEntry);
		return userEntry;
	}

	public void findLargest() {

		System.out.println("The passenger with the highest flight and seat number is:");

		Comparator<Passenger> compareByFlightNo = Comparator.comparing(Passenger::getFlightNo)
				.thenComparing(Passenger::getSeatNo);

		List<Passenger> sortedByFlight = getPassengers().stream().sorted(compareByFlightNo)
				.collect(Collectors.toList());

		System.out.println(sortedByFlight.get(sortedByFlight.size() - 1));

	}

	public void groupPassengersByDestination() {
		
		Map<String, List<Passenger>> groupByDestination = 			
		getPassengers().stream().collect(Collectors.groupingBy(Passenger::getDestination));

		groupByDestination.forEach((destination, passenger1) -> {System.out.println("Destination - " + destination + ", passengers: ");
		int id = 1;
		for (Passenger psg : passenger1) {
			System.out.println(id + ". " + psg.name + " " + psg.surname);
			id++;
		}
		});


	}


	public void passengersFlyingIn1Week() {

		LocalDate start = LocalDate.now();
		LocalDate end = start.plusDays(7);

		System.out.println("Passengers travelling within next 7 days (incl. today):");
		for (Passenger passenger : passengers) {
			if (passenger.getDate().compareTo(start) >= 0 && passenger.getDate().compareTo(end) <= 0) {
				System.out.println(passenger);
			}

		}

	}

	public void passengersFlyingThisMonth() {

		LocalDate start = LocalDate.now();
		LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
		System.out.println(end);

		System.out.println("Passengers travelling within this month (incl. today):");
		for (Passenger passenger : passengers) {
			if (passenger.getDate().compareTo(start) >= 0 && passenger.getDate().compareTo(end) <= 0) {
				System.out.println(passenger);
			}
		}

	}
}
