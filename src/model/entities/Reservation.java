package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	//formatando a data:  é statico pra n sobrepoer
	private static SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
	



	public Reservation(Integer roomNumber, Date checkIn, Date checkOut)  {
		if (!checkOut.after(checkIn)) {
			throw new DomainException ( "Error in reservation: Check-out date must be after check-in date");			

		}		
		
		
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	
	public Integer getRommNumber() {
		return roomNumber;
	}


	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}


	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() { //calculando a dif entre datas EM DIAS
		long diff = checkOut.getTime() - checkIn.getTime(); //VAI ARAMAZENAR EM MILISSEGUNGOS
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //CONVERTE MILLI PARA DIAS.
		
	}
	
	public void updateDates(Date checkIn, Date checkOut)  {		
		Date now = new Date(); 
		if (checkIn.before(now) || checkOut.before(now)){
			throw new DomainException ( "Error in reservation: Reservation dates for update must be future dates");

		}
		 if (!checkOut.after(checkIn)) {
			throw new DomainException ( "Error in reservation: Check-out date must be after check-in date");			

		}		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	
	}
	
	@Override
	public String toString() {
		return "Room " 
				+ roomNumber
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ ", "
				+ duration()
				+ " nights";

	}

	
	

}
