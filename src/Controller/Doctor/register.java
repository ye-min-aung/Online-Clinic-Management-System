package Controller.Doctor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class register
 */
@WebServlet("/doctor/register")

@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 2, // 2MB
	    maxFileSize = 1024 * 1024 * 10,   // 10MB
	    maxRequestSize = 1024 * 1024 * 50 // 50MB
	)
public class register extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "C:\\ICTRC GroupIV\\ClinicManagementSystem\\WebContent\\uploads";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // You might want to redirect to a registration form page if needed
    	
    }
    

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String dname = request.getParameter("doctor_name");
        String dgender = request.getParameter("doctor_gender");
        String dqualification = request.getParameter("doctor_qualification");
        String dspecialization = request.getParameter("doctor_specialization");
        String dcno = request.getParameter("doctor_contact_no");
        String dpassword = request.getParameter("doctor_password");
        String demail = request.getParameter("doctor_email");
        String dfee = request.getParameter("consultation_fee");
        String yearofexperience = request.getParameter("year_of_experience");
        String daddress = request.getParameter("doctor_address");

        Part filePart = request.getPart("doctor_image");
        String fileName = filePart.getSubmittedFileName();
        
        String uploadPath = UPLOAD_DIR;       
        String filePath = uploadPath + File.separator + fileName;
        
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()) uploadDir.mkdir();

        try {
            filePart.write(filePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e);
        }
        String dbfilePath = fileName;

        try {
            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO Doctor(doctor_name, doctor_password, doctor_gender, doctor_qualification, doctor_specialization, doctor_contact_no, doctor_address, doctor_email, year_of_experience,consultation_fee, doctor_image, is_confirmed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dname);
            ps.setString(2, dpassword);
            ps.setString(3, dgender);
            ps.setString(4, dqualification);
            ps.setString(5, dspecialization);
            ps.setString(6, dcno);
            ps.setString(7, daddress);
            ps.setString(8, demail);
            ps.setString(9, yearofexperience);
            ps.setString(10, dfee);
            ps.setString(11, dbfilePath);
            ps.setInt(12, 0); 

            int rs = ps.executeUpdate();

            RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/Home.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
}