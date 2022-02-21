package lt.assignment.flights;

import java.time.LocalDate;

public class Flight {

	private LocalDate date;
	protected String destination;
	private int flightNo;

	
	public Flight(LocalDate date, String destination, int flightNo) {
		this.date = date;
		this.destination = destination;
		this.flightNo = flightNo;
	}
	


	public LocalDate getDate() {
		return date;
	}


	public String getDestination() {
		return destination;
	}


	public int getFlightNo() {
		return flightNo;
	}


	@Override
	public String toString() {
		return "Flight date: " + date + ", destination: " + destination + ", flight no.:" + flightNo + ".\n";
	}



	
	
}
