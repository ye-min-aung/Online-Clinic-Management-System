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
import Model.Doctor;

/**
 * Servlet implementation class confirmDoctorAccount
 */
@WebServlet("/admin/confirmDoctorAccount")
public class confirmDoctorAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmDoctorAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get doctor ID from the form
        int doctorId = Integer.parseInt(request.getParameter("doctor_id"));
    	HttpSession session=request.getSession();
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE Doctor SET is_confirmed = 1 WHERE doctor_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, doctorId);
            int rs = ps.executeUpdate();
            
            String query = "SELECT * FROM Doctor";
	           
	           PreparedStatement pstmt = con.prepareStatement(query);
	           ResultSet r = pstmt.executeQuery();
	           
	        while (r.next()) {
	     	   Doctor d = new Doctor();
	            d.setDoctor_id(r.getInt("doctor_id"));
	            d.setDoctor_name(r.getString("doctor_name"));
	            d.setDoctor_password(r.getString("doctor_password"));
	            d.setDoctor_gender(r.getString("doctor_gender"));
	            d.setDoctor_qualification(r.getString("doctor_qualification"));
	            d.setDoctor_specialization(r.getString("doctor_specialization"));
	            d.setDoctor_contact_no(r.getString("doctor_contact_no"));
	            d.setDoctor_address(r.getString("doctor_address"));
	            d.setDoctor_email(r.getString("doctor_email"));
	            d.setYear_of_experience(r.getInt("year_of_experience"));
	            d.setConsultation_fee(r.getString("consultation_fee"));
	            d.setIs_confirmed(r.getInt("is_confirmed"));
	
	            doctors.add(d);
	        }
	        	session.setAttribute("doctorList", doctors);

            // Redirect back to the ViewDoctor page
            RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/admin/ViewDoctor.jsp");
            rd.forward(request, response);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}