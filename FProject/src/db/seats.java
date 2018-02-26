package db;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class seats {

	
	private String flight_no;
	private String total_seats;
	private String b_seats;
	private String f_seats;
	private String e_seats;
	private String total_b_booked;
	private String total_f_booked;
	private String total_e_booked;
	
	public seats(String flight_no, String total_seats, String b_seats, String f_seats, String e_seats,
			String total_b_booked, String total_f_booked, String total_e_booked, String total_booked) {
		super();
		this.flight_no = flight_no;
		this.total_seats = total_seats;
		this.b_seats = b_seats;
		this.f_seats = f_seats;
		this.e_seats = e_seats;
		this.total_b_booked = total_b_booked;
		this.total_f_booked = total_f_booked;
		this.total_e_booked = total_e_booked;
		this.total_booked = total_booked;
	}
	private String total_booked;
	
	
	java.sql.Connection conn;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	public seats() {
		// TODO Auto-generated constructor stub
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
   
   public ResultSet GetFlightsSeatsDetais(String FNO){
	   try
		{
		    statement = ((java.sql.Connection) conn).createStatement();
			String QUERY = "SELECT * FROM seats_tbl WHERE flight_no='"+FNO+"'";
			System.out.println(QUERY);
			rs = statement.executeQuery(QUERY);
			if (rs != null){
				//System.out.println(rs.getString("flight_airlines"));
				return rs;
			}
			return rs;
		}
	   catch (Exception e) 
		{
		     e.printStackTrace();
		     return rs;
		}
   }
   
   public boolean ExecuteInsertQuery(String flight_no, String total_seats,String b_c,String f_c,String e_c){
	   
	   String total_booked = "0";
	   String total_b_booked = "0";
	   String total_f_booked = "0";
	   String total_e_booked = "0";
	   
	   try
		{
		   String QUERY = "INSERT INTO seats_tbl (flight_no, total_seats, b_seats, f_seats, e_seats, total_booked,"
		   		+ " total_b_booked, total_f_booked, total_e_booked) values('"+flight_no+"','"+total_seats+"','"+b_c+"','"+f_c+"','"+e_c
		   		+"','"+total_booked+"','"+total_b_booked+"','"+total_f_booked+"','"+total_e_booked+"')";
		    System.out.println(QUERY);
			int result = statement.executeUpdate(QUERY);
			if(result == 1)
			{
				
					return true;
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
	 public boolean ExecuteUpdateSeats(String flight_no, String no_ticket, String ticket_type){
		   String total_booked = "0";
		   String total_b_booked = "0";
		   String total_f_booked = "0";
		   String total_e_booked = "0";
		   try
			{
			   ResultSet r = GetFlightsSeatsDetais(flight_no);
			   if (r.next()){
				   total_booked = r.getString("total_booked");
				   total_b_booked = r.getString("total_b_booked");
				   total_f_booked = r.getString("total_f_booked");
				   total_e_booked = r.getString("total_e_booked");
			   }
			}
		   catch (Exception e) 
			{
			     e.printStackTrace();
			}
		   
		   
		   
		   try
			{
			   int tb = Integer.parseInt(total_booked) + Integer.parseInt(no_ticket);
			   String QUERY = null;
			   if (ticket_type.equals("b_c"))
			   {
				   int tbb = Integer.parseInt(total_b_booked) + Integer.parseInt(no_ticket);
				   QUERY = "UPDATE seats_tbl SET total_booked = '"+tb+"',total_b_booked = '"+tbb+"' WHERE flight_no='"+flight_no+"'";
			   }
			   if (ticket_type.equals("f_c")){
				   int tbf = Integer.parseInt(total_f_booked) + Integer.parseInt(no_ticket);
				   QUERY = "UPDATE seats_tbl SET total_booked = '"+tb+"',total_b_booked = '"+tbf+"'  WHERE flight_no='"+flight_no+"'";
				   
			   }
			   if (ticket_type.equals("e_c")){
				   int tbe = Integer.parseInt(total_e_booked) + Integer.parseInt(no_ticket);
				   QUERY = "UPDATE seats_tbl SET total_booked = '"+tb+"',total_b_booked = '"+tbe+"'  WHERE flight_no='"+flight_no+"'";
			   }
			    System.out.println(QUERY);
				int result = statement.executeUpdate(QUERY);
				if(result == 1)
						return true;
					else
						return false;
			}
		   catch (Exception e) 
			{
			     e.printStackTrace();
			     return false;
			}
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
	 * @return the total_seats
	 */
	public String getTotal_seats() {
		return total_seats;
	}
	/**
	 * @param total_seats the total_seats to set
	 */
	public void setTotal_seats(String total_seats) {
		this.total_seats = total_seats;
	}
	/**
	 * @return the b_seats
	 */
	public String getB_seats() {
		return b_seats;
	}
	/**
	 * @param b_seats the b_seats to set
	 */
	public void setB_seats(String b_seats) {
		this.b_seats = b_seats;
	}
	/**
	 * @return the f_seats
	 */
	public String getF_seats() {
		return f_seats;
	}
	/**
	 * @param f_seats the f_seats to set
	 */
	public void setF_seats(String f_seats) {
		this.f_seats = f_seats;
	}
	/**
	 * @return the e_seats
	 */
	public String getE_seats() {
		return e_seats;
	}
	/**
	 * @param e_seats the e_seats to set
	 */
	public void setE_seats(String e_seats) {
		this.e_seats = e_seats;
	}
	/**
	 * @return the total_b_booked
	 */
	public String getTotal_b_booked() {
		return total_b_booked;
	}
	/**
	 * @param total_b_booked the total_b_booked to set
	 */
	public void setTotal_b_booked(String total_b_booked) {
		this.total_b_booked = total_b_booked;
	}
	/**
	 * @return the total_f_booked
	 */
	public String getTotal_f_booked() {
		return total_f_booked;
	}
	/**
	 * @param total_f_booked the total_f_booked to set
	 */
	public void setTotal_f_booked(String total_f_booked) {
		this.total_f_booked = total_f_booked;
	}
	/**
	 * @return the total_e_booked
	 */
	public String getTotal_e_booked() {
		return total_e_booked;
	}
	/**
	 * @param total_e_booked the total_e_booked to set
	 */
	public void setTotal_e_booked(String total_e_booked) {
		this.total_e_booked = total_e_booked;
	}
	/**
	 * @return the total_booked
	 */
	public String getTotal_booked() {
		return total_booked;
	}
	/**
	 * @param total_booked the total_booked to set
	 */
	public void setTotal_booked(String total_booked) {
		this.total_booked = total_booked;
	}
}
