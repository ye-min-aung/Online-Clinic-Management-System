package Controller.Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DBConnection;

/**
 * Servlet implementation class Reception
 */
@WebServlet("/admin/create_reception")
public class adminReception extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminReception() {
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
		
		String name = request.getParameter("reception_name");
		String password = request.getParameter("reception_password");
		String gender = request.getParameter("reception_gender");
		String address = request.getParameter("reception_address");
		String date_of_birth = request.getParameter("reception_birth_date");
		
		 try {
             DBConnection conn = new DBConnection();
             Connection connection = conn.getConnection();

             String query = "INSERT INTO Reception (reception_name, reception_password ,reception_address, reception_gender, reception_birth_date, is_confirmed) VALUES (?, ?, ?, ?, ?, 1)";             PreparedStatement pstmt = connection.prepareStatement(query);
             
             pstmt.setString(1,name);
             pstmt.setString(2,password);
             pstmt.setString(3,address);
             pstmt.setString(4,gender);
             pstmt.setString(5,date_of_birth);
             
             pstmt.executeUpdate();
 			  RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/admin/AdminHome.jsp");
 	 			rd.forward(request, response);
		      
         } catch (Exception e) {
        	 e.printStackTrace();
         }
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
