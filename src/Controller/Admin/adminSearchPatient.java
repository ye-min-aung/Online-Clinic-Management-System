package Controller.Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DBConnection;
import Model.Patient;
import Model.Reception;

/**
 * Servlet implementation class adminSearchPatient
 */
@WebServlet("/adminSearchPatient")
public class adminSearchPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminSearchPatient() {
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
		String searchName = request.getParameter("searchName");
		HttpSession session=request.getSession();
		ArrayList<Patient> patients = new ArrayList<Patient>();
		 
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();
           
	           String query = "SELECT * FROM Patient WHERE patient_id LIKE ? OR patient_name LIKE ? OR patient_gender LIKE ? OR patient_address LIKE ?";
	           
	           PreparedStatement pstmt = connection.prepareStatement(query);
	           
	           pstmt.setString(1, searchName);
	           pstmt.setString(2, searchName);
	           pstmt.setString(3, searchName);
	           pstmt.setString(4, searchName);
	           
	           ResultSet rs = pstmt.executeQuery();
	           System.out.println(query);
	           
           while (rs.next()) {
        	   Patient p = new Patient();
        	  
               p.setPatient_id(rs.getInt("patient_id"));
               p.setPatient_name(rs.getString("patient_name"));
            
               p.setPatient_gender(rs.getString("patient_gender"));
               p.setPatient_birth_date(rs.getDate("patient_birth_date"));
               p.setPatient_address(rs.getString("patient_address"));
               p.setPatient_contact_no(rs.getString("patient_contact_no"));

               patients.add(p);
           }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		session.setAttribute("patientList",patients);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/admin/ViewPatient.jsp");
		rd.forward(request, response);
	}

}
