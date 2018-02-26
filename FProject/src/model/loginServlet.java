package model;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String action = request.getParameter("submitBtn");
		String username;
		String pass;
		System.out.println("servlet");
		System.out.println(action);
		
		if ("Admin Login".equals(action)){
			System.out.println("admin action");
			
			username = request.getParameter("auid");
			pass = request.getParameter("apwd");
			System.out.println(username);
			if ((username.length() != 0) && (pass.length() != 0)){
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webprog", "hemanth", "hemanth");
					java.sql.Statement statement = null;
					statement = ((java.sql.Connection) conn).createStatement();
					String QUERY = "SELECT * FROM login_tbl where username='"+username+"' AND password1='"+pass+"' AND type='admin'";
					ResultSet rs = statement.executeQuery(QUERY);
					if(rs.next()){
						System.out.println("result sets");
						HttpSession session = request.getSession(true);
						session.setAttribute("username", username);
						session.setAttribute("pass", pass);
						session.setAttribute("type", "admin");
						
						String redirectURL= "adminHome.jsp";  
			            response.sendRedirect(redirectURL); 
					}
					else{
						System.out.println("Session Set");
						request.setAttribute("statusMsg", "Admin is not there");
						System.out.println(request.getAttribute("statusMsg"));
						
						
						RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				        dispatcher.forward(request, response);
				        
						//String redirectURL= "index.jsp";  
			           // response.sendRedirect(redirectURL); 
					}
				}
				catch (Exception e) 
				{
				     e.printStackTrace();
				}
			}
			
		} else if("Customer Login".equals(action)){
				System.out.println("Customer Login");
			
			username = request.getParameter("cuid");
			pass = request.getParameter("cpwd");
			
			if ((username.length() != 0) && (pass.length() != 0)){
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webprog", "hemanth", "hemanth");
					java.sql.Statement statement = null;
					statement = ((java.sql.Connection) conn).createStatement();
					String QUERY = "SELECT * FROM login_tbl where username='"+username+"' AND password1='"+pass+"' AND type='user'";
					ResultSet rs = statement.executeQuery(QUERY);
					if(rs.next()){
						System.out.println("result sets");
						HttpSession session = request.getSession(true);
						session.setAttribute("username", username);
						session.setAttribute("pass", pass);
						session.setAttribute("type", "user");
						
						String redirectURL= "customerHome.jsp";  
			            response.sendRedirect(redirectURL); 
					}
					else{
						request.setAttribute("statusMsg", "Customer Doesnt Exists !!!");
						
						String redirectURL= "index.jsp";  
			            response.sendRedirect(redirectURL); 
					}
				}
				catch (Exception e) 
				{
				     e.printStackTrace();
				}
			}
			
			
		} else if("SIGN UP".equals(action)){
			String redirectURL= "customerReg.jsp";  
            response.sendRedirect(redirectURL); 
		}
	}

}
