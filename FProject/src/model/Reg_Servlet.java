package model;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import db.customer;

/**
 * Servlet implementation class Reg_Servlet
 */
@WebServlet("/Reg_Servlet")
public class Reg_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg_Servlet() {
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
		
String action = request.getParameter("Register");
		
		System.out.println("servlet");
		System.out.println(action);
		
		if ("Register".equals(action)){
			System.out.println("admin action");
			
			String uname = request.getParameter("uname");
			String npass = request.getParameter("npass");
			String  cpass = request.getParameter("cpass");
			String  name = request.getParameter("name");
			String  email = request.getParameter("email");
			String  ph = request.getParameter("ph");
					
			if ((uname.length() != 0) && (npass.length() != 0) && (cpass.length() != 0)&& (name.length() != 0)
					&& (email.length() != 0)&& (ph.length() != 0) ){
				
				customer newcustomer = new customer();
				newcustomer.MysqlOpenConnection();
				boolean result = newcustomer.ExecuteInsertQuery(uname, npass, name, email, Integer.parseInt(ph));
				if (result){
					String message = "Customer Registered Successfully !!!";
					response.sendRedirect("customerReg.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
					//String redirectURL= "customerReg.jsp";  
		           // response.sendRedirect(redirectURL); 
				}
				else{
					System.out.println("Customer Registeration unsuccessful");
				}
				newcustomer.MysqlCloseConnection();
			}
		}
		
	}

}
