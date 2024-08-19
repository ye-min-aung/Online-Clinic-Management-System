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
import javax.servlet.http.HttpSession;

import Model.DBConnection;
import Model.Invoice;
import Model.MedicalRecord;
import Model.Patient;

/**
 * Servlet implementation class patientMedicalInfo
 */
@WebServlet("/patientMedicalInfo")
public class patientMedicalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public patientMedicalInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patient_id = request.getParameter("patient_id");
		
		  ArrayList<MedicalRecord> medicalRecord = new ArrayList<>();
		  ArrayList<Invoice> invoice = new ArrayList<>();
		
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();
           
//			  String query = "SELECT "
//			  		+ " p.patient_name, "
//			  		+ "d.doctor_name, "
//			  		+ "pr.prescription_date, "
//			  		+ "d.consultation_fee, "
//			  		+ "SUM(m.unit_price * pr.frequency * pr.duration) + d.consultation_fee AS total_cost "
//			  		+ "FROM "
//			  		+ "Prescription pr "
//			  		+ "JOIN Patient p ON pr.patient_id = p.patient_id "
//			  		+ "JOIN Doctor d ON pr.doctor_id = d.doctor_id "
//			  		+ "JOIN Medicine m ON pr.medicine_id = m.medicine_id "
//			  		+ "WHERE p.patient_id=? "
//			  		+ "GROUP BY "
//			  		+ "p.patient_name, "
//			  		+ "d.doctor_name, "
//			  		+ "pr.prescription_date, "
//			  		+ "d.consultation_fee "
//			  		+ "ORDER BY "
//			  		+ "p.patient_name;";
            
            String query = "SELECT "
            		+ "p.patient_name, "
            		+ "d.doctor_name, "
            		+ "pr.prescription_date, "
            		+ "d.consultation_fee, "
            	    + "SUM(m.unit_price * pr.frequency * pr.duration) + d.consultation_fee AS total_cost "
            	    + "FROM "
            		+ " Prescription pr "
            	    + "JOIN Patient p ON pr.patient_id = p.patient_id "
            		+ "JOIN Doctor d ON pr.doctor_id = d.doctor_id "
            		+ "JOIN Medicine m ON pr.medicine_id = m.medicine_id "
            		+ "WHERE "
            		+ "p.patient_id =? "
            	    + "GROUP BY "
            		+ "p.patient_name, "
            	    + "d.doctor_name, "
            	    + " pr.prescription_date, "
            	    + "d.consultation_fee "
            	    + "ORDER BY "
            		+ "p.patient_name;";

	           
		       PreparedStatement pstmt = connection.prepareStatement(query);
	           pstmt.setInt(1, Integer.parseInt(patient_id));
	           ResultSet rs = pstmt.executeQuery();
	           
	           while (rs.next()) {
	        	   Invoice i = new Invoice();
	               i.setPatient_name(rs.getString("patient_name"));
	               i.setDoctor_name(rs.getString("doctor_name"));
	               i.setPrescription_date(rs.getDate("prescription_date"));
	               i.setConsultation_fee(rs.getString("consultation_fee"));
	               i.setTotal_cost(rs.getDouble("total_cost"));
	               invoice.add(i);
	           }
	           PreparedStatement statement = connection.prepareStatement("SELECT * FROM MedicalRecord WHERE patient_id = ?");
	            statement.setString(1, patient_id);
	            ResultSet resultSet = statement.executeQuery();

	            while (resultSet.next()) {
	            	MedicalRecord m = new MedicalRecord();
	                m.setRecordId(resultSet.getInt("record_id"));
	                m.setPatientId(resultSet.getInt("patient_id"));
	                m.setDoctorId(resultSet.getInt("doctor_id"));
	                m.setVisitDate(resultSet.getDate("visit_date"));
	                m.setDiagnosis(resultSet.getString("diagnosis"));
	                m.setTreatment(resultSet.getString("treatment"));
	                m.setFollowUpDate(resultSet.getDate("follow_up_date"));
	                m.setAllergic(resultSet.getString("allergic"));

	                medicalRecord.add(m);
	            }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("invoice", invoice);
		session.setAttribute("medicalRecord", medicalRecord);
		
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/patient/patientMedicalInfo.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
