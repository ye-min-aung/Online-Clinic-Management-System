package Controller.Doctor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DBConnection;

/**
 * Servlet implementation class medicalRecord
 */
@WebServlet("/medicalRecord")
public class medicalRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public medicalRecord() {
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
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	         
	        HttpSession session = request.getSession();
	        
	        
	        if (session != null) {
		        
		        // Retrieve doctor_id from session
		        String dId = (String) session.getAttribute("dId");
		        
		        // Parameters from the form
		        
		        
		        String visitDate = request.getParameter("visit_date");
		        String diagnosis = request.getParameter("diagnosis");
		        String treatment = request.getParameter("treatment");
		        String followUpDate = request.getParameter("follow_up_date");
		        String allergic = request.getParameter("allergic");
		        
		        String patientId = request.getParameter("patient_id");

		        try {
		            Connection con = DBConnection.getConnection();
		            
		            // SQL statement with doctor_id included
		            String sql = "INSERT INTO MedicalRecord(patient_id, doctor_id, visit_date, diagnosis, treatment, follow_up_date, allergic) VALUES (?, ?, ?, ?, ?, ?, ?)";
		            PreparedStatement ps = con.prepareStatement(sql);
		            ps.setString(1, patientId);
		            ps.setString(2, dId);
		            ps.setString(3, visitDate);
		            ps.setString(4, diagnosis);
		            ps.setString(5, treatment);
		            ps.setString(6, followUpDate);
		            ps.setString(7, allergic);
		            
		            int rowsInserted = ps.executeUpdate();
		            if (rowsInserted > 0) {
		                System.out.println("A new medical record was inserted successfully!");
		            } else {
		                System.out.println("Failed to insert the medical record.");
		            }
		      
		        } catch (ClassNotFoundException | SQLException e) {
		            // Proper error handling
		            e.printStackTrace();
		        }
		        }
		        RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/doctor/patientList.jsp");
		        rd.forward(request, response);

	    }
	}
