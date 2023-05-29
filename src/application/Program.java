package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException { //digo que meu metodo main n tem que tratar essa excecao. PROPAGA A EXCEÇÃO (THROWS)
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		
		System.out.println("Room number:  ");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy)");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy)");
		Date checkOut= sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) {//se checkout n for dps do check in, faça:
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation:  " + reservation);
		
		
		System.out.println();
		System.out.println("Enter data to update the reservation: ");
		
		System.out.println("Check-in date (dd/MM/yyyy)");
		checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy)");
		checkOut= sdf.parse(sc.next());
		
		reservation.updateDates(checkIn, checkOut);
		
		System.out.println("Reservation:  " + reservation);

		
		
		}
		
		
		
		
		
		sc.close();
		
		
		
	}

}
