package Controller.Admin;

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
 * Servlet implementation class adminDoctorUpdateProfile
 */
@WebServlet("/Admin/adminDoctorUpdateProfile")
@MultipartConfig(maxFileSize = 16177215, maxRequestSize = 20971520)
public class adminDoctorUpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminDoctorUpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
        
		String doctorId = (String) session.getAttribute("doctorId");
		String doctorName = request.getParameter("doctor_name");
        String doctorPassword = request.getParameter("doctor_password");
        String doctorGender = request.getParameter("doctor_gender");
        String doctorAddress = request.getParameter("doctor_address");
        String doctorQualification = request.getParameter("doctor_qualification");
        String doctorSpecialization = request.getParameter("doctor_specialization");
        String doctorContact_no = request.getParameter("doctor_contact_no");
        String doctorEmail = request.getParameter("doctor_email");
        String year = request.getParameter("year_of_experience");
        String fee = request.getParameter("consultation_fee");
        
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
            String query = "UPDATE Doctor SET doctor_name=?, doctor_password=?, doctor_gender=?, doctor_address=?, doctor_qualification=?, doctor_specialization=?, doctor_contact_no=?, doctor_email=?, year_of_experience=?, consultation_fee=? ,doctor_image=? WHERE doctor_id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, doctorName);
            ps.setString(2, doctorPassword);
            ps.setString(3, doctorGender);
            ps.setString(4, doctorAddress);
            ps.setString(5, doctorQualification);
            ps.setString(6, doctorSpecialization);
            ps.setString(7, doctorContact_no);
            ps.setString(8, doctorEmail);
            ps.setString(9, year);
            ps.setString(10, fee);
            ps.setString(11, fileName);
            ps.setString(12, doctorId);

            int rowsUpdated = ps.executeUpdate();
            
            if (rowsUpdated > 0) {
            	session.setAttribute("doctorName", doctorName);
            	session.setAttribute("doctorPrassword", doctorPassword);
            	session.setAttribute("doctorGender", doctorGender);
            	session.setAttribute("doctorAddress", doctorAddress);
            	session.setAttribute("doctorQualification", doctorQualification);
            	session.setAttribute("doctorSpecialization", doctorSpecialization);
            	session.setAttribute("doctorContact_no", doctorContact_no);
            	session.setAttribute("year", year);
            	session.setAttribute("fee", fee);
            	session.setAttribute("doctorEmail", doctorEmail);
            	session.setAttribute("fileName", fileName);
            	 
				RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/admin/AdminHome.jsp");
				rd.forward(request, response);
            } else {
				RequestDispatcher rd = request.getRequestDispatcher("");
				rd.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}

}
