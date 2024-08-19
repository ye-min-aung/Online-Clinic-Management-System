package Controller.Reception;

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
import Model.Invoice;
import Model.Patient;

/**
 * Servlet implementation class invoiceViewAll
 */
@WebServlet("/Reception/invoiceViewAll")
public class invoiceViewAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public invoiceViewAll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		 
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();
           
	           String query = "SELECT * FROM Invoice";
	           
	           PreparedStatement pstmt = connection.prepareStatement(query);
	           ResultSet rs = pstmt.executeQuery();
	           
	           while (rs.next()) {
	        	   
	        	   Invoice i = new Invoice();
	               i.setPatient_name(rs.getString("patient_name"));
	               i.setDoctor_name(rs.getString("doctor_name"));
	               i.setPrescription_date(rs.getDate("prescription_date"));
	               i.setConsultation_fee(rs.getString("consultation_fee"));
	               i.setTotal_cost(rs.getDouble("total_cost"));

	               invoices.add(i);
	           }
		}
		catch (ClassNotFoundException e){
			e.printStackTrace();
		}
			catch (SQLException e) {
				e.printStackTrace();
		}
		 request.setAttribute("invoices", invoices);

         RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/views/Clinic/reception/displayInvoice.jsp");
         rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
