package Controller.Patient;

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

import Model.DBConnection;
import Model.Doctor;

@WebServlet("/Patient/patientDoctorList")
public class patientDoctorList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			Connection con = DBConnection.getConnection();
			String sql = "SELECT * FROM Doctor WHERE  is_confirmed=1";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ArrayList<Doctor> doctorList = new ArrayList<>();
			while (rs.next()) {
				Doctor doctor = new Doctor();
				doctor.setDoctor_id(rs.getInt("doctor_id"));
				doctor.setDoctor_name(rs.getString("doctor_name"));
				doctor.setDoctor_gender(rs.getString("doctor_gender"));
				doctor.setDoctor_qualification(rs.getString("doctor_qualification"));
				doctor.setDoctor_specialization(rs.getString("doctor_specialization"));
				doctor.setDoctor_contact_no(rs.getString("doctor_contact_no"));
				doctor.setDoctor_address(rs.getString("doctor_address"));
				doctor.setDoctor_email(rs.getString("doctor_email"));
				doctor.setYear_of_experience(rs.getInt("year_of_experience"));
				doctor.setConsultation_fee(rs.getString("consultation_fee"));
				doctor.setDoctor_image(rs.getString("doctor_image"));
				doctorList.add(doctor);
			}
			request.setAttribute("doctorList", doctorList);
			
			RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/patient/patientDoctorList.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}