package model;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.prepayparking;

/**
 * Servlet implementation class prepayServlet
 */
@WebServlet("/prepayServlet")
public class prepayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prepayServlet() {
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
		
		String prePayPark = request.getParameter("pp_update");
		System.out.println(prePayPark);
	
		if (prePayPark.matches("Update Slots")) {
			
			String pp_slots = request.getParameter("pp_slots");
			String vip_slots = request.getParameter("vip_slots");
			String normal_slots = request.getParameter("normal_slots");
			String vip_slots_cost = request.getParameter("vip_slots_cost");
			String normal_slots_cost = request.getParameter("normal_slots_cost");
			pp_slots = "120";
			System.out.println(pp_slots+","+vip_slots+","+normal_slots+","+vip_slots_cost+","+normal_slots_cost);
			
			if(pp_slots.length() != 0  && vip_slots.length() != 0 && normal_slots.length() != 0
					&& vip_slots_cost.length() != 0 && normal_slots_cost.length() != 0){
				
				prepayparking prepay = new prepayparking();
				
				prepay.MysqlOpenConnection();
				
				boolean res = prepay.ExecuteUpdateQuery(pp_slots, vip_slots, normal_slots, vip_slots_cost, normal_slots_cost);
			
				if(res){
					prepay.MysqlCloseConnection();
					System.out.println(res);
					String message = "Pre Pay Parking Updated Successfully !!!";
					response.sendRedirect("updateppp.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

					//String redirectURL= "updateppp.jsp";  
		           // response.sendRedirect(redirectURL); 
				}
				else{
					prepay.MysqlCloseConnection();
					System.out.println(res);
					String message = "Pre Pay Parking Updation Unsuccessfully, Please Try again later !!!";
					response.sendRedirect("updateppp.jsp?message=" + URLEncoder.encode(message, "UTF-8"));

				}
				prepay.MysqlOpenConnection();
			}
		}
	}

}
