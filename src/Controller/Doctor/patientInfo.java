package Controller.Doctor;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class patientInfo
 */
@WebServlet("/patientInfo")
public class patientInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public patientInfo() {
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
		PrintWriter out=response.getWriter();
		out.println("hello");
		ArrayList<Patient> patientList = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		response.setContentType("text/html");
		

		

		try {
			con = DBConnection.getConnection();
			String sql = "SELECT patient_name, patient_age, patient_gender, patient_birth_date, patient_address, patient_contact_no, patient_register_date FROM Patient";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Patient patient = new Patient();
				patient.setPatient_name(rs.getString("patient_name"));
			
				patient.setPatient_gender(rs.getString("patient_gender"));
				patient.setPatient_birth_date(rs.getDate("patient_birth_date"));
				patient.setPatient_address(rs.getString("patient_address"));
				patient.setPatient_contact_no(rs.getString("patient_contact_no"));
				patient.setPatient_register_date(rs.getDate("patient_register_date"));
				patientList.add(patient);
			}
		
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		HttpSession session = request.getSession();
		session.setAttribute("patientList", patientList);
		out.println(patientList);

		RequestDispatcher rd = request.getRequestDispatcher("views/Clinic/doctor/PatientInfo.jsp");
		rd.forward(request, response);
	
		
		
	}
}

