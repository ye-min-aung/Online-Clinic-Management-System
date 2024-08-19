package Controller.Doctor;

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

import Model.DBConnection;
import Model.Medicine;

/**
 * Servlet implementation class doctorPrescription
 */
@WebServlet("/Doctor/doctorMedicine")
public class doctorMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doctorMedicine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
     
            HttpSession session = request.getSession();
            
            session.removeAttribute("medicines");
            
            session.setAttribute("prescription_date", request.getParameter("prescription_date"));
            
            session.setAttribute("notes", request.getParameter("notes"));

            // Retrieve appointment ID from request
            int appointmentId = Integer.parseInt(request.getParameter("appointment_id"));
            
            try {
    			
				DBConnection conn = new DBConnection();
				Connection connection = conn.getConnection();
            // Get the appointment details from the database
            String query = "SELECT p.patient_name FROM Appointment a JOIN Patient p ON a.patient_id = p.patient_id WHERE a.appointment_id = ?";
           
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, appointmentId);
	        ResultSet rs = pstmt.executeQuery();
            
            String patientName = null;
            if (rs.next()) {
                patientName = rs.getString("patient_name");
            }

            // Store the appointment details in the session
            session.setAttribute("appointment", appointmentId); // Store appointment ID
            session.setAttribute("patientName", patientName); // Store patient name
            

            }
    		catch (ClassNotFoundException e){
    			e.printStackTrace();
    		}
    			catch (SQLException e) {
    				e.printStackTrace();
    		}

        RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/doctor/Prescription.jsp");
        rd.forward(request, response);
	}

}
