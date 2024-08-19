package Controller.Appointment;

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

import Model.Appointment;
import Model.DBConnection;
import Model.Patient;

/**
 * Servlet implementation class scheduleAppointment
 */
@WebServlet("/Appointment/scheduleAppointment")
public class scheduleAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public scheduleAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
		ArrayList<Appointment> appoints= new ArrayList<Appointment>();
		 
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();

			  String query = "SELECT a.appointment_id,a.appointment_date,a.status,a.appointment_time,p.patient_name,d.doctor_name,r.reception_name FROM Appointment a INNER JOIN Patient p ON a.patient_id=p.patient_id INNER JOIN Reception r ON a.reception_id=r.reception_id INNER JOIN Doctor d ON a.doctor_id=d.doctor_id where a.status='Pending'";
	
	           PreparedStatement pstmt = connection.prepareStatement(query);
	           ResultSet rs = pstmt.executeQuery();
	           System.out.print(query);
	           
	           while (rs.next()) {
	        	   Appointment a = new Appointment();
               
               a.setAppointment_id(rs.getInt("appointment_id"));
               a.setAppointment_date(rs.getDate("appointment_date"));
               a.setPatient_name(rs.getString("patient_name"));
               a.setDoctor_name(rs.getString("doctor_name"));
               a.setStatus(rs.getString("status"));
               a.setReception_name(rs.getString("reception_name"));
               a.setAppointment_time(rs.getString("appointment_time"));

               appoints.add(a);
           }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		session.setAttribute("appointList",appoints);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/reception/displayScheduleAppointment.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 	int appointment_id = Integer.parseInt(request.getParameter("appointment_id"));
		 
		 	HttpSession session=request.getSession();
			ArrayList<Appointment> appoints= new ArrayList<Appointment>();
			
	        try {
	            Connection con = DBConnection.getConnection();
	            String sql = "UPDATE Appointment SET status = ? WHERE appointment_id = ?";
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, "Accept"); 
	            pstmt.setInt(2, appointment_id);
	            pstmt.executeUpdate();
	            
	          //Get patient name for the message
	            String patientName = getPatientName(appointment_id, con);
	          //Set a success message for the patient
	            request.setAttribute("successMessage", patientName +" , appointment has been accepted.");
	            
	           String query = "SELECT a.appointment_id,a.appointment_date,a.status,a.appointment_time,p.patient_name,d.doctor_name,r.reception_name FROM Appointment a INNER JOIN Patient p ON a.patient_id=p.patient_id INNER JOIN Reception r ON a.reception_id=r.reception_id INNER JOIN Doctor d ON a.doctor_id=d.doctor_id where a.status='Pending'";
	           
	           pstmt = con.prepareStatement(query);
	           ResultSet rs = pstmt.executeQuery();
            
	            while (rs.next()) {
		        	   Appointment a = new Appointment();
	               
	               a.setAppointment_id(rs.getInt("appointment_id"));
	               a.setAppointment_date(rs.getDate("appointment_date"));
	               a.setPatient_name(rs.getString("patient_name"));
	               a.setDoctor_name(rs.getString("doctor_name"));
	               a.setStatus(rs.getString("status"));
	               a.setReception_name(rs.getString("reception_name"));
	               a.setAppointment_time(rs.getString("appointment_time"));

	               appoints.add(a);
	           }
	        }
			catch (ClassNotFoundException e){
				e.printStackTrace();
			}
				catch (SQLException e) {
					e.printStackTrace();
			}
			session.setAttribute("appointList",appoints);
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/reception/displayScheduleAppointment.jsp");
			rd.forward(request, response);
	
	}

	private String getPatientName(int appointmentId, Connection con) throws SQLException {
        String query = "SELECT p.patient_name FROM Appointment a JOIN Patient p ON a.patient_id = p.patient_id WHERE a.appointment_id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, appointmentId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("patient_name");
        }
		return null;
	}
}
