package db;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class cart {

	private String username;
	private String flight_no;
	private String ticket_no;
	private String ticket_class;
	private String ticket_cost;
	private String final_cost;
	
	java.sql.Connection conn;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	
	public cart(String username, String flight_no, String ticket_no, String ticket_class, String ticket_cost,
			String final_cost) {
		super();
		this.username = username;
		this.flight_no = flight_no;
		this.ticket_no = ticket_no;
		this.ticket_class = ticket_class;
		this.ticket_cost = ticket_cost;
		this.final_cost = final_cost;
	}

	public cart() {
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
	 * @return the ticket_no
	 */
	public String getTicket_no() {
		return ticket_no;
	}

	/**
	 * @param ticket_no the ticket_no to set
	 */
	public void setTicket_no(String ticket_no) {
		this.ticket_no = ticket_no;
	}

	/**
	 * @return the ticket_class
	 */
	public String getTicket_class() {
		return ticket_class;
	}

	/**
	 * @param ticket_class the ticket_class to set
	 */
	public void setTicket_class(String ticket_class) {
		this.ticket_class = ticket_class;
	}

	/**
	 * @return the ticket_cost
	 */
	public String getTicket_cost() {
		return ticket_cost;
	}

	/**
	 * @param ticket_cost the ticket_cost to set
	 */
	public void setTicket_cost(String ticket_cost) {
		this.ticket_cost = ticket_cost;
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
	   
	   public boolean ExecuteInsertQuery(String username, String flight_no, String ticket_no, String ticket_class, String ticket_cost, String final_cost){
		   try
			{
			   String QUERY = "INSERT INTO cart_tbl (username, flight_no, ticket_no, ticket_class, ticket_cost, final_cost) values"
			   		+ "('"+username+"','"+flight_no+"','"+ticket_no+"','"+ticket_class+"','"+ticket_cost+"','"+final_cost+"')";
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
	   
	   public int GetCart(String username){
		   try
			{
			   int count = 0;
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "SELECT COUNT(*) AS total FROM cart_tbl WHERE username='"+username+"'";
				System.out.println(QUERY);
				rs = statement.executeQuery(QUERY);
				if (rs.next()){
					count = rs.getInt("total");
					return count;
				}
				return 0;
			}
		   catch (Exception e) 
			{
			     e.printStackTrace();
			     return 0;
			}
	   }
	   
	   public ResultSet GetAllCart(String username){
		   try
			{
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "SELECT * FROM cart_tbl WHERE username='"+username+"'";
				System.out.println(QUERY);
				rs = statement.executeQuery(QUERY);
				if (rs != null){
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
	   
	   public ResultSet GetCartItemByID(String username, String id){
		   try
			{
			   System.out.println(username+"-"+id);
			   int x = Integer.parseInt(id);
			   System.out.println(username+"-"+x);
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "SELECT * FROM cart_tbl WHERE username='"+username+"' AND id="+x;
				System.out.println(QUERY);
				rs = statement.executeQuery(QUERY);
				if (rs != null){
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
	   
	   public boolean DeleteCartID(String username, String id){
		   try
			{
			   System.out.println(username+"-"+id);
			   int x = Integer.parseInt(id);
			   System.out.println(username+"-"+x);
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "DELETE FROM cart_tbl WHERE username='"+username+"' AND id="+x;
				System.out.println(QUERY);
				int result = statement.executeUpdate(QUERY);
				if (result == 1){
					return true;
				}
				return false;
			}
		   catch (Exception e) 
			{
			     e.printStackTrace();
			     return false;
			}
	   }
}
