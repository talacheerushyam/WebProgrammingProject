package db;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class car {

	private String carno ;
	public car(String carno, String cartype, String carmake, String days, String cost) {
		super();
		this.carno = carno;
		this.cartype = cartype;
		this.carmake = carmake;
		Days = days;
		this.cost = cost;
	}

	private String cartype;
	private String carmake;
	private String Days;
	private String cost;
	
	java.sql.Connection conn;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	
	public car() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the carno
	 */
	public String getCarno() {
		return carno;
	}

	/**
	 * @param carno the carno to set
	 */
	public void setCarno(String carno) {
		this.carno = carno;
	}

	/**
	 * @return the cartype
	 */
	public String getCartype() {
		return cartype;
	}

	/**
	 * @param cartype the cartype to set
	 */
	public void setCartype(String cartype) {
		this.cartype = cartype;
	}

	/**
	 * @return the carmake
	 */
	public String getCarmake() {
		return carmake;
	}

	/**
	 * @param carmake the carmake to set
	 */
	public void setCarmake(String carmake) {
		this.carmake = carmake;
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
	 * @return the cost
	 */
	public String getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	public void setCost(String cost) {
		this.cost = cost;
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
   
   public int VerifyCarExists(String carno){
	   try
		{
		   int count = 0;
		    statement = ((java.sql.Connection) conn).createStatement();
			String QUERY = "SELECT COUNT(*) AS total FROM car_tbl WHERE car_no='"+carno+"'";
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
   
   public boolean ExecuteCarInsertQuery(String car_no, String car_type, String car_make, String rent_cost){
	   try
		{
		   String QUERY = "INSERT INTO car_tbl (car_no, car_type, car_make, rent_cost) values"
		   		+ "('"+car_no+"','"+car_type+"','"+car_make+"','"+rent_cost+"')";
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
   
   public int VerifyCarExistsUNIQUE(String car_no, String car_type, String car_make, String rent_cost){
	   try
		{
		   int count = 0;
		    statement = ((java.sql.Connection) conn).createStatement();
			String QUERY = "SELECT COUNT(*) AS total FROM car_tbl WHERE car_no <> '"+car_no+"' AND car_type='"+car_type+"' AND car_make='"+car_make+
					"' AND rent_cost='"+rent_cost+"'";
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
   
   public boolean ExecuteCarUpdateQuery(String car_no, String car_type, String car_make, String rent_cost){
	   try
		{
		   String QUERY = "UPDATE car_tbl SET car_type='"+car_type+"', car_make = '"+car_make+"',rent_cost='"+rent_cost+"' WHERE car_no='"+car_no+"'";
		   
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
   
   public boolean ExecuteDeleteQuery(String car_no){
	   try
		{
		   String QUERY = "UPDATE car_tbl SET status=1 WHERE car_no='"+car_no+"'";
		   
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
   
   public ResultSet GetAllCars(){
	   try
		{
		    statement = ((java.sql.Connection) conn).createStatement();
			String QUERY = "SELECT * FROM car_tbl WHERE status="+0;
			System.out.println(QUERY);
			rs = statement.executeQuery(QUERY);
			if (rs != null){
				System.out.println("Data");
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
   
   public ResultSet GetCarsDetais(String car_no){
	   try
		{
		    statement = ((java.sql.Connection) conn).createStatement();
			String QUERY = "SELECT * FROM car_tbl WHERE car_no='"+car_no+"' AND status=0";
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
}