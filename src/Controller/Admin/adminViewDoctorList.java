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
import Model.Reception;

/**
 * Servlet implementation class adminViewDoctorList
 */
@WebServlet("/adminViewDoctorList")
public class adminViewDoctorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminViewDoctorList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		HttpSession session=request.getSession();
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		 
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();
           
	           String query = "SELECT * FROM Doctor";
	           
	           PreparedStatement pstmt = connection.prepareStatement(query);
	           ResultSet rs = pstmt.executeQuery();
	           
           while (rs.next()) {
        	   Doctor d = new Doctor();
               
               d.setDoctor_id(rs.getInt("doctor_id"));
               d.setDoctor_name(rs.getString("doctor_name"));
               d.setDoctor_password(rs.getString("doctor_password"));
               d.setDoctor_gender(rs.getString("doctor_gender"));
               d.setDoctor_qualification(rs.getString("doctor_qualification"));
               d.setDoctor_specialization(rs.getString("doctor_specialization"));
               d.setDoctor_contact_no(rs.getString("doctor_contact_no"));
               d.setDoctor_address(rs.getString("doctor_address"));
               d.setDoctor_email(rs.getString("doctor_email"));
               d.setYear_of_experience(rs.getInt("year_of_experience"));
               d.setConsultation_fee(rs.getString("consultation_fee"));
               d.setIs_confirmed(rs.getInt("is_confirmed"));

               doctors.add(d);
           }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		session.setAttribute("doctorList",doctors);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/admin/ViewDoctor.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchName = request.getParameter("searchName");
		HttpSession session=request.getSession();
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		 
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();
           
	           String query = "SELECT * FROM Doctor WHERE doctor_id=? OR doctor_name = ? OR doctor_specialization = ? OR doctor_address = ?";
	           
	           PreparedStatement pstmt = connection.prepareStatement(query);
	           pstmt.setString(1, searchName);
	           pstmt.setString(2, searchName);
	           pstmt.setString(3, searchName);
	           pstmt.setString(4, searchName);
	           ResultSet rs = pstmt.executeQuery();
	           
           while (rs.next()) {
        	   Doctor d = new Doctor();
               
        	   d.setDoctor_id(rs.getInt("doctor_id"));
               d.setDoctor_name(rs.getString("doctor_name"));
               d.setDoctor_password(rs.getString("doctor_password"));
               d.setDoctor_gender(rs.getString("doctor_gender"));
               d.setDoctor_qualification(rs.getString("doctor_qualification"));
               d.setDoctor_specialization(rs.getString("doctor_specialization"));
               d.setDoctor_contact_no(rs.getString("doctor_contact_no"));
               d.setDoctor_address(rs.getString("doctor_address"));
               d.setDoctor_email(rs.getString("doctor_email"));
               d.setYear_of_experience(rs.getInt("year_of_experience"));
               d.setConsultation_fee(rs.getString("consultation_fee"));
               d.setIs_confirmed(rs.getInt("is_confirmed"));

               doctors.add(d);
           }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		session.setAttribute("doctorList",doctors);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/admin/ViewDoctor.jsp");
		rd.forward(request, response);
		
	} 

}