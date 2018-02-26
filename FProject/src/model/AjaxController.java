package model;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.card;
import db.cart;
import db.flight_booking;
import db.flights;

/**
 * Servlet implementation class AjaxController
 */
@WebServlet("/AjaxController")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxController() {
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
		//doGet(request, response);
		HttpSession session = request.getSession(true);

        String username = (String) session.getAttribute("username");
		System.out.println("Ajax");
		String content = null;
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equals("getFlight"))
		{
			String fno = request.getParameter("fno");
			String tickets = request.getParameter("tickets");
			String fromName = request.getParameter("fromName");
			String toName = request.getParameter("toName");
			String TClass = request.getParameter("TClass");
			
			flights f = new flights();
			f.MysqlOpenConnection();
			ResultSet rs = f.CheckTicketsAvailable(fno);
			ResultSet rs1 = f.GetFlightsDetais(fno);
			 try {
				if (rs.next()) {
					 String total_seats = rs.getString("total_seats");
					 String b_seats = rs.getString("b_seats");
					 String f_seats = rs.getString("f_seats");
					 String e_seats = rs.getString("e_seats");
					 String total_booked = rs.getString("total_booked");
					 String total_b_booked = rs.getString("total_b_booked");
					 String total_f_booked = rs.getString("total_f_booked");
					 String total_e_booked = rs.getString("total_e_booked");
					 if(rs1.next())
					 {
						 String flight_no = rs1.getString("flight_no");
						 String flight_airlines = rs1.getString("flight_airlines");
						 String start_time = rs1.getString("start_time");
						 String reach_time = rs1.getString("reach_time");
						 
						 out.print("<div id=availableFlightDiv><table class=availableFlighttable><tr><th>Flight No</th><th>Airlines</th><th>From</th><th>To</th><th>Starting Time</th><th>Reaching Time</th></tr>"
							 		+ "<tr><td>"+flight_no+"</td><td>"+flight_airlines+"</td><td>"+fromName+"</td><td>"+toName+"</td><td>"+start_time+"</td><td>"+reach_time+"</td></tr></table><br/>");
					 }
					 
					 out.print("<table class=availableFlighttable><tr><th>Total Seats</th><th>Busniess Class</th><th>First Class</th><th>Economy Class</th></tr>"
						 		+ "<tr><td>"+total_seats+"</td><td>"+b_seats+"</td><td>"+f_seats+"</td><td>"+e_seats+"</td></tr></table><br/>");
					 
					 out.print("<table class=availableFlighttable><tr><th>Total Booked Seats</th><th> Booked Busniess Class</th><th>Booked First Class</th><th>Booked Economy Class</th></tr>"
						 		+ "<tr><td>"+total_booked+"</td><td>"+total_b_booked+"</td><td>"+total_f_booked+"</td><td>"+total_e_booked+"</td></tr></table><br/>");
					 int remaining = 0;
					 if (TClass=="b_c")
					 {
						  remaining = Integer.parseInt(b_seats)- Integer.parseInt(total_b_booked);
					 }
						 
					 System.out.println(remaining);
					 if (remaining <= (Integer.parseInt(tickets)))
					 {
						 out.print("<table class=availableFlighttable><tr><td><label class=finalLb>Tickets are available !! <br/></label><a href=book.jsp?name=flight&fno="+fno+"&tickets="+tickets+"&username="+username+"&class="+TClass+">Book This Flight</a></td></tr></table></div>");
					 }else 
					 {
						 out.print("<table class=availableFlighttable><tr><td><label class=finalLb>Tickets are Not available !! <br/></label></td></tr></table></div>");
					 }
					 
					 out.print("<table>");
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 f.MysqlCloseConnection();
			 
		}else if(action.equals("getTo"))
		{
			String from = request.getParameter("fromName");
			String fno = request.getParameter("fno");
			
			flights f = new flights();
			f.MysqlOpenConnection();
			ResultSet rs = f.GetAllToFlightsAjax(fno, from);
			 try {
				while (rs.next()) {
					 String fn = rs.getString("flight_no");
					 String to = rs.getString("to_place");
					 out.println("<option value="+fn+">"+to+"</option>");
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 f.MysqlCloseConnection();
			
		} else  if(action.equals("ToCart")){
			String flight_no = request.getParameter("flight_no");
			String ticket_no = request.getParameter("ticket_no");
			String ticket_class = request.getParameter("ticket_class");
			String ticket_cost = request.getParameter("ticket_cost");
			String final_cost = request.getParameter("final_cost");
			
			cart c = new cart();
			c.MysqlOpenConnection();
			boolean result = c.ExecuteInsertQuery(username, flight_no, ticket_no, ticket_class, ticket_cost, final_cost);
			if (result){
				System.out.println("Success");
				int No_cart = c.GetCart(username);
				out.println(No_cart);
				c.MysqlCloseConnection();
				
				
			} else{
				System.out.println("No");
				out.println("0");
				c.MysqlCloseConnection();
			}		
		}else  if(action.equals("BuyTicket")){
			String cn= request.getParameter("cn");
			String mm= request.getParameter("mm");
			String yy= request.getParameter("yy");
			String sn= request.getParameter("sn");
			String flight_no = request.getParameter("flight_no");
			String ticket_no = request.getParameter("ticket_no");
			String ticket_class = request.getParameter("ticket_class");
			String ticket_cost = request.getParameter("ticket_cost");
			String final_cost = request.getParameter("final_cost");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String booking_date = dateFormat.format(date).toString();
			
			flight_booking fb = new flight_booking();
			fb.MysqlOpenConnection();
			boolean res = fb.ExecuteInsertQuery(username, flight_no, ticket_no, final_cost, booking_date, ticket_class,booking_date);
			if (res){
				card cc = new card();
				cc.MysqlOpenConnection();
				boolean r = cc.ExecuteInsertQuery(username, cn, mm+"/01/"+yy, sn);
				cc.MysqlCloseConnection();
				if (r)
				{
					out.print("1");
				}
				else{
					out.print("0");
				}
			}
			fb.MysqlCloseConnection();
		}else  if(action.equals("BuyItems")){
			String cn= request.getParameter("cn");
			String flight_no = "flight_no";
			String ticket_no = "ticket_no";
			String ticket_class = "ticket_class";
			String ticket_cost = request.getParameter("ticket_cost");
			String final_cost = request.getParameter("final_cost");
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String booking_date = dateFormat.format(date).toString();
			
			//Get Card Details
			card cc = new card();
			cc.MysqlOpenConnection();
			ResultSet rs = cc.GetCardDetails(username, cn);
			
			flight_booking fb = new flight_booking();
			fb.MysqlOpenConnection();
			boolean res = fb.ExecuteInsertQuery(username, flight_no, ticket_no, final_cost, booking_date, ticket_class,booking_date);
			if (res){
				out.print("1");
			}
			else{
				out.print("0");
			}
			fb.MysqlCloseConnection();
		}
		
	}

}
