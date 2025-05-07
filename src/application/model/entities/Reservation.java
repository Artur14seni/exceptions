package application.model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import application.model.exeptions.DeomainExeption;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reservation() {
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DeomainExeption {
		if(!checkOut.after(checkIn)) {
			throw new DeomainExeption("Check-out date must beaftercheck-in date");
		} 
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	
	public Integer getRoomNumber() {
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

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime(); //get Time pega o tempo em mili segundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) throws DeomainExeption {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new IllegalArgumentException("Reservation dates for updatemust be future dates");
		}
		
		if(!checkOut.after(checkIn)) {
			throw new DeomainExeption("Check-out date must beaftercheck-in date");
		} 
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		}
	
	
	@Override
	public String toString() {
		return "Room "
		+roomNumber
		+", check-in: "
		+sdf.format(checkIn)
		+", Checkout: "
		+sdf.format(checkOut)
		+", "
		+duration()
		+" nights";
	}
	
}
