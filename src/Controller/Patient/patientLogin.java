package Controller.Patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DBConnection;

/**
 * Servlet implementation class login
 */
@WebServlet("/Patient/login")
public class patientLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public patientLogin() {
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
		String name=request.getParameter("patient_name");
		String password=request.getParameter("patient_password");
		
		
		try {
			Connection con=DBConnection.getConnection();
			String query="SELECT * FROM Patient WHERE patient_name=? AND patient_password=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				String patientName = rs.getString("patient_name");
				String patientId = rs.getString("patient_id");
				
				HttpSession session = request.getSession();
				session.setAttribute("patientId", patientId);
                session.setAttribute("patientName", patientName);
				RequestDispatcher rd=request.getRequestDispatcher("/views/Clinic/patient/patientHome.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("loginError", "Username or password Wrong!");

				RequestDispatcher rd=request.getRequestDispatcher("/views/welcome/All.jsp");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
