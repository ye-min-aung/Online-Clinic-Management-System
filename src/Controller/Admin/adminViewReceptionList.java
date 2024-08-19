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
import Model.Reception;

/**
 * Servlet implementation class adminViewReceptionList
 */
@WebServlet("/adminViewReceptionList")
public class adminViewReceptionList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminViewReceptionList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		HttpSession session=request.getSession();
		ArrayList<Reception> receptions = new ArrayList<Reception>();
		 
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();
           
	           String query = "SELECT * FROM Reception";
	           
	           PreparedStatement pstmt = connection.prepareStatement(query);
	           ResultSet rs = pstmt.executeQuery();
	           
           while (rs.next()) {
               Reception r = new Reception();
               
               r.setReception_id(rs.getInt("reception_id"));
               r.setReception_name(rs.getString("reception_name"));
               r.setReception_password(rs.getString("reception_password"));
               r.setReception_address(rs.getString("reception_address"));
               r.setReception_gender(rs.getString("reception_gender"));
               r.setReception_birth_date(rs.getDate("reception_birth_date"));
               r.setIs_confirmed(rs.getInt("is_confirmed"));

               receptions.add(r);
           }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		session.setAttribute("receptionList",receptions);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/admin/viewReceptionList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String searchName = request.getParameter("searchName");
		HttpSession session=request.getSession();
		ArrayList<Reception> receptions = new ArrayList<Reception>();
		 
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();
           
	           String query = "SELECT * FROM Reception WHERE reception_name = ? OR reception_id = ? OR reception_address = ?";
	           
	           PreparedStatement pstmt = connection.prepareStatement(query);
	           pstmt.setString(1, searchName);
	           pstmt.setString(2, searchName);
	           pstmt.setString(3, searchName);
	           ResultSet rs = pstmt.executeQuery();
	           
           while (rs.next()) {
        	   	Reception r = new Reception();
               
               r.setReception_id(rs.getInt("reception_id"));
               r.setReception_name(rs.getString("reception_name"));
               r.setReception_password(rs.getString("reception_password"));
               r.setReception_address(rs.getString("reception_address"));
               r.setReception_gender(rs.getString("reception_gender"));
               r.setReception_birth_date(rs.getDate("reception_birth_date"));
               r.setIs_confirmed(rs.getInt("is_confirmed"));


               receptions.add(r);
           }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		session.setAttribute("receptionList",receptions);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/admin/viewReceptionList.jsp");
		rd.forward(request, response);
		
	} 
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
