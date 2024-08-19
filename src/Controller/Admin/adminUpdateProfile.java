package Controller.Admin;

import java.io.IOException;
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
 * Servlet implementation class adminUpdateProfile
 */
@WebServlet("/Admin/adminUpdateProfile")
public class adminUpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminUpdateProfile() {
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
        
		String adminId = (String) session.getAttribute("adminId");
		String adminName = request.getParameter("admin_name");
        String adminPassword = request.getParameter("admin_password");
        String adminContact = request.getParameter("admin_contact_no");
        String adminAddress = request.getParameter("admin_address");

        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE Admin SET admin_name=?, admin_password=?, admin_contact_no=?, admin_address=? WHERE admin_id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, adminName);
            ps.setString(2, adminPassword);
            ps.setString(3, adminContact);
            ps.setString(4, adminAddress);
            ps.setString(5, adminId);

            int rowsUpdated = ps.executeUpdate();
            
            if (rowsUpdated > 0) {
            	session.setAttribute("adminName", adminName);
            	session.setAttribute("adminPassword", adminPassword);
            	session.setAttribute("adminContact", adminContact);
            	session.setAttribute("adminAddress", adminAddress);
            	
				RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/admin/AdminHome.jsp");
				rd.forward(request, response);
            } else {
				RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/admin/editProfile.jsp");
				rd.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}

}
