package db;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class airlines {

	int id;
	String airline_name;
	java.sql.Connection conn;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	
	public airlines(int id, String airline_name) {
		super();
		this.id = id;
		this.airline_name = airline_name;
	}
	public airlines() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the airline_name
	 */
	public String getAirline_name() {
		return airline_name;
	}
	/**
	 * @param airline_name the airline_name to set
	 */
	public void setAirline_name(String airline_name) {
		this.airline_name = airline_name;
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
	   
	   public ResultSet ExecuteSelectQuery(){
		   try
			{
			    statement = ((java.sql.Connection) conn).createStatement();
				String QUERY = "SELECT * FROM airlines_tbl";
				rs = statement.executeQuery(QUERY);
				if(rs.next()){
						return rs;
				}
					else
						return rs;
			}
		   catch (Exception e) 
			{
			     e.printStackTrace();
			     return rs;
			}
	   }
}
