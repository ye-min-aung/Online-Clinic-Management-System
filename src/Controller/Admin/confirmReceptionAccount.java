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
 * Servlet implementation class confirmReceptionAccount
 */
@WebServlet("/admin/confirmReceptionAccount")
public class confirmReceptionAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmReceptionAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rId = Integer.parseInt(request.getParameter("reception_id"));
    	HttpSession session=request.getSession();
		ArrayList<Reception> receptions = new ArrayList<Reception>();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "UPDATE Reception SET is_confirmed = 1 WHERE reception_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rId);
            int rt = ps.executeUpdate();
            
            String query = "SELECT * FROM Reception";
	           
	           PreparedStatement pstmt = con.prepareStatement(query);
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
        session.setAttribute("receptionList",receptions);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/admin/viewReceptionList.jsp");
		rd.forward(request, response);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
