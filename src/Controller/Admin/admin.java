package Controller.Admin;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.mysql.cj.xdevapi.Statement;

import Model.DBConnection;

/**
 * Servlet implementation class admin
 */
@WebServlet("/admin/loign")
public class admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.println("Hello");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		    String name = request.getParameter("adminName");
		    String password = request.getParameter("admin_password");
		    
		    if (password.length() < 8 ) {
		    	request.setAttribute("loginError", "password must be at least 8");
	            RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/Home.jsp");
	            rd.include(request, response);
	            return;
	        }

		    try {
		        Connection con = DBConnection.getConnection();
		        String query = "SELECT * FROM Admin WHERE admin_name = ? AND admin_password=?";
		        PreparedStatement p = con.prepareStatement(query);
		        p.setString(1, name);
		        p.setString(2, password);
		        ResultSet rs = p.executeQuery();
		        if (rs.next()) {
		            String adminName = rs.getString("admin_name");
		            String adminId = rs.getString("admin_id");

		            HttpSession session = request.getSession();
		            session.setMaxInactiveInterval(7 * 24 * 60 * 60); // 7 days in seconds
		            session.setAttribute("adminId", adminId);
		            session.setAttribute("adminName", adminName);
		            RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/admin/AdminHome.jsp");
		            rd.forward(request, response);
		        } else {
		            request.setAttribute("loginError", "Username or password Wrong!");
		            RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/Home.jsp");
		            rd.include(request, response);
		        }
		    } catch (ClassNotFoundException | SQLException e) {
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
