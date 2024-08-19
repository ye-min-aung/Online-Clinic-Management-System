package Controller.Reception;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DBConnection;

/**
 * Servlet implementation class receptionLogin
 */
@WebServlet("/Reception/receptionLogin")
public class receptionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public receptionLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("reception_name");
        String password = request.getParameter("reception_password");
      
        try {
            DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();

            String query = "SELECT * FROM Reception WHERE reception_name = ? AND reception_password = ? AND is_confirmed=1";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
            	
            	String receptionName = rs.getString("reception_name");
				String receptionId = rs.getString("reception_id");
				
				HttpSession session = request.getSession();
				session.setAttribute("receptionId", receptionId);
                session.setAttribute("receptionName", receptionName);
                
	            session.setMaxInactiveInterval(7 * 24 * 60 * 60); // 7 days in seconds

            	
                RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/reception/receptionIndex.jsp");
    			rd.forward(request, response);
            } else {
            	request.setAttribute("rloginError", "Username or Password Wrong! or Account not confirmed yet.");
                RequestDispatcher rd = request.getRequestDispatcher("/views/Clinic/Home.jsp");
                rd.include(request, response);
            }
            
        } catch (Exception e) {
			e.printStackTrace();
        }

	}

}
