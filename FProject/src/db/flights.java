package db;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class flights {

	private String FlightNo;
	private String AName;
	private String fromPlace;
	private String toPlace;
	private String Days;
	private String Ftime;
	private String Ttime;
	private String seats;
	private String Bseats;
	private String Fseats;
	private String Eseats;
	private String bcosts;
	private String fcosts;
	private String ecosts;
	
	java.sql.Connection conn;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	
	public flights(String aName, String fromPlace, String toPlace, String days, String ftime, String ttime,
			String seats, String bseats, String fseats, String eseats, String bcosts, String fcosts, String ecosts) {
		super();
		AName = aName;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		Days = days;
		Ftime = ftime;
		Ttime = ttime;
		this.seats = seats;
		Bseats = bseats;
		Fseats = fseats;
		Eseats = eseats;
		this.bcosts = bcosts;
		this.fcosts = fcosts;
		this.ecosts = ecosts;
	}

	public flights(String flightNo, String aName, String fromPlace, String toPlace, String days, String ftime,
			String ttime, String seats, String bseats, String fseats, String eseats, String bcosts, String fcosts,
			String ecosts) {
		super();
		FlightNo = flightNo;
		AName = aName;
		this.fromPlace = fromPlace;
		this.toPlace = toPlace;
		Days = days;
		Ftime = ftime;
		Ttime = ttime;
		this.seats = seats;
		Bseats = bseats;
		Fseats = fseats;
		Eseats = eseats;
		this.bcosts = bcosts;
		this.fcosts = fcosts;
		this.ecosts = ecosts;
	}

	public flights() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the aName
	 */
	public String getAName() {
		return AName;
	}

	/**
	 * @param aName the aName to set
	 */
	public void setAName(String aName) {
		AName = aName;
	}

	/**
	 * @return the fromPlace
	 */
	public String getFromPlace() {
		return fromPlace;
	}

	/**
	 * @param fromPlace the fromPlace to set
	 */
	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	/**
	 * @return the toPlace
	 */
	public String getToPlace() {
		return toPlace;
	}

	/**
	 * @param toPlace the toPlace to set
	 */
	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	/**
	 * @return the days
	 */
	public String getDays() {
		return Days;
	}

	/**
	 * @param days the days to set
	 */
	public void setDays(String days) {
		Days = days;
	}

	/**
	 * @return the ftime
	 */
	public String getFtime() {
		return Ftime;
	}

	/**
	 * @param ftime the ftime to set
	 */
	public void setFtime(String ftime) {
		Ftime = ftime;
	}

	/**
	 * @return the ttime
	 */
	public String getTtime() {
		return Ttime;
	}

	/**
	 * @param ttime the ttime to set
	 */
	public void setTtime(String ttime) {
		Ttime = ttime;
	}

	/**
	 * @return the seats
	 */
	public String getSeats() {
		return seats;
	}

	/**
	 * @param seats the seats to set
	 */
	public void setSeats(String seats) {
		this.seats = seats;
	}

	/**
	 * @return the bseats
	 */
	public String getBseats() {
		return Bseats;
	}

	/**
	 * @param bseats the bseats to set
	 */
	public void setBseats(String bseats) {
		Bseats = bseats;
	}

	/**
	 * @return the fseats
	 */
	public String getFseats() {
		return Fseats;
	}

	/**
	 * @param fseats the fseats to set
	 */
	public void setFseats(String fseats) {
		Fseats = fseats;
	}

	/**
	 * @return the eseats
	 */
	public String getEseats() {
		return Eseats;
	}

	/**
	 * @param eseats the eseats to set
	 */
	public void setEseats(String eseats) {
		Eseats = eseats;
	}

	/**
	 * @return the bcosts
	 */
	public String getBcosts() {
		return bcosts;
	}

	/**
	 * @param bcosts the bcosts to set
	 */
	public void setBcosts(String bcosts) {
		this.bcosts = bcosts;
	}

	/**
	 * @return the fcosts
	 */
	public String getFcosts() {
		return fcosts;
	}

	/**
	 * @param fcosts the fcosts to set
	 */
	public void setFcosts(String fcosts) {
		this.fcosts = fcosts;
	}

	/**
	 * @return the ecosts
	 */
	public String getEcosts() {
		return ecosts;
	}

	/**
	 * @param ecosts the ecosts to set
	 */
	public void setEcosts(String ecosts) {
		this.ecosts = ecosts;
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
	   
	   public boolean ExecuteInsertQuery(String flight_no, String flight_airlines, String from_place, String to_place, String start_time, String reach_time, 
			    String total_seats,String b_c,String f_c,String e_c,
			   String cost_b,String cost_f,String cost_e){
		   try
			{
			   String QUERY = "INSERT INTO flight_tbl (flight_no, flight_airlines, from_place, to_place, start_time, reach_time,  total_seats,"
			   		+ " b_c, f_c, e_c, cost_b, cost_f, cost_e) values('"+flight_no+"','"+flight_airlines+"','"+from_place+"','"+to_place+"','"+start_time
			   		+"','"+reach_time+"',"+ Integer.parseInt(total_seats)
			   		+ ","+ Integer.parseInt(b_c)+","+ Integer.parseInt(f_c)+","+ Integer.parseInt(e_c)+",'"+cost_b+"','"+cost_f+"','"+cost_e+"')";
			    System.out.println(QUERY);
				int result = statement.executeUpdate(QUERY);
				if(result == 1)
				{
						seats s = new seats();
						s.MysqlOpenConnection();
						boolean rr = s.ExecuteInsertQuery(flight_no, total_seats, b_c, f_c, e_c);
						if (rr)
							return true;
						else 
							return false;
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
	   
	   public boolean ExecuteUpdateQuery(String flight_no, String flight_airlines, String from_place, String to_place, String start_time, String reach_time, 
			    String total_seats,String b_c,String f_c,String e_c,
			   String cost_b,String cost_f,String cost_e){
		   try
			{
			   String QUERY = "UPDATE flight_tbl SET flight_airlines='"+flight_airlines+"', from_place='"+from_place+"', to_place = '"+to_place+"',"
			   		+ "start_time='"+start_time+"', reach_time='"+reach_time+"', total_seats="+ Integer.parseInt(total_seats)
			   		+ ",b_c="+ Integer.parseInt(b_c)+", f_c="+ Integer.parseInt(f_c)+", e_c="+ Integer.parseInt(e_c)+", "
			   				+ "cost_b='"+cost_b+"', cost_f='"+cost_f+"', cost_e='"+cost_f+"' WHERE flight_no='"+flight_no+"'";
			   
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
	    
	   public boolean ExecuteDeleteQuery(String flight_no){
		   try
			{
			   String QUERY = "UPDATE flight_tbl SET status=1 WHERE flight_no='"+flight_no+"'";
			   
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
	   
	   public int GetNoOfFlights(String AName){
		   try
			{
			   int count = 0;
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "SELECT COUNT(*) AS total FROM flight_tbl where flight_airlines='"+AName+"'";
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
	   
	   public int VerifyFlightExists(String AName, String from_place, String to_place,String start_time, String reach_time){
		   try
			{
			   int count = 0;
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "SELECT COUNT(*) AS total FROM flight_tbl WHERE flight_airlines='"+AName+"' AND from_place='"+from_place+
						"' AND to_place='"+to_place+"' AND start_time='"+start_time+"' AND reach_time='"+reach_time+"'";
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
	   
	   public int VerifyFlightExistsUNIQUE(String FNO, String AName, String from_place, String to_place,String start_time, String reach_time){
		   try
			{
			   int count = 0;
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "SELECT COUNT(*) AS total FROM flight_tbl WHERE flight_no <> '"+FNO+"' AND flight_airlines='"+AName+"' AND from_place='"+from_place+
						"' AND to_place='"+to_place+"' AND start_time='"+start_time+"' AND reach_time='"+reach_time+"'";
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
	   
	   public ResultSet GetAllFlights(){
		   try
			{
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "SELECT * FROM flight_tbl WHERE status="+0;
				System.out.println(QUERY);
				rs = statement.executeQuery(QUERY);
				if (rs.next()){
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
	   
	   public ResultSet GetAllFromFlights(){
		   try
			{
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "SELECT flight_no, from_place FROM flight_tbl WHERE status="+0;
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
	   
	   public ResultSet GetAllToFlights(){
		   try
			{
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "SELECT flight_no, to_place FROM flight_tbl WHERE status="+0;
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
	   public ResultSet GetAllToFlightsAjax(String flight_no, String from_place){
		   try
			{
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "SELECT flight_no, to_place FROM flight_tbl WHERE flight_no='"+flight_no+"' AND from_place='"+from_place+"' AND status="+0;
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
	   
	   
	   public ResultSet GetFlightsDetais(String FNO){
		   try
			{
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "SELECT * FROM flight_tbl WHERE flight_no='"+FNO+"' AND status=0";
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
	   
	   public ResultSet CheckTicketsAvailable(String FNO){
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

	/**
	 * @return the flightNo
	 */
	public String getFlightNo() {
		return FlightNo;
	}

	/**
	 * @param flightNo the flightNo to set
	 */
	public void setFlightNo(String flightNo) {
		FlightNo = flightNo;
	}
	   

}
