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
import Model.Doctor;

/**
 * Servlet implementation class DoctorDelete
 */
@WebServlet("/admin/doctordelete")
public class DoctorDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorDelete() {
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
		String id = request.getParameter("doctor_id");
		HttpSession session=request.getSession();
		ArrayList<Doctor> doctors = new ArrayList<Doctor>();
		System.out.print(id);
		 try {
				Connection con=DBConnection.getConnection();
				 
				String sql="DELETE FROM Doctor WHERE doctor_id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, id);
				
				int rs=ps.executeUpdate();

			           String query = "SELECT * FROM Doctor";
			           
			           PreparedStatement pstmt = con.prepareStatement(query);
			           ResultSet r = pstmt.executeQuery();
			           
		           while (r.next()) {
		        	   Doctor d = new Doctor();
		               d.setDoctor_id(r.getInt("doctor_id"));
		               d.setDoctor_name(r.getString("doctor_name"));
		               d.setDoctor_password(r.getString("doctor_password"));
		               d.setDoctor_gender(r.getString("doctor_gender"));
		               d.setDoctor_qualification(r.getString("doctor_qualification"));
		               d.setDoctor_specialization(r.getString("doctor_specialization"));
		               d.setDoctor_contact_no(r.getString("doctor_contact_no"));
		               d.setDoctor_address(r.getString("doctor_address"));
		               d.setDoctor_email(r.getString("doctor_email"));
		               d.setYear_of_experience(r.getInt("year_of_experience"));
		               d.setConsultation_fee(r.getString("consultation_fee"));
		               d.setIs_confirmed(r.getInt("is_confirmed"));

		               doctors.add(d);
		           }
				session.setAttribute("doctorList", doctors);
				RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/admin/ViewDoctor.jsp");
				rd.forward(request, response);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
