package Controller.Reception;

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
 * Servlet implementation class receptionUpdateProfile
 */
@WebServlet("/Reception/receptionUpdateProfile")
public class receptionUpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public receptionUpdateProfile() {
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
        
		String receptionId = (String) session.getAttribute("receptionId");
		String receptionName = request.getParameter("reception_name");
        String receptionPassword = request.getParameter("reception_password");
        String receptionAddress = request.getParameter("reception_address");
        String receptionGender = request.getParameter("reception_gender");
        String receptionBirthDate = request.getParameter("reception_birth_date");

        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE Reception SET reception_name=?, reception_password=?, reception_address=?, reception_gender=?, reception_birth_date=? WHERE reception_id=?";
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, receptionName);
            ps.setString(2, receptionPassword);
            ps.setString(3, receptionAddress);
            ps.setString(4, receptionGender);
            ps.setString(5, receptionBirthDate);
            ps.setString(6, receptionId);

            int rowsUpdated = ps.executeUpdate();
            
            if (rowsUpdated > 0) {
            	session.setAttribute("receptionName", receptionName);
            	session.setAttribute("receptionPassword", receptionPassword);
            	session.setAttribute("receptionAddress", receptionAddress);
            	session.setAttribute("receptionGender", receptionGender);
            	session.setAttribute("receptionBirthDate", receptionBirthDate);
            	
				RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/reception/receptionIndex.jsp");
				rd.forward(request, response);
            } else {
				RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/reception/receptionUpdateProfile.jsp");
				rd.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}
}
