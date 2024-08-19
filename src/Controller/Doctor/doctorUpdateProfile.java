package Controller.Doctor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Model.DBConnection;

/**
 * Servlet implementation class doctorUpdateProfile
 */
@WebServlet("/doctorUpdateProfile")
@MultipartConfig(maxFileSize = 16177215, maxRequestSize = 20971520)
public class doctorUpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doctorUpdateProfile() {
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
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
        
			String dId = (String) session.getAttribute("dId");
			String dname = request.getParameter("doctor_name");
			String dgender = request.getParameter("doctor_gender"); 
	        String dqualification= request.getParameter("doctor_qualification");
	        String dspecialization = request.getParameter("doctor_specialization");
	        String dcno= request.getParameter("doctor_contact_no");
	        String daddress = request.getParameter("doctor_address");
	        String demail = request.getParameter("doctor_email");
	        String dyearofexperience = request.getParameter("year_of_experience");
	        
	        Part filePart = request.getPart("doctor_image");
	        String fileName = filePart.getSubmittedFileName();
	      
	        String filePath = getServletContext().getRealPath("C:\\ICTRC GroupIV\\ClinicManagementSystem\\WebContent\\uploads") + fileName;

	       try {
	         filePart.write(filePath);
	         } catch (Exception e) {
	          e.printStackTrace();
	      }
	         
	        try {
	        	Connection con = DBConnection.getConnection();
	        	String query = "UPDATE Doctor SET doctor_name=?, doctor_gender=?, doctor_qualification=?, doctor_specialization=?, doctor_contact_no=?, doctor_address=?, doctor_email=?, year_of_experience=? ,doctor_image=? WHERE doctor_id=?";
	        	PreparedStatement ps = con.prepareStatement(query);


	        	ps.setString(1, dname);
	        	ps.setString(2, dgender);
	        	ps.setString(3, dqualification);
	        	ps.setString(4, dspecialization);
	        	ps.setString(5, dcno);
	        	ps.setString(6, daddress);
	        	ps.setString(7, demail);
	        	ps.setString(8, dyearofexperience);
	        	ps.setString(9, fileName);
	        	ps.setString(10, dId);
	        	
	        	int rowsUpdated = ps.executeUpdate();

	            
	        	if (rowsUpdated > 0) {
	        	    // Update session attributes if update was successful
	        	    session.setAttribute("dname", dname);
	        	    session.setAttribute("dgender", dgender);
	        	    session.setAttribute("dqualification", dqualification);
	        	    session.setAttribute("dspecialization", dspecialization);
	        	    session.setAttribute("dcno", dcno);
	        	    session.setAttribute("daddress", daddress);
	        	    session.setAttribute("demail", demail);
	        	    session.setAttribute("dyearofexperience", dyearofexperience);
	        	    session.setAttribute("fileName", fileName);
	        	    
	        	    // Redirect to appropriate page
	        	    RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/doctor/index.jsp");
	        	    rd.forward(request, response);
	        	} else {
	        	    // Handle if no rows were updated
	        	    RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/doctor/doctorProfile.jsp");
	        	    rd.forward(request, response);
	        	}
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	  }
	
	 
	}


