package Controller.Reception;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DBConnection;

/**
 * Servlet implementation class receptionRegister
 */
@WebServlet("/Reception/receptionRegister")
public class receptionRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public receptionRegister() {
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

		 String receptionName = request.getParameter("reception_name");
         String receptionPassword = request.getParameter("reception_password");
         String receptionAddress = request.getParameter("reception_address");
         String receptionGender = request.getParameter("reception_gender");
         String receptionBirthDate = request.getParameter("reception_birth_date");
         try {
             DBConnection conn = new DBConnection();
             Connection connection = conn.getConnection();

             String query = "INSERT INTO Reception (reception_name, reception_password ,reception_address, reception_gender, reception_birth_date, is_confirmed) VALUES (?, ?, ?, ?, ?, ?)";
             PreparedStatement pstmt = connection.prepareStatement(query);
             
             pstmt.setString(1, receptionName);
             pstmt.setString(2, receptionPassword);
             pstmt.setString(3, receptionAddress);
             pstmt.setString(4, receptionGender);
             pstmt.setString(5, receptionBirthDate);
             pstmt.setInt(6,0);
             
             pstmt.executeUpdate();
 			  RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/Home.jsp");
 	 			rd.forward(request, response);
		      
         } catch (Exception e) {
        	 e.printStackTrace();
         }
	}

}
