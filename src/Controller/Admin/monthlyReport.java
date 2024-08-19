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
import Model.MonthlyReport;
import Model.Report;

/**
 * Servlet implementation class monthlyReport
 */
@WebServlet("/monthlyReport")
public class monthlyReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public monthlyReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    	HttpSession session=request.getSession();
//    	ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();
//        try {
//        	Connection conn = DBConnection.getConnection();
//            String query =  "SELECT "+
//            	    		"DATE_FORMAT(pr.prescription_date, '%Y-%m') AS month, "+
//            	    		"COUNT(*) AS monthly_Patients, "+
//            	    		"SUM(m.unit_price * pr.frequency * pr.duration) + SUM(d.consultation_fee) AS total_cost "+
//            	    		"FROM Prescription pr "+
//            	    		"JOIN Doctor d ON pr.doctor_id = d.doctor_id "+
//            	    		"JOIN Medicine m ON pr.medicine_id = m.medicine_id "+
//            	    		"GROUP BY month "+
//            	    		"ORDER BY month";    
//            PreparedStatement pstmt = conn.prepareStatement(query);
//            ResultSet rs = pstmt.executeQuery();
//            
//            while (rs.next()) {
//            	MonthlyReport report = new MonthlyReport();
//                report.setMonth(rs.getString("month"));
//                report.setTotalPatients(rs.getInt("monthly_Patients"));
//                report.setTotalCost(rs.getDouble("total_cost"));
//                monthlyReports.add(report);
//            }
//            System.out.println("hi");
//            		
//        } catch (SQLException e) {
//        	e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        session.setAttribute("monthlyReports",monthlyReports);
//		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/views/Clinic/admin/monthly.jsp");
//		rd.forward(request, response);
//    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();
        String year = request.getParameter("year");

        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT " +
                           "DATE_FORMAT(pr.prescription_date, '%Y-%m') AS month, " +
                           "COUNT(DISTINCT pr.patient_id) AS monthly_Patients, " +
                           "SUM(m.unit_price * pr.frequency * pr.duration) + SUM(d.consultation_fee) AS total_cost " +
                           "FROM Prescription pr " +
                           "JOIN Doctor d ON pr.doctor_id = d.doctor_id " +
                           "JOIN Medicine m ON pr.medicine_id = m.medicine_id ";

            if (year != null && !year.isEmpty()) {
                query += "WHERE DATE_FORMAT(pr.prescription_date, '%Y') = ? ";
            }
            
            query += "GROUP BY month " +
                     "ORDER BY month";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            if (year != null && !year.isEmpty()) {
                pstmt.setString(1, year);
            }
            
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                MonthlyReport report = new MonthlyReport();
                report.setMonth(rs.getString("month"));
                report.setTotalPatients(rs.getInt("monthly_Patients"));
                report.setTotalCost(rs.getDouble("total_cost"));
                monthlyReports.add(report);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        session.setAttribute("monthlyReports", monthlyReports);
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/views/Clinic/admin/monthly.jsp");
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
