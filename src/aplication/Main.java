package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import application.model.entities.Reservation;
import application.model.exeptions.DeomainExeption;

public class Main {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		
		System.out.print("Room nunmber: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		
		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation: "+reservation);
			
		System.out.println();
		System.out.println("Enter data to update the resertavion: ");
		System.out.print("Check-in date(dd/MM/yyyy): ");
		checkIn=sdf.parse(sc.next());
		System.out.print("Check-out date(dd/MM/yyyy): ");
		checkOut=sdf.parse(sc.next());
				
		reservation.updateDates(checkIn, checkOut);
				
		System.out.println("Reservation: "+reservation);
		
		
		}
		catch(ParseException e) {
		System.out.println("Invalid format");	
		}
		catch(DeomainExeption e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Unexcepted Error");
		}finally{
		sc.close();
		}
	}
}
  
