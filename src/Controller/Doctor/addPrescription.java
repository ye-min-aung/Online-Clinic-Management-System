package Controller.Doctor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import Model.Patient;
import Model.Prescription;


/**
 * Servlet implementation class addPrescription
 */
@WebServlet("/addPrescription")
public class addPrescription extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPrescription() {
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
		request.setCharacterEncoding("UTF-8"); // For incoming requests
	    response.setCharacterEncoding("UTF-8"); // For outgoing responses
		HttpSession session = request.getSession();
		
		String patientName = request.getParameter("patient_name");
		String doctorName = request.getParameter("doctor_name");
		String prescriptionDate = request.getParameter("prescription_date");
		String notes = request.getParameter("notes");
		
		List<Medicine> cartMedicines = new ArrayList<>();
		List<Integer> cart = (List<Integer>) session.getAttribute("cart");
		if (cart != null && !cart.isEmpty()) {
			List<Medicine> medicines = (List<Medicine>) session.getAttribute("medicines");
			if (medicines != null) {
				for (int medicineId : cart) {
					for (Medicine medicine : medicines) {
						if (medicine.getMedicine_id() == medicineId) {
							cartMedicines.add(medicine);
							break;
						}
					}
				}
			}
		}
		
		if(cartMedicines.size()>0) {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				con = DBConnection.getConnection();
				
				// Get the Patient ID from the Patient table
				pst = con.prepareStatement("SELECT patient_id FROM Patient WHERE patient_name=?");
				pst.setString(1, patientName);
				rs = pst.executeQuery();
				int patient_id = 0;
				if (rs.next()) {
					patient_id = rs.getInt("patient_id");
				}
				
				// Get the Doctor ID from the Doctor table
				pst = con.prepareStatement("SELECT doctor_id FROM Doctor WHERE doctor_name=?");
				pst.setString(1, doctorName);
				rs = pst.executeQuery();
				int doctor_id = 0;
				if (rs.next()) {
					doctor_id = rs.getInt("doctor_id");
				}
				
				// Save the prescription data in the Prescription table
				for(Medicine medicine : cartMedicines) {
					
					int frequency = Integer.parseInt(request.getParameter("frequency"));
					int duration =  Integer.parseInt(request.getParameter("duration"));
					
					pst = con.prepareStatement("INSERT INTO Prescription(patient_id, doctor_id, medicine_id, prescription_date, frequency, duration, notes) VALUES(?,?,?,?,?,?,?)");
					pst.setInt(1, patient_id);
					pst.setInt(2, doctor_id);
					pst.setInt(3, medicine.getMedicine_id());
					pst.setDate(4, Date.valueOf(prescriptionDate));
					pst.setInt(5, frequency);
					pst.setInt(6, duration);
					pst.setString(7, notes);
					pst.executeUpdate();
				}
				
				
				// Clear the cart after saving the prescription
				session.removeAttribute("cart");
				
				// Redirect to the Doctor's home page
			 // Stop further execution

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (pst != null) {
						pst.close();
					}
					if (con != null) {
						con.close();
					}
					if (rs != null) {
						rs.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		response.sendRedirect(request.getContextPath() + "/views/Clinic/doctor/index.jsp");
		return;
	}

}