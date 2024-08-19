package Controller.Doctor;

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

import Model.DBConnection;

/**
 * Servlet implementation class doctorChangePw
 */
@WebServlet("/doctorChangePw")
public class doctorChangePw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doctorChangePw() {
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
		// TODO Auto-generated method stub
		String oldPassword = request.getParameter("doctor_password");
        String newPassword = request.getParameter("doctor_newpassword");
        
        try {
            Connection con = DBConnection.getConnection();
            String query = "UPDATE Doctor SET doctor_password=? WHERE doctor_password=?";
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, newPassword);
            pst.setString(2, oldPassword); // setting the old password to verify
            
            int rowsUpdated = pst.executeUpdate();
            
            if (rowsUpdated > 0) {
                RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/doctor/index.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/");
                rd.include(request, response);
            }

            pst.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

	}


	}


