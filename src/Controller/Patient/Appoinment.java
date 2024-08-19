package Controller.Patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Appointment;
import Model.DBConnection;

/**
 * Servlet implementation class Appoinment
 */
@WebServlet("/Appoinment")
public class Appoinment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appoinment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String patientId = request.getParameter("patient_id");
		HttpSession session=request.getSession();
		ArrayList<Appointment> UserAppointment= new ArrayList<Appointment>();
		 
		try {
		    DBConnection conn = new DBConnection();
		    Connection con = conn.getConnection();

		    String query = "SELECT a.appointment_id, a.appointment_date, a.status, a.appointment_time, p.patient_name, d.doctor_name, d.doctor_specialization, r.reception_name " +
                    "FROM Appointment a " +
                    "INNER JOIN Patient p ON a.patient_id = p.patient_id " +
                    "INNER JOIN Reception r ON a.reception_id = r.reception_id " +
                    "INNER JOIN Doctor d ON a.doctor_id = d.doctor_id " +
                    "WHERE p.patient_id =?";

     PreparedStatement pstmt = con.prepareStatement(query);
     pstmt.setInt(1, Integer.parseInt(patientId));
     ResultSet rs = pstmt.executeQuery();

    
     while (rs.next()) {
         Appointment a = new Appointment();
         a.setAppointment_id(rs.getInt("appointment_id"));
         a.setAppointment_date(rs.getDate("appointment_date"));
         a.setPatient_name(rs.getString("patient_name"));
         a.setDoctor_name(rs.getString("doctor_name"));
         a.setDoctor_specialization(rs.getString("doctor_specialization"));
         a.setStatus(rs.getString("status"));
         a.setReception_name(rs.getString("reception_name"));
         a.setAppointment_time(rs.getString("appointment_time"));
         UserAppointment.add(a);
     
		        int appointment_id;
		        appointment_id = rs.getInt("appointment_id");
		    }
          //Set a success message for the patient
            request.setAttribute("successMessage","Your appointment received. Wait For Comfirmaton");
		    
		} 

		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		session.setAttribute("UserAppointment",UserAppointment);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/patient/patientAppointment.jsp");
		rd.forward(request, response);
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
			String appointment_date = request.getParameter("appointment_date");
		    String doctor_name = request.getParameter("doctor_name");
		    String patient_id = request.getParameter("patient_id");
		    String appointment_time = request.getParameter("appointment_time");
		    String reception_id = request.getParameter("reception_id");

		    try {
		        Connection con = DBConnection.getConnection();

		        String sql = "INSERT INTO Appointment(appointment_date, appointment_time, patient_id, doctor_id, reception_id, status) VALUES (?, ?, ?, (SELECT doctor_id FROM Doctor WHERE doctor_name = ?), ?, ?)";
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setString(1, appointment_date);
		        ps.setString(2, appointment_time);
		        ps.setInt(3, Integer.parseInt(patient_id));
		        ps.setString(4, doctor_name);
		        ps.setInt(5, Integer.parseInt(reception_id));
		        ps.setString(6, "Pending");
		        ps.executeUpdate();

		        // Get the UserAppointment list
		        String query = "SELECT a.appointment_id, a.appointment_date, a.status, a.appointment_time, p.patient_name, d.doctor_name, d.doctor_specialization, r.reception_name " +
		                       "FROM Appointment a " +
		                       "INNER JOIN Patient p ON a.patient_id = p.patient_id " +
		                       "INNER JOIN Reception r ON a.reception_id = r.reception_id " +
		                       "INNER JOIN Doctor d ON a.doctor_id = d.doctor_id " +
		                       "WHERE p.patient_id =?";

		        PreparedStatement pstmt = con.prepareStatement(query);
		        pstmt.setInt(1, Integer.parseInt(patient_id));
		        ResultSet rs = pstmt.executeQuery();

		    	ArrayList<Appointment> UserAppointment= new ArrayList<Appointment>();
		        while (rs.next()) {
		            Appointment a = new Appointment();
		            a.setAppointment_id(rs.getInt("appointment_id"));
		            a.setAppointment_date(rs.getDate("appointment_date"));
		            a.setPatient_name(rs.getString("patient_name"));
		            a.setDoctor_name(rs.getString("doctor_name"));
		            a.setDoctor_specialization(rs.getString("doctor_specialization"));
		            a.setStatus(rs.getString("status"));
		            a.setReception_name(rs.getString("reception_name"));
		            a.setAppointment_time(rs.getString("appointment_time"));
		            UserAppointment.add(a);
		        }

		        // Set the UserAppointment list in the session attribute
		        HttpSession session = request.getSession();
		        session.setAttribute("UserAppointment", UserAppointment);

		        RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/patient/patientAppointment.jsp");
		        rd.forward(request, response);

		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		}
}
