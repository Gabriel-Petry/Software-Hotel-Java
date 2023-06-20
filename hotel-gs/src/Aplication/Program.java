package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservartion;
import model.exceptios.DomainException;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date(dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
		
			Reservartion reservation = new Reservartion(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter date to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reservation.updateDate(checkIn, checkOut);
			
			System.out.println("Reservation: " + reservation);
		
		
		sc.close();
		}
		catch(ParseException e)
		{
			System.out.println("Invalid Date Format");
		}
		catch(IllegalArgumentException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(InputMismatchException e) {
			System.out.println("Unexpected Input!");
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error! ");
		}
	}

}
