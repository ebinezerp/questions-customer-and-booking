package question5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Booking {

	private Integer id;
	private String customerName;
	private Table table;
	private Integer membersPersent;
	private Double billAmount;
	private Date bookingTime;

	public Booking() {
		super();
	}

	public Booking(Integer id, String customerName, Table table, Integer membersPersent, Double billAmount,
			Date bookingTime) {
		super();
		this.id = id;
		this.customerName = customerName;
		this.table = table;
		this.membersPersent = membersPersent;
		this.billAmount = billAmount;
		this.bookingTime = bookingTime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public Integer getMembersPersent() {
		return membersPersent;
	}

	public void setMembersPersent(Integer membersPersent) {
		this.membersPersent = membersPersent;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	public Date getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}

	private static Booking getBookingInstance(String line) throws ParseException {
		String[] bookingDetails = line.split(",");
		Booking booking = new Booking();
		booking.setId(Integer.valueOf(bookingDetails[0]));
		booking.setCustomerName(bookingDetails[1]);
		booking.setMembersPersent(Integer.valueOf(bookingDetails[3]));
		booking.setBillAmount(Double.valueOf(bookingDetails[4]));
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		booking.setBookingTime(sdf.parse(bookingDetails[5]));
		return booking;
	}

	public static void createBooking(List<Table> tableList, List<Booking> bookingList, String line)
			throws ParseException {
		Integer tableNo = Integer.valueOf(line.split(",")[2]);
		
		Boolean isFound = false;
		for (Table table : tableList) {
			if (table.getNumber() == tableNo) {
				Booking booking = getBookingInstance(line);
				booking.setTable(table);
				bookingList.add(booking);
				tableList.remove(table);
				isFound = true;
				break;
			}
		}

		if (isFound) {
			System.out.println("Table is successfully booked");
		} else {
			System.out.println("Table is not available");
		}

	}

	@Override
	public String toString() {
		return String.format(
				"Booking [id=%s, customerName=%s, table=%s, membersPersent=%s, billAmount=%s, bookingTime=%s]", id,
				customerName, table, membersPersent, billAmount, bookingTime);
	}

}