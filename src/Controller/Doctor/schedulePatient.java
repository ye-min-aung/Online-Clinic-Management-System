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

import Model.Appointment;
import Model.DBConnection;
import Model.Patient;

/**
 * Servlet implementation class schedulePatient
 */
@WebServlet("/schedulePatient")
public class schedulePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public schedulePatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
		String doctorId = (String) session.getAttribute("dId");
		
		ArrayList<Appointment> appointments= new ArrayList<Appointment>();
		
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();

			  String query = "SELECT a.appointment_id,p.patient_id,p.patient_name,a.appointment_date,a.appointment_time,r.reception_name,a.status FROM Appointment a INNER JOIN Patient p ON a.patient_id=p.patient_id INNER JOIN Reception r ON a.reception_id=r.reception_id INNER JOIN Doctor d ON a.doctor_id=d.doctor_id where a.status='Accept' AND d.doctor_id="+doctorId;
	
	           PreparedStatement pstmt = connection.prepareStatement(query);
	           ResultSet rs = pstmt.executeQuery();
	          
	          
	           while (rs.next()) {
	        	   Appointment a = new Appointment();
               
               a.setAppointment_id(rs.getInt("appointment_id"));
               a.setPatient_id(rs.getInt("patient_id"));
               a.setPatient_name(rs.getString("patient_name"));
               a.setAppointment_date(rs.getDate("appointment_date"));
               a.setAppointment_time(rs.getString("appointment_time"));
               a.setReception_name(rs.getString("reception_name")); 
               a.setStatus(rs.getString("status"));
               
               appointments.add(a);
           }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		session.setAttribute("appointment",appointments);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/doctor/patientList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String searchName = request.getParameter("searchName");
		HttpSession session=request.getSession();
		
		ArrayList<Appointment> appointments= new ArrayList<Appointment>();		
		 
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();
           
			  String query = "SELECT a.appointment_id,p.patient_name,a.appointment_date,a.appointment_time,r.reception_name,a.status FROM Appointment a INNER JOIN Patient p ON a.patient_id=p.patient_id INNER JOIN Reception r ON a.reception_id=r.reception_id INNER JOIN Doctor d ON a.doctor_id=d.doctor_id where a.status='Accept' AND a.appointment_date=?";

	           
		       PreparedStatement pstmt = connection.prepareStatement(query);
	           pstmt.setString(1, searchName);
	           ResultSet rs = pstmt.executeQuery();
	           
	           while (rs.next()) {
	        	   
	        	   Appointment a = new Appointment();
	        
	               a.setAppointment_id(rs.getInt("appointment_id"));
	               a.setPatient_name(rs.getString("patient_name"));
	               a.setAppointment_date(rs.getDate("appointment_date"));
	               a.setAppointment_time(rs.getString("appointment_time"));
	               a.setReception_name(rs.getString("reception_name")); 
	               a.setStatus(rs.getString("status"));
	               
	               appointments.add(a);
	              
           }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		

		// Add the appointment date to the session
		
		session.setAttribute("appointment",appointments);
		
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/doctor/patientList.jsp");
		rd.forward(request, response);
	}

}
