/**
 * 
 */
package db;

import java.io.Serializable;
import java.sql.DriverManager;

/**
 * @author bindurechamballiveeranna
 *
 */
public class customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			//instance Variables
			private String uname;
			private String name;
			private String email;
			private int phnoeno;
			private String pass;
			java.sql.Connection conn;
			java.sql.Statement statement = null;
			
			public customer() {
				// TODO Auto-generated constructor stub
				super();
			}
		public customer(String uname, String name, String email, int phnoeno) {
				super();
				this.uname = uname;
				this.name = name;
				this.email = email;
				this.phnoeno = phnoeno;
			}
	
	/**
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

		
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}

	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phnoeno
	 */
	public int getPhnoeno() {
		return phnoeno;
	}

	/**
	 * @param phnoeno the phnoeno to set
	 */
	public void setPhnoeno(int phnoeno) {
		this.phnoeno = phnoeno;
	}

	/**
	 * 
	 */
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
   
   public boolean ExecuteInsertQuery(String username, String pass, String name, String email, int ph){
	   try
		{
		   String QUERY = "INSERT INTO customer_tbl (username,name, email, phone) values('"+username+"','"+name+"','"+email+"',"+ph+")";
		    System.out.println(QUERY);
			int result = statement.executeUpdate(QUERY);
			if(result == 1){
				String QUERY1 = "INSERT INTO login_tbl (username,password1,type)values('"+username+"','"+pass+"','user')";
				result = statement.executeUpdate(QUERY1);
				if (result == 1)
					return true;
				else
					return false;
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
