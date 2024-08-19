package Controller.Doctor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DBConnection;
import Model.Medicine;

/**
 * Servlet implementation class medicineViewSearch
 */
@WebServlet("/Doctor/medicineViewSearch")
public class medicineViewSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public medicineViewSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		List<Medicine> medicines = new ArrayList<>();
		try {
			
				DBConnection conn = new DBConnection();
				Connection connection = conn.getConnection();
           
	           String query = "SELECT medicine_id,medicine_name,brand,unit,expiration_date FROM Medicine";
	           PreparedStatement pstmt = connection.prepareStatement(query);
	           ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {
	                Medicine medicine = new Medicine();
	                medicine.setMedicine_id(rs.getInt("medicine_id"));
	                medicine.setMedicine_name(rs.getString("medicine_name"));
	                medicine.setBrand(rs.getString("brand"));
	                medicine.setUnit(rs.getString("unit"));
	                medicine.setExpiration_date(rs.getDate("expiration_date"));
	                medicines.add(medicine);
	            }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}

	      session.setAttribute("medicines", medicines);
	      RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/doctor/medicine.jsp");
			rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String searchName = request.getParameter("searchName");
	    HttpSession session = request.getSession();
	    List<Medicine> medicines = new ArrayList<>();
	    try {
	        DBConnection conn = new DBConnection();
	        Connection connection = conn.getConnection();

	        String query = "SELECT * FROM Medicine WHERE medicine_id = ? OR medicine_name = ? OR brand = ?";

	        PreparedStatement pstmt = connection.prepareStatement(query);
	        pstmt.setString(1, searchName);
	        pstmt.setString(2, searchName);
	        pstmt.setString(3, searchName);
	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            Medicine medicine = new Medicine();
	            medicine.setMedicine_id(rs.getInt("medicine_id"));
	            medicine.setMedicine_name(rs.getString("medicine_name"));
	            medicine.setBrand(rs.getString("brand"));
	            medicine.setUnit(rs.getString("unit"));
	            medicine.setExpiration_date(rs.getDate("expiration_date"));
	            medicines.add(medicine);
	        }
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    // Retrieve the existing cart from the session
	    List<Integer> cart = (List<Integer>) session.getAttribute("cart");
	    if (cart == null) {
	        cart = new ArrayList<>();
	    }

	    session.setAttribute("medicines", medicines);
	    session.setAttribute("cart", cart); // Set the existing cart back to the session
	    RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/views/Clinic/doctor/medicine.jsp");
	    rd.forward(request, response);
	}
}
