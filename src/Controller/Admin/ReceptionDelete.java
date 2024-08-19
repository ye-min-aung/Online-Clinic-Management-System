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
import Model.Reception;

/**
 * Servlet implementation class ReceptionDelete
 */
@WebServlet("/admin/receptiondelete")
public class ReceptionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceptionDelete() {
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
		String id = request.getParameter("reception_id");
		System.out.println(id);
		HttpSession session=request.getSession();
		ArrayList<Reception> receptions = new ArrayList<Reception>();
		 try {
				Connection con=DBConnection.getConnection();
				 
				String sql="DELETE FROM Reception WHERE reception_id=?";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, id);
				int rs=ps.executeUpdate();

			           String query = "SELECT * FROM Reception";
			           
			           PreparedStatement pstmt = con.prepareStatement(query);
			           ResultSet r = pstmt.executeQuery();
			           
		           while (r.next()) {
		        	   Reception rec = new Reception();
		        	   rec.setReception_id(r.getInt("reception_id"));
		               rec.setReception_name(r.getString("reception_name"));
		               rec.setReception_address(r.getString("reception_address"));
		               rec.setReception_gender(r.getString("reception_gender"));
		               rec.setReception_birth_date(r.getDate("reception_birth_date"));

		               receptions.add(rec);
		           }
		        session.setAttribute("receptionList",receptions);
		   		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/admin/viewReceptionList.jsp");
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
