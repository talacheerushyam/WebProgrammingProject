package model;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.flights;

/**
 * Servlet implementation class FilightServlet
 */
@WebServlet("/FilightServlet")
public class FilightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilightServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//String FNO = null;
		//FNO = request.getParameter("FNO");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String flight = request.getParameter("flight");
		System.out.println(flight);
		if (flight.matches("Add Flight")) {
			String AName = request.getParameter("AName");
			String fromPlace = request.getParameter("fromPlace");
			String toPlace = request.getParameter("toPlace");
			String Ftime = request.getParameter("Ftime");
			String Ttime = request.getParameter("Ttime");
			String seats = request.getParameter("seats");
			String Bseats = request.getParameter("Bseats");
			String Fseats = request.getParameter("Fseats");
			String Eseats = request.getParameter("Eseats");
			String bcosts = request.getParameter("bcosts");
			String fcosts = request.getParameter("fcosts");
			String ecosts = request.getParameter("ecosts");
			
			System.out.println(AName+","+fromPlace+","+toPlace+","+Ftime+","+Ttime+","+seats
					+","+Bseats+","+Fseats+","+Eseats+","+bcosts+","+fcosts+","+ecosts);
			
			if(AName.length() != 0 && fromPlace != "select" && toPlace != "select"  && Ftime != "select"
					&& Ttime != "select" && seats.length() != 0 && Bseats.length() != 0 && Fseats.length() != 0 && 
							Eseats.length() != 0 && bcosts.length() != 0 && fcosts.length() != 0 &&
									ecosts.length() != 0){
				
				String FlightNo = GenerateFlightNo(AName);
				
				flights f = new flights();
				f.MysqlOpenConnection();
				
				int count = f.VerifyFlightExists(AName, fromPlace, toPlace, Ftime, Ttime);
				if(count > 0){
					f.MysqlCloseConnection();
					System.out.println("Already Exists");
					String message = "This Flight Already Exists !!!";
					response.sendRedirect("newFlights.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
					
					//String redirectURL= "newFlights.jsp";  
		           // response.sendRedirect(redirectURL); 
				}else{
					boolean result = f.ExecuteInsertQuery(FlightNo, AName, fromPlace, toPlace, Ftime, Ttime, seats, Bseats, Fseats, Eseats, bcosts, fcosts, ecosts);
					if(result){
						f.MysqlCloseConnection();
						System.out.println(result);
						String message = "New Flight Details Inserted Successfully !!!";
						response.sendRedirect("newFlights.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
						
						
						//String redirectURL= "newFlights.jsp";  
			            //response.sendRedirect(redirectURL); 
					}
				}
			}
		} else if (flight.matches("Update Flight")) {
			String FNO = request.getParameter("fno");
			String AName = request.getParameter("name1");
			String fromPlace = request.getParameter("fromPlace");
			String toPlace = request.getParameter("toPlace");
			String Ftime = request.getParameter("Ftime");
			String Ttime = request.getParameter("Ttime");
			String seats = request.getParameter("seats");
			String Bseats = request.getParameter("Bseats");
			String Fseats = request.getParameter("Fseats");
			String Eseats = request.getParameter("Eseats");
			String bcosts = request.getParameter("bcosts");
			String fcosts = request.getParameter("fcosts");
			String ecosts = request.getParameter("ecosts");
			
			System.out.println(AName+","+fromPlace+","+toPlace+","+Ftime+","+Ttime+","+seats
					+","+Bseats+","+Fseats+","+Eseats+","+bcosts+","+fcosts+","+ecosts);
			
			if(AName.length() != 0 && fromPlace != "select" && toPlace != "select" && Ftime != "select"
					&& Ttime != "select" && seats.length() != 0 && Bseats.length() != 0 && Fseats.length() != 0 && 
							Eseats.length() != 0 && bcosts.length() != 0 && fcosts.length() != 0 &&
									ecosts.length() != 0){
				
				flights f = new flights();
				f.MysqlOpenConnection();
				
				int count = f.VerifyFlightExistsUNIQUE(FNO, AName, fromPlace, toPlace, Ftime, Ttime);
				if(count > 0){
					f.MysqlCloseConnection();
					System.out.println("Already Exists");
					String message = "This Flight Already Exists !!!";
					response.sendRedirect("updateDeleteFlights.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
				
					//String redirectURL= "updateDeleteFlights.jsp";  
		            //response.sendRedirect(redirectURL); 
				}else{
					boolean result = f.ExecuteUpdateQuery(FNO, AName, fromPlace, toPlace, Ftime, Ttime, seats, Bseats, Fseats, Eseats, bcosts, fcosts, ecosts);
					if(result){
						f.MysqlCloseConnection();
						System.out.println(result);
						String message = "Flight Details Updates Successfully !!!";
						response.sendRedirect("updateDeleteFlights.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
					
						//String redirectURL= "updateDeleteFlights.jsp";  
			            //response.sendRedirect(redirectURL); 
					}
				}
			}
		}else if (flight.matches("Delete Flight")) {
			
			String FNO = request.getParameter("fno");
			System.out.println(FNO);
			if(FNO.length() != 0){
				flights f = new flights();
				f.MysqlOpenConnection();
				
				boolean result = f.ExecuteDeleteQuery(FNO);
				if(result){
						f.MysqlCloseConnection();
						System.out.println(result);
						String message = "Flight Details Deleted Successfully !!!";
						response.sendRedirect("updateDeleteFlights.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
					
						//String redirectURL= "updateDeleteFlights.jsp";  
			           // response.sendRedirect(redirectURL); 
					}
			}
		}
		
	}
	
	String GenerateFlightNo(String AName){
		String FlightNo = null;
		
		flights f = new flights();
		f.MysqlOpenConnection();
		int count = f.GetNoOfFlights(AName);
		System.out.println(count);
		f.MysqlCloseConnection();
		
		FlightNo = "F"+count+AName;
		System.out.println(FlightNo);
		return FlightNo;
	}

}
