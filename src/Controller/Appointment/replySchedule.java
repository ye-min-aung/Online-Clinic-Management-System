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
 * Servlet implementation class replySchedule
 */
@WebServlet("/Appointment/replySchedule")
public class replySchedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public replySchedule() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchName = request.getParameter("searchName");
		HttpSession session=request.getSession();
		ArrayList<Appointment> appoints= new ArrayList<Appointment>();
			
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();
           
			  String query = "SELECT a.appointment_id,a.appointment_date,a.status,a.appointment_time,p.patient_name,d.doctor_name,r.reception_name FROM Appointment a INNER JOIN Patient p ON a.patient_id=p.patient_id INNER JOIN Reception r ON a.reception_id=r.reception_id INNER JOIN Doctor d ON a.doctor_id=d.doctor_id where a.appointment_date=?";
	           
	           PreparedStatement pstmt = connection.prepareStatement(query);
	           pstmt.setString(1, searchName);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int appointment_id = Integer.parseInt(request.getParameter("appointment_id"));
		 
	 	HttpSession session=request.getSession();
		ArrayList<Appointment> appoints= new ArrayList<Appointment>();
		ArrayList<Appointment> deleteAppoints= new ArrayList<Appointment>();
		
        try {
            Connection con = DBConnection.getConnection();
            
            String deleteAppointment = "SELECT a.appointment_id,a.appointment_date,a.status,a.appointment_time,p.patient_name,d.doctor_name,r.reception_name FROM Appointment a INNER JOIN Patient p ON a.patient_id=p.patient_id INNER JOIN Reception r ON a.reception_id=r.reception_id INNER JOIN Doctor d ON a.doctor_id=d.doctor_id where a.appointment_id=?";
            PreparedStatement appStatemnet = con.prepareStatement(deleteAppointment);
            appStatemnet.setInt(1, appointment_id);
            ResultSet drs = appStatemnet.executeQuery();
         
             while (drs.next()) {
 	        	   Appointment da = new Appointment();
                
                da.setAppointment_id(drs.getInt("appointment_id"));
                da.setAppointment_date(drs.getDate("appointment_date"));
                da.setPatient_name(drs.getString("patient_name"));
                da.setDoctor_name(drs.getString("doctor_name"));
                da.setStatus(drs.getString("status"));
                da.setReception_name(drs.getString("reception_name"));
                da.setAppointment_time(drs.getString("appointment_time"));

                deleteAppoints.add(da);
            }
             session.setAttribute("deleteList",deleteAppoints);
             if (session != null) {
                 session.removeAttribute("UserAppointment");
             }
             
            //Delete the appointment from the database
            String deleteQuery = "DELETE FROM Appointment WHERE appointment_id = ?";
            
            PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
            deleteStmt.setInt(1, appointment_id);
            deleteStmt.executeUpdate();
            
            request.setAttribute("successMessage","Appointment has been cancelled.");
            String qq = "SELECT a.appointment_id,a.appointment_date,a.status,a.appointment_time,p.patient_name,d.doctor_name,r.reception_name FROM Appointment a INNER JOIN Patient p ON a.patient_id=p.patient_id INNER JOIN Reception r ON a.reception_id=r.reception_id INNER JOIN Doctor d ON a.doctor_id=d.doctor_id where a.status='Pending'";
            
            PreparedStatement ps = con.prepareStatement(qq);
            ResultSet r = ps.executeQuery();
         
             while (r.next()) {
 	        	   Appointment a = new Appointment();
                
                a.setAppointment_id(r.getInt("appointment_id"));
                a.setAppointment_date(r.getDate("appointment_date"));
                a.setPatient_name(r.getString("patient_name"));
                a.setDoctor_name(r.getString("doctor_name"));
                a.setStatus(r.getString("status"));
                a.setReception_name(r.getString("reception_name"));
                a.setAppointment_time(r.getString("appointment_time"));

                appoints.add(a);
            }
             session.setAttribute("appointList",appoints);
        }
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/reception/displayScheduleAppointment.jsp");
		rd.forward(request, response);
}
}
