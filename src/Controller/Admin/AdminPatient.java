package Controller.Admin;

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
import Model.Patient;

/**
 * Servlet implementation class Patient
 */
@WebServlet("/patient")
public class AdminPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminPatient() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ArrayList<Patient> patients = new ArrayList<Patient>();
		 
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();
           
	           String query = "SELECT * FROM Patient";
	           
	           PreparedStatement pstmt = connection.prepareStatement(query);
	           ResultSet rs = pstmt.executeQuery();
	           
           while (rs.next()) {
        	   Patient p = new Patient();
        	  
               p.setPatient_id(rs.getInt("patient_id"));
               p.setPatient_name(rs.getString("patient_name"));
            
               p.setPatient_gender(rs.getString("patient_gender"));
               p.setPatient_birth_date(rs.getDate("patient_birth_date"));
               p.setPatient_address(rs.getString("patient_address"));
               p.setPatient_contact_no(rs.getString("patient_contact_no"));

               patients.add(p);
           }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		session.setAttribute("patientList",patients);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/admin/ViewPatient.jsp");
		rd.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pname = request.getParameter("patient_name");
        String ppassword = request.getParameter("patient_password");
   
        String pgender = request.getParameter("patient_gender");
        String pbd = request.getParameter("patient_birth_date");
        String paddress = request.getParameter("patient_address");
        String pcno = request.getParameter("patient_contact_no");

        try {
            DBConnection conn = new DBConnection();
            Connection con = conn.getConnection();
            String sql = "INSERT INTO Patient(patient_name, patient_password,patient_gender, patient_birth_date, patient_address, patient_contact_no) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, pname);
            ps.setString(2, ppassword);
           
            ps.setString(3, pgender);
            ps.setString(4, pbd);
            ps.setString(5, paddress);
            ps.setString(6, pcno);
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int patientId = rs.getInt(1);
                HttpSession session = request.getSession();
                session.setAttribute("patientId", patientId);
                session.setAttribute("patientName", pname);
                session.setAttribute("patientPassword", ppassword);
       
                session.setAttribute("patientGender", pgender);
                session.setAttribute("patientBirthDate", pbd);
                session.setAttribute("patientAddress", paddress);
                session.setAttribute("patientContactNo", pcno);

                RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/admin/AdminHome.jsp");
                rd.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
