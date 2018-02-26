package db;

import java.sql.DriverManager;
import java.sql.ResultSet;

public class card {

	private String username;
	private String cc_no;
	private String expire_date;
	private String s_no;
	
	java.sql.Connection conn;
	java.sql.Statement statement = null;
	ResultSet rs = null;
	
	
	public card(String username, String cc_no, String expire_date, String s_no) {
		super();
		this.username = username;
		this.cc_no = cc_no;
		this.expire_date = expire_date;
		this.s_no = s_no;
	}

	public card() {
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
	 * @return the cc_no
	 */
	public String getCc_no() {
		return cc_no;
	}

	/**
	 * @param cc_no the cc_no to set
	 */
	public void setCc_no(String cc_no) {
		this.cc_no = cc_no;
	}

	/**
	 * @return the expire_date
	 */
	public String getExpire_date() {
		return expire_date;
	}

	/**
	 * @param expire_date the expire_date to set
	 */
	public void setExpire_date(String expire_date) {
		this.expire_date = expire_date;
	}

	/**
	 * @return the s_no
	 */
	public String getS_no() {
		return s_no;
	}

	/**
	 * @param s_no the s_no to set
	 */
	public void setS_no(String s_no) {
		this.s_no = s_no;
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
   
   public boolean ExecuteInsertQuery(String username, String cc_no, String expire_date, String s_no){
	   try
		{
		   String QUERY = "INSERT INTO cc_tbl (username, cc_no, expire_date, s_no) values"
		   		+ "('"+username+"','"+cc_no+"','"+expire_date+"','"+s_no+"')";
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
   
   public ResultSet GetCard(String username){
	   try
		{
		   int count = 0;
		    statement = ((java.sql.Connection) conn).createStatement();
			String QUERY = "SELECT * FROM cc_tbl WHERE username='"+username+"'";
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
   
   public ResultSet GetCardDetails(String username, String cc_no){
	   try
		{
		   int count = 0;
		    statement = ((java.sql.Connection) conn).createStatement();
			String QUERY = "SELECT * FROM cc_tbl WHERE username='"+username+"' AND cc_no='"+cc_no+"'";
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
}
