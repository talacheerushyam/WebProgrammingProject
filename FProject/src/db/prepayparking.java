package db;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class prepayparking {

	private String pp_slots;
	private String vip_slots;
	private String normal_slots;
	private String vip_slots_cost;
	private String normal_slots_cost;
	
	java.sql.Connection conn;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	
	public prepayparking(String pp_slots, String vip_slots, String normal_slots, String vip_slots_cost,
			String normal_slots_cost) {
		super();
		this.pp_slots = pp_slots;
		this.vip_slots = vip_slots;
		this.normal_slots = normal_slots;
		this.vip_slots_cost = vip_slots_cost;
		this.normal_slots_cost = normal_slots_cost;
	}

	public prepayparking() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the pp_slots
	 */
	public String getPp_slots() {
		return pp_slots;
	}

	/**
	 * @param pp_slots the pp_slots to set
	 */
	public void setPp_slots(String pp_slots) {
		this.pp_slots = pp_slots;
	}

	/**
	 * @return the vip_slots
	 */
	public String getVip_slots() {
		return vip_slots;
	}

	/**
	 * @param vip_slots the vip_slots to set
	 */
	public void setVip_slots(String vip_slots) {
		this.vip_slots = vip_slots;
	}

	/**
	 * @return the normal_slots
	 */
	public String getNormal_slots() {
		return normal_slots;
	}

	/**
	 * @param normal_slots the normal_slots to set
	 */
	public void setNormal_slots(String normal_slots) {
		this.normal_slots = normal_slots;
	}

	/**
	 * @return the vip_slots_cost
	 */
	public String getVip_slots_cost() {
		return vip_slots_cost;
	}

	/**
	 * @param vip_slots_cost the vip_slots_cost to set
	 */
	public void setVip_slots_cost(String vip_slots_cost) {
		this.vip_slots_cost = vip_slots_cost;
	}

	/**
	 * @return the normal_slots_cost
	 */
	public String getNormal_slots_cost() {
		return normal_slots_cost;
	}

	/**
	 * @param normal_slots_cost the normal_slots_cost to set
	 */
	public void setNormal_slots_cost(String normal_slots_cost) {
		this.normal_slots_cost = normal_slots_cost;
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
   
   public boolean ExecuteUpdateQuery(String pp_slots, String vip_slots, String normal_slots, String vip_slots_cost, String normal_slots_cost){
	   try
		{
		   String QUERY = "UPDATE pp_tbl SET vip_slots='"+vip_slots+"', normal_slots = '"+normal_slots+"',"
		   		+ "vip_slots_cost='"+vip_slots_cost+"', normal_slots_cost='"+normal_slots_cost+"' WHERE pp_slots='"+pp_slots+"'";
		   
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
   
   public ResultSet ExecuteSelectQuery(){
	   try
		{
		    statement = ((java.sql.Connection) conn).createStatement();
			String QUERY = "SELECT * FROM pp_tbl";
			System.out.println(QUERY);
			rs = statement.executeQuery(QUERY);
			if(rs != null){
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
