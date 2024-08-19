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
import Model.Report;

/**
 * Servlet implementation class yearlyReport
 */
@WebServlet("/yearlyReport")
public class yearlyReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public yearlyReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session=request.getSession();
    	ArrayList<Report> yearlyReports = new ArrayList<>();
        try {
        	Connection conn = DBConnection.getConnection();
            String query =  "SELECT "+
            	    		"YEAR(pr.prescription_date) AS year, "+
            	    		"COUNT(DISTINCT pr.patient_id) AS yearly_Patients, "+
            	    		"SUM(m.unit_price * pr.frequency * pr.duration) + SUM(d.consultation_fee) AS total_cost "+
            	    		"FROM Prescription pr "+
            	    		"JOIN Doctor d ON pr.doctor_id = d.doctor_id "+
            	    		"JOIN Medicine m ON pr.medicine_id = m.medicine_id "+
            	    		"GROUP BY year "+
            	    		"ORDER BY year";   
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Report report = new Report();
                report.setDate(rs.getString("year"));
                report.setPatients(rs.getInt("yearly_Patients"));
                report.setTotalCost(rs.getDouble("total_cost"));
                yearlyReports.add(report);
            }
            		
        } catch (SQLException e) {
        	e.printStackTrace();
        } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        session.setAttribute("yearlyReports",yearlyReports);
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/admin/yearly.jsp");
		rd.forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
