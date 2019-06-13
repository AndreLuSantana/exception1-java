package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import model.entities.Reservation;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			Integer number = sc.nextInt();
			System.out.print("Check-in date DD/MM/yyyy: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date DD/MM/YYYY: ");
			Date checkOut = sdf.parse(sc.next());
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println(" Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter data to update Reservation: ");
			System.out.print("Check-in date DD/MM/YYYY: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date DD/MM/YYYY: ");
			checkOut = sdf.parse(sc.next());
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservetion: " + reservation);
		}
		catch(ParseException e){
			System.out.println("Invalid date format.");
		}catch(DomainException e){
			System.out.println("Error in reservation " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpected error:");
		}
			
		System.out.println();
			
		
		
		sc.close();
	}

}
