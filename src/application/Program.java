package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		Integer number = sc.nextInt();
		System.out.print("Check-in date DD/MM/yyyy: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date DD/MM/YYYY: ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		}else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update Reservation: ");
			
			System.out.print("Check-in date DD/MM/YYYY: ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-Out date DD/MM/YYYY: ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			
			if(checkIn.before(now) || checkOut.before(now)) {
				
				System.out.println("Error in reservation: Reservation dates for update mus be future dates.");
			
			}else if(!checkOut.after(checkIn)) {
				
				System.out.println("Erros in reservation: Check-out must be after check-in date.");
				
			}else {
				
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservetion: " + reservation);
				
			}
			
		}
		
		sc.close();
	}

}
