package model;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cartServlet
 */
@WebServlet("/cartServlet")
public class cartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cartServlet() {
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
		
		//String cartId[] = request.getParameterValues("checkbox");
		
		String[] results = request.getParameterValues("checkbox");
		for (int i = 0; i < results.length; i++) {
		    System.out.println(results[i]); 
		}
		
		System.out.println(results.length);
		String arr = "&";
		for (int i=0; i< results.length; i++){
			 arr = arr +"id="+results[i];
			 System.out.println(arr);
			 if (i!=(results.length-1))
				 arr = arr + "&";
		}
		System.out.println(arr);
		if (results.length > 0)
		{
			response.sendRedirect("bookcart.jsp?name=cart"+arr);
			
		}else{
			String message = "Some Error while buying the cart items, Please Try again Later  !!!";
			response.sendRedirect("mycart.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
			
		}
	}

}
