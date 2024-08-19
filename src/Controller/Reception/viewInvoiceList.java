package Controller.Reception;

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
import Model.Invoice;
import Model.Patient;

@WebServlet("/Reception/viewInvoiceList")
public class viewInvoiceList extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	HttpSession session = request.getSession();

        try {
            DBConnection conn = new DBConnection();
            Connection connection = DBConnection.getConnection();

            String query = "SELECT p.patient_name , d.doctor_name, pr.prescription_date, d.consultation_fee, SUM(m.unit_price * pr.frequency * pr.duration) + d.consultation_fee AS total_cost " +
                    "FROM Prescription pr JOIN Patient p ON pr.patient_id = p.patient_id " +
                    "JOIN Doctor d ON pr.doctor_id = d.doctor_id " +
                    "JOIN Medicine m ON pr.medicine_id = m.medicine_id " +
                    "GROUP BY p.patient_name, d.doctor_name, pr.prescription_date, d.consultation_fee " +
                    "ORDER BY pr.prescription_date desc";

            PreparedStatement pstmt = connection.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Invoice> invoices = new ArrayList<Invoice>();

            while (rs.next()) {
            	
                Invoice i = new Invoice();
                
                i.setPatient_name(rs.getString("patient_name"));
                i.setDoctor_name(rs.getString("doctor_name"));
                i.setPrescription_date(rs.getDate("prescription_date"));
                i.setConsultation_fee(rs.getString("consultation_fee"));
                i.setTotal_cost(rs.getDouble("total_cost"));

                

                invoices.add(i);
            }

            request.setAttribute("invoices", invoices);

            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/views/Clinic/reception/displayInvoice.jsp");
            rd.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String searchName = request.getParameter("searchName");
    	
		HttpSession session=request.getSession();
		
        ArrayList<Invoice> invoices = new ArrayList<Invoice>();
		 
		try {
			
			DBConnection conn = new DBConnection();
            Connection connection = conn.getConnection();
           
            String query = "SELECT p.patient_name , d.doctor_name, pr.prescription_date, d.consultation_fee, SUM(m.unit_price * pr.frequency * pr.duration) + d.consultation_fee AS total_cost " +
                    "FROM Prescription pr JOIN Patient p ON pr.patient_id = p.patient_id " +
                    "JOIN Doctor d ON pr.doctor_id = d.doctor_id " +
                    "JOIN Medicine m ON pr.medicine_id = m.medicine_id " +
                    "WHERE patient_name LIKE ? OR doctor_name LIKE ? OR prescription_date LIKE ? "+
                    "GROUP BY p.patient_name, d.doctor_name, pr.prescription_date, d.consultation_fee " +
                    "ORDER BY pr.prescription_date desc";	           
	           PreparedStatement pstmt = connection.prepareStatement(query);
	           pstmt.setString(1, "%" + searchName + "%");
	           pstmt.setString(2, "%" + searchName + "%");
	           pstmt.setString(3, "%" + searchName + "%");
	           
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

	            request.setAttribute("invoices", invoices);

	            RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/views/Clinic/reception/displayInvoice.jsp");
	            rd.forward(request, response);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
    }
}
		
		
