package model;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.car;
import db.flights;

/**
 * Servlet implementation class CarServlet
 */
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarServlet() {
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
		String car = request.getParameter("car");
		System.out.println(car);
		if (car.matches("Add Car")) {
			String car_no = request.getParameter("carno");
			String car_type = request.getParameter("cartype");
			String car_make = request.getParameter("carmake");
			String rent_cost = request.getParameter("cost");
			
			System.out.println(car_no+","+car_type+","+car_make+","+rent_cost);
			
			if(car_no.length() != 0 && car_type != "select" && car_make != "select"  && rent_cost.length() != 0){
				car c = new car();
				c.MysqlOpenConnection();
				int count = c.VerifyCarExists(car_no);
				if(count > 0){
					c.MysqlCloseConnection();
					System.out.println("Already Exists");
					
					String message = "Car Details Already Exists!!!";
					response.sendRedirect("newCars.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
					
					//String redirectURL= "newCars.jsp";  
		           // response.sendRedirect(redirectURL); 
				}else{
					boolean result = c.ExecuteCarInsertQuery(car_no, car_type, car_make, rent_cost);
					if(result){
						c.MysqlCloseConnection();
						System.out.println(result);
						String message = "Car Details Inserted Successfully !!!";
						response.sendRedirect("newCars.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
						
						//String redirectURL= "newCars.jsp";  
			            //response.sendRedirect(redirectURL); 
					}else{
						c.MysqlCloseConnection();
						System.out.println(result);
						String message = "Car Details Insertion Unsuccessfully !!!";
						response.sendRedirect("newCars.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
						
					}
				}
			}
			
		}else if (car.matches("Update Car")) {
			String car_no = request.getParameter("carno");
			String car_type = request.getParameter("cartype");
			String car_make = request.getParameter("carmake");
			String rent_cost = request.getParameter("cost");
			
			System.out.println(car_no+","+car_type+","+car_make+","+rent_cost);
			
			if(car_no.length() != 0 && car_type != "select" && car_make != "select"  && rent_cost.length() != 0){
				car c = new car();
				c.MysqlOpenConnection();
				
				int count = c.VerifyCarExistsUNIQUE(car_no,car_type, car_make, rent_cost);
				if(count > 0){
					c.MysqlCloseConnection();
					System.out.println("Already Exists");
					String message = "Car Details Already Exists!!!";
					response.sendRedirect("updateDeleteCars.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
					
				//	String redirectURL= "updateDeleteCars.jsp";  
		        //    response.sendRedirect(redirectURL); 
				}else{
					boolean result = c.ExecuteCarUpdateQuery(car_no, car_type, car_make, rent_cost);
					if(result){
						c.MysqlCloseConnection();
						System.out.println(result);
						String message = "Car Details Updated Successfully !!!";
						response.sendRedirect("updateDeleteCars.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
						
						//String redirectURL= "updateDeleteCars.jsp";  
			           // response.sendRedirect(redirectURL); 
					}else{
						c.MysqlCloseConnection();
						System.out.println(result);
						String message = "Car Details Updation Unsuccessfully !!!";
						response.sendRedirect("updateDeleteCars.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
						
					}
				}
			}
		}else if (car.matches("Delete Car")) {
			String carno = request.getParameter("carno");
			
			System.out.println(carno);
			if(carno.length() != 0){
				car c = new car();
				c.MysqlOpenConnection();
				
				boolean result = c.ExecuteDeleteQuery(carno);
				if(result){
						c.MysqlCloseConnection();
						System.out.println(result);
						String message = "Car Details Deleted Successfully !!!";
						response.sendRedirect("updateDeleteCars.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
						
						//String redirectURL= "updateDeleteCars.jsp";  
			           // response.sendRedirect(redirectURL); 
					} else{
						c.MysqlCloseConnection();
						System.out.println(result);
						String message = "Car Details Deletion Unsuccessfully !!!";
						response.sendRedirect("updateDeleteCars.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
						
					}
			}
		}
	}

}
