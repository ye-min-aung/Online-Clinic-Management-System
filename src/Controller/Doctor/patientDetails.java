package Controller.Doctor;

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
import Model.MedicalRecord;
import Model.Patient;

/**
 * Servlet implementation class patientDetails
 */
@WebServlet("/Doctor/patientDetails")
public class patientDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public patientDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		
		int appointment_id = Integer.parseInt(request.getParameter("appointment_id"));
		String patient_id = request.getParameter("patient_id");
		String doctor_id = (String) session.getAttribute("dId");
		Patient patient = new Patient();
		
		  ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();
		
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();
           
			  String query = "SELECT * FROM Patient p INNER JOIN Appointment a ON p.patient_id=a.patient_id WHERE a.appointment_id=?";
//			  String sql = "SELECT * FROM MedicalRecord WHERE patient_id = ?";

	           
		       PreparedStatement pstmt = connection.prepareStatement(query);
	           pstmt.setInt(1, appointment_id);
	           ResultSet rs = pstmt.executeQuery();
	           
	           if (rs.next()) {
	               patient.setPatient_id(rs.getInt("patient_id"));
	               patient.setPatient_name(rs.getString("patient_name"));
	             
	               patient.setPatient_gender(rs.getString("patient_gender"));
	               patient.setPatient_birth_date(rs.getDate("patient_birth_date"));
	               patient.setPatient_address(rs.getString("patient_address"));
	               patient.setPatient_contact_no(rs.getString("patient_contact_no"));
	           }
	           PreparedStatement statement = connection.prepareStatement("SELECT * FROM MedicalRecord WHERE patient_id = ? and doctor_id = ?");
	            statement.setString(1, patient_id);
	            statement.setString(2, doctor_id);
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	            	MedicalRecord medicalRecord = new MedicalRecord();
	                medicalRecord.setRecordId(resultSet.getInt("record_id"));
	                medicalRecord.setPatientId(resultSet.getInt("patient_id"));
	                medicalRecord.setDoctorId(resultSet.getInt("doctor_id"));
	                medicalRecord.setVisitDate(resultSet.getDate("visit_date"));
	                medicalRecord.setDiagnosis(resultSet.getString("diagnosis"));
	                medicalRecord.setTreatment(resultSet.getString("treatment"));
	                medicalRecord.setFollowUpDate(resultSet.getDate("follow_up_date"));
	                medicalRecord.setAllergic(resultSet.getString("allergic"));
	                System.out.print(resultSet.getInt("patient_id"));

	                medicalRecords.add(medicalRecord);
	            }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		
		session.setAttribute("patientDetails", patient);
		session.setAttribute("medicalRecords", medicalRecords);
		
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/doctor/patientDetails.jsp");
		rd.forward(request, response);
	}

}