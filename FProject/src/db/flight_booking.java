package db;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class flight_booking {

	private String username;
	private String flight_no;
	private String no_ticket;
	private String final_cost;
	private String booking_date;
	private String ticket_type;
	
	
	java.sql.Connection conn;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	
	public flight_booking(String username, String flight_no, String no_ticket, String final_cost, String booking_date,
			String ticket_type) {
		super();
		this.username = username;
		this.flight_no = flight_no;
		this.no_ticket = no_ticket;
		this.final_cost = final_cost;
		this.booking_date = booking_date;
		this.ticket_type = ticket_type;
	}

	public flight_booking() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the flight_no
	 */
	public String getFlight_no() {
		return flight_no;
	}

	/**
	 * @param flight_no the flight_no to set
	 */
	public void setFlight_no(String flight_no) {
		this.flight_no = flight_no;
	}

	/**
	 * @return the no_ticket
	 */
	public String getNo_ticket() {
		return no_ticket;
	}

	/**
	 * @param no_ticket the no_ticket to set
	 */
	public void setNo_ticket(String no_ticket) {
		this.no_ticket = no_ticket;
	}

	/**
	 * @return the final_cost
	 */
	public String getFinal_cost() {
		return final_cost;
	}

	/**
	 * @param final_cost the final_cost to set
	 */
	public void setFinal_cost(String final_cost) {
		this.final_cost = final_cost;
	}

	/**
	 * @return the booking_date
	 */
	public String getBooking_date() {
		return booking_date;
	}

	/**
	 * @param booking_date the booking_date to set
	 */
	public void setBooking_date(String booking_date) {
		this.booking_date = booking_date;
	}

	/**
	 * @return the ticket_type
	 */
	public String getTicket_type() {
		return ticket_type;
	}

	/**
	 * @param ticket_type the ticket_type to set
	 */
	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}
	
	public void MysqlOpenConnection(){
	   try
		{
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webprog", "hemanth", "hemanth");
			statement = ((java.sql.Connection) conn).createStatement();
		}
	   catch (Exception e) 
		{
		     e.printStackTrace();
		}
   }
	   
   public void MysqlCloseConnection(){
	   try
		{
			conn.close();
		}
	   catch (Exception e) 
		{
		     e.printStackTrace();
		} 
   }
   
   public boolean ExecuteInsertQuery(String username, String flight_no, String no_ticket, String final_cost, String booking_date, String ticket_type, String booked_date){
	   try
		{
		   String QUERY = "INSERT INTO flight_booking_tbl (username,flight_no, no_ticket, final_cost, booking_date, ticket_type,booked_date)"
		   		+ " values('"+username+"','"+flight_no+"','"+no_ticket+"','"+final_cost+"','"+booking_date
		   		+"','"+ticket_type+"','"+booking_date+"')";
		    System.out.println(QUERY);
			int result = statement.executeUpdate(QUERY);
			if(result == 1)
			{
					seats s = new seats();
					s.MysqlOpenConnection();
					boolean res = s.ExecuteUpdateSeats(flight_no, no_ticket, ticket_type);
					s.MysqlCloseConnection();
					if (res)
					{
						return true;
					}
					else
					{
						return false;
					}
			}
			else
				return false;
		}
	   catch (Exception e) 
		{
		     e.printStackTrace();
		     return false;
		}
   } 

}
