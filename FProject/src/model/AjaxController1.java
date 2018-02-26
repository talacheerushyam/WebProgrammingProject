package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.*;
import db.flight_booking;

/**
 * Servlet implementation class AjaxController1
 */
@WebServlet("/AjaxController1")
public class AjaxController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxController1() {
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
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		String username = (String) session.getAttribute("username");
		System.out.println("Ajax");
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equals("BuyItems")){
			String cn= request.getParameter("cn");
			String[] fno = new String[2];
			String[] tno= new String[2];
			String[] tc = new String[2];
			String[] fc = new String[2];
			String[] cno= new String[2];
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String booking_date = dateFormat.format(date).toString();
			
			//Get Card Details
			card cc = new card();
			cc.MysqlOpenConnection();
			ResultSet rs = cc.GetCardDetails(username, cn);
			
			flight_booking fb = new flight_booking();
			fb.MysqlOpenConnection();
			//for (int i = 0; i < fno.length; i++)
			//{
				boolean res = fb.ExecuteInsertQuery(username, "F1AirAsia", "3", "1800", booking_date, "f_c",booking_date);
				
			   res = fb.ExecuteInsertQuery(username, "F1AirAsia", "3", "1800", booking_date, "b_c",booking_date);
				
				
			//}
			fb.MysqlCloseConnection();
			
			cart c = new cart();
			c.MysqlOpenConnection();
			res = c.DeleteCartID(username, "5");
			res = c.DeleteCartID(username, "6");
			if (res){
				out.print("1");
			}
		}
	}

}
