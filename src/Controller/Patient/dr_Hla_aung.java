package Controller.Patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DBConnection;

/**
 * Servlet implementation class dr_Hla_aung
 */
@WebServlet("/hlaaung")
public class dr_Hla_aung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dr_Hla_aung() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("hiiiiiiiiiiiiiiii");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		try {
			Connection con=DBConnection.getConnection();
			String query="SELECT * FROM Doctor WHERE doctor_id=2";
			
			PreparedStatement pst=con.prepareStatement(query);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				String dQualification=rs.getString("doctor_qualification");
				String dSpecialization=rs.getString("doctor_specialization");
				String dContactNo=rs.getString("doctor_contact_no");
				String dConsultationFee=rs.getString("consultation_fee");
				
			    System.out.println(dQualification);
				
				request.setAttribute("dQualification", dQualification);
		        request.setAttribute("dSpecialization", dSpecialization);
		        request.setAttribute("dContactNo", dContactNo);
		        request.setAttribute("dConsultationFee", dConsultationFee);
				
				RequestDispatcher rd=request.getRequestDispatcher("views/Clinic/patient/doctorprofiledetail/dr_Hla_aung.jsp");
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
