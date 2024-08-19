package Controller.Doctor;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/doctor/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String dname=request.getParameter("doctor_name");
		String dpassword=request.getParameter("doctor_password");
		
 
		
		try {
			Connection con =  DBConnection.getConnection();
			String query = "SELECT * From Doctor WHERE doctor_name = ? AND doctor_password=? AND is_confirmed=1";
			PreparedStatement p = con.prepareStatement(query);
			p.setString(1,dname);
			p.setString(2, dpassword);
			ResultSet rs = p.executeQuery();
			
			if(rs.next()) {
				 String doctorName = rs.getString("doctor_name");
			     String dId = rs.getString("doctor_id");
			        
			     HttpSession session = request.getSession();
			     session.setAttribute("dId", dId);
			     session.setAttribute("dname", dname);
			     session.setMaxInactiveInterval(7 * 24 * 60 * 60); // 7 days in seconds
			     
				RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/doctor/index.jsp");
				rd.forward(request, response);
				System.out.println("Login Success");
			}else {
				request.setAttribute("DloginError", "Username or Password Wrong! or Account not confirmed yet.");
				RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/Home.jsp");
				rd.include(request, response);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

 

}

